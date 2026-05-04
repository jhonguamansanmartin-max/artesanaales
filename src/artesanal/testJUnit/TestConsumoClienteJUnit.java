package artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestConsumoClienteJUnit {

	@Test
	public void probarConsumo() {
		Maquina maquinaA = new Maquina("CRV_097", "Club", "ligera", 0.002, 8000);
		Negocio pub = new Negocio("Pub", maquinaA);
		Cliente c1 = new Cliente("Manolo", "12345");

		pub.cargarMaquinaA();

		pub.consumirCervezaMaquinaA(c1, 100);

		assertEquals(7700, maquinaA.getCantidadActual(), 0.0001);
		assertEquals(0.2, c1.getTotalConsumido(), 0.0001);

		pub.consumirCervezaMaquinaA(c1, 200);

		assertEquals(7500, maquinaA.getCantidadActual(), 0.0001);
		assertEquals(0.6, c1.getTotalConsumido(), 0.0001);

	}
}
