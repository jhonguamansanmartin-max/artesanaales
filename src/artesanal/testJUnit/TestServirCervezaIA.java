package artesanal.testJUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

/**
 * Clase de pruebas unitarias para el método servirCerveza de la clase Maquina.
 * Se basa en la descripción del comportamiento externo, no en la
 * implementación.
 */
public class TestServirCervezaIA {

	private Maquina maquina;
	private final double PRECIO_POR_ML = 0.05; // 5 céntimos por ml
	private final double CAPACIDAD_MAXIMA = 10000.0;
	private final double DELTA = 0.001; // Tolerancia para comparaciones double

	@BeforeEach
	public void setUp() {
		// Se usa el constructor que recibe nombre, descripción y precioPorMl
		maquina = new Maquina("CRV_97", "IPA Artesanal", "Cerveza lupulada y amarga", PRECIO_POR_ML);
		// Capacidad máxima por defecto es 10000.0 ml
	}

	/*
	 * CASOS DE PRUEBA PARA CUANDO HAY SUFICIENTE CERVEZA
	 */

	@Test
	public void testServirCerveza_CantidadExactaDisponible_RetornaValorCorrecto_Y_RestaCantidad() {
		// Validar que al servir una cantidad exactamente igual a la cantidad actual,
		// se retorna el valor correcto y la cantidad actual queda en 0.
		double cantidadInicial = 500.0;
		maquina.recargarCerveza(cantidadInicial); // Recargamos para tener 500 ml
		double cantidadServir = 500.0;
		double valorEsperado = cantidadServir * PRECIO_POR_ML;

		double valorCobrado = maquina.servirCerveza(cantidadServir);

		assertEquals(valorEsperado, valorCobrado, DELTA, "El valor cobrado debe ser cantidad * precioPorMl");
		assertEquals(0.0, maquina.getCantidadActual(), DELTA, "La cantidad actual debe quedar en 0");
	}

	@Test
	public void testServirCerveza_CantidadMenorQueDisponible_RetornaValorCorrecto_Y_RestaCantidad() {
		// Validar que al servir una cantidad menor que la disponible,
		// se retorna el valor correcto y la cantidad actual se reduce adecuadamente.
		double cantidadInicial = 800.0;
		maquina.recargarCerveza(cantidadInicial);
		double cantidadServir = 300.0;
		double valorEsperado = cantidadServir * PRECIO_POR_ML;
		double cantidadEsperadaRestante = cantidadInicial - cantidadServir;

		double valorCobrado = maquina.servirCerveza(cantidadServir);

		assertEquals(valorEsperado, valorCobrado, DELTA, "El valor cobrado debe ser cantidad * precioPorMl");
		assertEquals(cantidadEsperadaRestante, maquina.getCantidadActual(), DELTA,
				"La cantidad actual debe ser la inicial menos la servida");
	}

	@Test
	public void testServirCerveza_CantidadCero_RetornaCero_Y_NoModificaCantidad() {
		// Validar que al pedir 0 ml, se retorna 0 y la cantidad actual no cambia.
		double cantidadInicial = 200.0;
		maquina.recargarCerveza(cantidadInicial);
		double cantidadServir = 0.0;

		double valorCobrado = maquina.servirCerveza(cantidadServir);

		assertEquals(0.0, valorCobrado, DELTA, "El valor cobrado por 0 ml debe ser 0");
		assertEquals(cantidadInicial, maquina.getCantidadActual(), DELTA,
				"La cantidad actual no debe modificarse al pedir 0 ml");
	}

	/*
	 * CASOS DE PRUEBA PARA CUANDO NO HAY SUFICIENTE CERVEZA
	 */

	@Test
	public void testServirCerveza_CantidadMayorQueDisponible_RetornaCero_Y_NoModificaCantidad() {
		// Validar que al pedir más de lo disponible, se retorna 0
		// y la cantidad actual permanece inalterada.
		double cantidadInicial = 150.0;
		maquina.recargarCerveza(cantidadInicial);
		double cantidadServir = 200.0;

		double valorCobrado = maquina.servirCerveza(cantidadServir);

		assertEquals(0.0, valorCobrado, DELTA, "Si no hay suficiente, no se sirve nada y se retorna 0");
		assertEquals(cantidadInicial, maquina.getCantidadActual(), DELTA,
				"La cantidad actual no debe cambiar si no se pudo servir");
	}

	@Test
	public void testServirCerveza_CantidadMayorQueDisponible_ConCantidadActualCero() {
		// Validar cuando la máquina está vacía (cantidadActual = 0)
		// y se solicita cualquier cantidad positiva: retorna 0 y no modifica cantidad.
		// Nota: El constructor inicializa cantidadActual en 0.
		double cantidadServir = 50.0;

		double valorCobrado = maquina.servirCerveza(cantidadServir);

		assertEquals(0.0, valorCobrado, DELTA, "Con máquina vacía, cualquier pedido positivo debe retornar 0");
		assertEquals(0.0, maquina.getCantidadActual(), DELTA, "La cantidad actual debe seguir siendo 0");
	}

