package artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class testJUnit_Negocio_Mejorado_consumirCerveza {

	@Test
	void consumiCerveza_ValoresCorrectos_ClienteActualizado() {
		NegocioMejorado taberna = new NegocioMejorado();

		taberna.agregarMaquina("Pilsener", "Cerveza", 0.02);
		String codigo = taberna.getMaquinas().get(0).getCodigo();
		taberna.cargarMaquinas();

		taberna.registrarCliente("Manolo", "123467");

		taberna.consumirCerveza(100, codigo, 600); // EL CLIENTE REALIZA EL PRIMER CONSUMO
		assertEquals(9200, taberna.getMaquinas().get(0).getCantidadActual());

		taberna.consumirCerveza(100, codigo, 800); // EL CLIENTE REALIZA EL SEGUNDO CONSUMO
		assertEquals(8400, taberna.getMaquinas().get(0).getCantidadActual());

		assertEquals(28, taberna.buscarClientePorCodigo(100).getTotalConsumido(), 0.001); // VALOR DE LOS DOS PRIMEROS
																							// CONSUMOS

		taberna.consumirCerveza(100, codigo, 200); // EL CLIENTE REALIZA EL TERCER CONSUMO
		assertEquals(8200, taberna.getMaquinas().get(0).getCantidadActual());

		assertEquals(32, taberna.buscarClientePorCodigo(100).getTotalConsumido(), 0.001); // VALOR DE LOS TRES CONSUMOS
	}

	@Test
	void consumirCerveza_MaquinaAfectada() {
		NegocioMejorado taberna = new NegocioMejorado();

		taberna.agregarMaquina("Pilsener", "Cerveza", 0.02);
		taberna.agregarMaquina("Corona", "Importada", 0.06);
		String codigo1 = taberna.getMaquinas().get(0).getCodigo();
		String codigo2 = taberna.getMaquinas().get(1).getCodigo();
		taberna.cargarMaquinas();

		taberna.registrarCliente("Manolo", "123467");

		taberna.consumirCerveza(100, codigo1, 4500); // SE REALIZA DOS CONSUMOS EN LA MAQUINA 0 DEL ARRAYLIST

		taberna.consumirCerveza(100, codigo2, 300);

		taberna.consumirCerveza(100, codigo2, 1000); // SE REALIZA TRES CONSUMOS EN LA MAQUINA 1 DEL ARRAYLIST

		taberna.consumirCerveza(100, codigo1, 600);

		taberna.consumirCerveza(100, codigo2, 4035);

		assertEquals(4700, taberna.getMaquinas().get(0).getCantidadActual()); // VALIDA QUE EL VALOR RESTANTE SEA EL
																				// CORRECTO, CONSIDERANDO EL CONSUMO
		assertEquals(4465, taberna.getMaquinas().get(1).getCantidadActual()); // VALIDA QUE EL VALOR RESTANTE SEA EL
																				// CORRECTO, CONSIDERANDO EL CONSUMO

	}
}
