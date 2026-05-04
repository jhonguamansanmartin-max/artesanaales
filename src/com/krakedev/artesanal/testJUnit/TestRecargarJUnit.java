package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestRecargarJUnit {

	@Test
	public void testRecargaExitosa() {
		Maquina rubia = new Maquina("CRV_97", "Pilsener", "Cerveza", 0.02, 8000);
		boolean resultado = rubia.recargarCerveza(3000);

		assertTrue(resultado);
		assertEquals(3000, rubia.getCantidadActual());
	}

	@Test
	public void testRecargaFallida() {
		Maquina rubia = new Maquina("CRV_97", "Pilsener", "Cerveza", 0.02, 8000);
		rubia.recargarCerveza(7000);

		boolean resultado = rubia.recargarCerveza(800);
		assertTrue(resultado);
		assertEquals(7800, rubia.getCantidadActual());
	}
}
