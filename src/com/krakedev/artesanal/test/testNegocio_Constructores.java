package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class testNegocio_Constructores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Maquina m1 = new Maquina("CRV_097", "Club", "Cerveza ligera", 0.02, 8000);
		Negocio negocio1 = new Negocio("Mi negocio", m1);

		System.out.println("Nombre: " + negocio1.getNombre());
		System.out.println("Maquina: " + negocio1.getMaquinaA());

		Maquina m2Null = negocio1.getMaquinaA();

		double capacidad = m1.getCapacidadMaxima();

	}

}
