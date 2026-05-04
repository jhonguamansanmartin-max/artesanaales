package com.krakedev.artesanal;

public class Maquina {
	private String nombreCerveza;
	private String descripcion;
	private double precioPorMl;
	private double capacidadMaxima;
	private double cantidadActual;

	public Maquina(String nombreCerveza, String descripcion, double precioPorMl, double capacidadMaxima) {

		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMaxima = capacidadMaxima;
		this.cantidadActual = 0;

	}

	public Maquina(String nombreCerveza, String descripcion, double precioPorMl) {

		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMaxima = 1000;
		this.cantidadActual = 0;

	}

	public String getNombreCerveza() {
		return nombreCerveza;
	}

	public void setNombreCerveza(String nombreCerveza) {
		this.nombreCerveza = nombreCerveza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioPorMl() {
		return precioPorMl;
	}

	public void setPrecioPorMl(double precioPorMl) {
		this.precioPorMl = precioPorMl;
	}

	public double getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public double getCantidadActual() {
		return cantidadActual;
	}

	public void imprimir() {
		String mensaje;
		mensaje = "nombre cerveza : " + nombreCerveza
				+ ", Descripcion " + descripcion 
				+ ", capacidad máxima " + capacidadMaxima 
				+ ",precio por ml " + precioPorMl
				+ ", cantidad Actual " + cantidadActual;

		System.out.println(mensaje);

	}
	
	public void llenarMaquina() {
		this.cantidadActual = this.capacidadMaxima - 100 ;
		
	}
	
	public boolean recargarCerveza(double cantidad) {
		double limitePermitido;
		limitePermitido = capacidadMaxima - 100;
		
		if(cantidadActual +cantidad <= limitePermitido ) {
			
			cantidadActual = cantidadActual+cantidad;
			return true ;
		
		}else {
			return false;
			
					
			
			
					
			
		}
		
	}

}
