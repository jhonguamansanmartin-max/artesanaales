package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestServir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Maquina rubia = new Maquina("CRV_97", "Pilsener", "Cerveza rubia", 0.02, 8000);
		System.out.println("--------Estado Inicial-------");
		rubia.imprimir();
		System.out.println("------Llenando Maquina-------");
		rubia.llenarMaquina();
		rubia.imprimir();
		System.out.println("------Siriviendo 1000ml------");
		double valor;
		valor = rubia.servirCerveza(1000);
		System.out.println("Valor a pagar: " + valor);
		rubia.imprimir();
		System.out.println("------Siriviendo 2000ml------");
		valor = rubia.servirCerveza(2000);
		System.out.println("Valor a pagar: " + valor);
		rubia.imprimir();
		System.out.println("------Siriviendo 6000ml------");
		valor = rubia.servirCerveza(6000);
		System.out.println("Valor a pagar: " + valor);
		rubia.imprimir();

	}

}
