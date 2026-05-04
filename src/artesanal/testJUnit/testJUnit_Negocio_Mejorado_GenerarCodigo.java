package artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class testJUnit_Negocio_Mejorado_GenerarCodigo {

	@Test
	void generarCodigoCorrectamente() {
		NegocioMejorado taberna = new NegocioMejorado();

		String codigo = taberna.generarCodigo();
		String regex = "^M-\\d{1,3}$";

		assertTrue(codigo.matches(regex));
	}
}
