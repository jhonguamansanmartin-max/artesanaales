package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class testJUnit_Negocio_Mejorado_CargarMaquinas {

	@Test
	void cargarMaquinasCorrectamente() {

		NegocioMejorado taberna = new NegocioMejorado();

		taberna.agregarMaquina("Pilsener", "Cerveza", 0.02);

		taberna.agregarMaquina("Corona", "Importada", 0.06);

		taberna.agregarMaquina("Club", "Nacional", 0.04);

		taberna.cargarMaquinas();

		ArrayList<Maquina> m = taberna.getMaquinas();

		assertEquals(9800, m.get(0).getCantidadActual());
		assertEquals(9800, m.get(1).getCantidadActual());
		assertEquals(9800, m.get(2).getCantidadActual());
	}
}