	@Test
	public void testServirCerveza_CantidadJustoPorEncimaDeDisponible_NoSirve() {
		// Validar un caso límite: disponible 100 ml, se pide 100.0001 ml.
		// Debe fallar por cantidad insuficiente.
		double cantidadInicial = 100.0;
		maquina.recargarCerveza(cantidadInicial);
		double cantidadServir = 100.0001;

		double valorCobrado = maquina.servirCerveza(cantidadServir);

		assertEquals(0.0, valorCobrado, DELTA, "Pedir una cantidad ligeramente superior a la disponible debe fallar");
		assertEquals(cantidadInicial, maquina.getCantidadActual(), DELTA,
				"La cantidad no debe disminuir si el pedido excede lo disponible");
	}

	/*
	 * CASOS DE PRUEBA DE PRECISIÓN EN CÁLCULO DEL VALOR
	 */

	@Test
	public void testServirCerveza_CalculoValorConDecimales() {
		// Validar que el cálculo del valor a pagar maneja correctamente decimales.
		double precioPorMlEspecial = 0.035; // 3.5 céntimos
		// Usamos el constructor que permite especificar precio y capacidad máxima
		Maquina maquinaEspecial = new Maquina("CRV_97", "Lager", "Suave", precioPorMlEspecial, 5000.0);
		double cantidadInicial = 250.0;
		maquinaEspecial.recargarCerveza(cantidadInicial);
		double cantidadServir = 123.45;
		double valorEsperado = cantidadServir * precioPorMlEspecial;

		double valorCobrado = maquinaEspecial.servirCerveza(cantidadServir);

		assertEquals(valorEsperado, valorCobrado, DELTA,
				"El valor debe calcularse exactamente como cantidad * precioPorMl");
		assertEquals(cantidadInicial - cantidadServir, maquinaEspecial.getCantidadActual(), DELTA,
				"La cantidad restante debe reflejar la resta exacta");
	}

	/*
	 * CASOS DE PRUEBA DE CONSISTENCIA TRAS MÚLTIPLES OPERACIONES
	 */

	@Test
	public void testServirCerveza_ServiciosSucesivos_HastaAgotar() {
		// Validar que varios servicios consecutivos funcionan correctamente
		// y que al agotarse deja de servir.
		double cantidadInicial = 1000.0;
		maquina.recargarCerveza(cantidadInicial);

		// Primer servicio: 400 ml
		double valor1 = maquina.servirCerveza(400.0);
		assertEquals(400.0 * PRECIO_POR_ML, valor1, DELTA);
		assertEquals(600.0, maquina.getCantidadActual(), DELTA);

		// Segundo servicio: 300 ml
		double valor2 = maquina.servirCerveza(300.0);
		assertEquals(300.0 * PRECIO_POR_ML, valor2, DELTA);
		assertEquals(300.0, maquina.getCantidadActual(), DELTA);

		// Tercer servicio: 300 ml (justo lo que queda)
		double valor3 = maquina.servirCerveza(300.0);
		assertEquals(300.0 * PRECIO_POR_ML, valor3, DELTA);
		assertEquals(0.0, maquina.getCantidadActual(), DELTA);

		// Cuarto servicio: 1 ml (ya vacía)
		double valor4 = maquina.servirCerveza(1.0);
		assertEquals(0.0, valor4, DELTA);
		assertEquals(0.0, maquina.getCantidadActual(), DELTA);
	}

	@Test
	public void testServirCerveza_ConLlenarMaquina_NoSuperaCapacidadPermitida() {
		// Validar interacción con llenarMaquina() y el límite de recarga.
		// llenarMaquina() establece cantidadActual = capacidadMaxima - 100
		maquina.llenarMaquina();
		double cantidadTrasLlenar = maquina.getCantidadActual();
		assertEquals(CAPACIDAD_MAXIMA - 200.0, cantidadTrasLlenar, DELTA,
				"Tras llenar, debe tener capacidadMaxima - 100");

		// Servir una cantidad válida (menor que lo disponible)
		double cantidadServir = 500.0;
		double valor = maquina.servirCerveza(cantidadServir);
		assertEquals(cantidadServir * PRECIO_POR_ML, valor, DELTA);
		assertEquals(cantidadTrasLlenar - cantidadServir, maquina.getCantidadActual(), DELTA);

		// Intentar servir más de lo que queda
		double cantidadExcedente = maquina.getCantidadActual() + 10.0;
		double valorExcedente = maquina.servirCerveza(cantidadExcedente);
		assertEquals(0.0, valorExcedente, DELTA);
		// La cantidad no debe haber cambiado
		assertEquals(cantidadTrasLlenar - cantidadServir, maquina.getCantidadActual(), DELTA);
	}
}