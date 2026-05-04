package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class testJUnit_Negocio_Mejorado_BuscarClientePorCodigo {

	@Test
	void buscarCliente_RetornoCliente() {
		NegocioMejorado taberna = new NegocioMejorado();

		taberna.registrarCliente("Manolo", "123467");
		taberna.registrarCliente("Sofia", "098782");

		Cliente cliente1 = taberna.getClientes().get(0);
		Cliente cliente2 = taberna.getClientes().get(1);

		assertEquals(cliente1, taberna.buscarClientePorCodigo(100));
		assertEquals(cliente2, taberna.buscarClientePorCodigo(101));

	}
}
