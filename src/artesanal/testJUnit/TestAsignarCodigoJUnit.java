package artesanal.testJUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Negocio;

public class TestAsignarCodigoJUnit {

	@Test
	public void asignarCodigo() {
		Negocio pub = new Negocio();
		Cliente cliente1 = new Cliente("Pancracio", "12345");
		Cliente cliente2 = new Cliente("Rodolfo", "123456");

		pub.asignarCodigoCliente(cliente1);
		pub.asignarCodigoCliente(cliente2);

		assertEquals(100, cliente1.getCodigo());
		assertEquals(101, cliente2.getCodigo());
	}
}
