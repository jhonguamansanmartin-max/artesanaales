package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestAtributos {

	public static void main(String[] args) {
		
		Maquina rubia = new Maquina("Pilsener" , "cervesa artesanal" , 0.02 , 1000) ;
		
		rubia.imprimir();
	
		rubia.setDescripcion("Golden");
		rubia.setDescripcion("aroma mas intenso");
		rubia.imprimir();
	}

}
