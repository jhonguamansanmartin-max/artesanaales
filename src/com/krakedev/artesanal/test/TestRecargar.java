package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestRecargar {

	public static void main(String[] args) {
		boolean resultado;

		Maquina rubia = new Maquina("pilsener", "cervesa fria ", 0.02, 8000);

		System.out.println("---------iniciando-------------");

		rubia.imprimir();

		System.out.println("---------recarga 1-----------");

		resultado = rubia.recargarCerveza(3000);

		System.out.println("Se recargo completamente : " + resultado);

		rubia.imprimir();

		System.out.println("---------recarga 2 -----------");

		resultado = rubia.recargarCerveza(2000);
		
		rubia.imprimir();
		
		System.out.println("Se recargo completamente : " + resultado);

		System.out.println("---------recarga 3 -----------");

		resultado = rubia.recargarCerveza(2900);

		rubia.imprimir();
		
		System.out.println("Se recargo completamente : " + resultado);


	}

}
