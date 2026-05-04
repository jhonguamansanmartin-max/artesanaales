package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class testJUnit_Negocio_Mejorado_ConsultarValorVendido {

	@Test
	void consultarValorObtenido_ValorTotalCorrecto() {
		NegocioMejorado taberna = new NegocioMejorado();

		taberna.agregarMaquina("Pilsener", "Cerveza", 0.02);
		taberna.agregarMaquina("Corona", "Importada", 0.06);
		String codigo1 = taberna.getMaquinas().get(0).getCodigo();
		String codigo2 = taberna.getMaquinas().get(1).getCodigo();
		taberna.cargarMaquinas();

		taberna.registrarCliente("Manolo", "123467");
		taberna.registrarCliente("Sofia", "456894");

		taberna.consumirCerveza(100, codigo1, 4500);

		taberna.consumirCerveza(101, codigo2, 300);

		taberna.consumirCerveza(100, codigo2, 1000);

		taberna.consumirCerveza(101, codigo1, 600);

		taberna.consumirCerveza(101, codigo2, 4035);

		assertEquals(422.1, taberna.consultarValorVendido(), 0.001);
	}
}
