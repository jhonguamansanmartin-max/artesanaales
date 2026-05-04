package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maquina rubia = new Maquina("CRV_97", "Pilsener", "Cerveza rubia", 0.02, 8000);
		rubia.imprimir();
		rubia.llenarMaquina();
		rubia.imprimir();

		Maquina negra = new Maquina("CRV_98", "Club", "Cerveza oscura", 0.03);
		negra.imprimir();
		negra.llenarMaquina();
		negra.imprimir();
	}

}
