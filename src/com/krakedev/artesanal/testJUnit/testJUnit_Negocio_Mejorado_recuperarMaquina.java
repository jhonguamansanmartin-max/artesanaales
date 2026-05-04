package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class testJUnit_Negocio_Mejorado_recuperarMaquina {

	@Test
	void recuperarMaquinas_RetornaMaquinas() {

		NegocioMejorado taberna = new NegocioMejorado();

		taberna.agregarMaquina("Pilsener", "Cerveza", 0.02);

		taberna.agregarMaquina("Corona", "Importada", 0.06);

		taberna.agregarMaquina("Club", "Nacional", 0.04);

		ArrayList<Maquina> m = taberna.getMaquinas();

		String codigo1 = m.get(0).getCodigo();
		String codigo2 = m.get(1).getCodigo();
		String codigo3 = m.get(2).getCodigo();

		assertNotNull(taberna.recuperarMaquina(codigo1)); // RETORNA LA MAQUINA POR QUE EXISTE EL CODIGO
		assertNotNull(taberna.recuperarMaquina(codigo2)); // RETORNA LA MAQUINA POR QUE EXISTE EL CODIGO
		assertNotNull(taberna.recuperarMaquina(codigo3)); // RETORNA LA MAQUINA POR QUE EXISTE EL CODIGO
	}

	@Test
	void recuperarMaquinas_RetornaNull() {

		NegocioMejorado taberna = new NegocioMejorado();

		taberna.agregarMaquina("Pilsener", "Cerveza", 0.02);

		taberna.agregarMaquina("Corona", "Importada", 0.06);

		taberna.agregarMaquina("Club", "Nacional", 0.04);

		ArrayList<Maquina> m = taberna.getMaquinas();

		String codigo1 = "M-12345";
		String codigo2 = m.get(1).getCodigo();
		String codigo3 = "M-567457";

		assertNull(taberna.recuperarMaquina(codigo1)); // RETORNA NULL YA QUE EL CODIGO NO EXISTE
		assertNotNull(taberna.recuperarMaquina(codigo2)); // RETORNA LA MAQUINA POR QUE EXISTE EL CODIGO
		assertNull(taberna.recuperarMaquina(codigo3)); // RETORNA NULL YA QUE EL CODIGO NO EXISTE
	}
}
