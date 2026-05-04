package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	private ArrayList<Maquina> maquinas;
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private int ultimoCodigo = 100;

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public NegocioMejorado() {
		maquinas = new ArrayList<Maquina>();
	}

	public String generarCodigo() {
		int numerico = (int) (Math.random() * 100) + 1;

		String codigo = "M-" + numerico;

		return codigo;
	}

	public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
		String codigo = generarCodigo();
		Maquina m = recuperarMaquina(codigo);
		if (m != null) {
			return false;
		} else {
			Maquina taberna = new Maquina(codigo, nombreCerveza, descripcion, precioPorMl);
			maquinas.add(taberna);
			return true;
		}
	}

	public void cargarMaquinas() {
		for (int i = 0; i < maquinas.size(); i++) {
			Maquina m = maquinas.get(i);
			m.llenarMaquina();
		}
	}

	public Maquina recuperarMaquina(String codigo) {
		Maquina m;
		for (int i = 0; i < maquinas.size(); i++) {
			m = maquinas.get(i);
			if (codigo.equals(m.getCodigo())) {
				return m;
			}
		}
		return null;
	}

	public void registrarCliente(String nombre, String cedula) {
		Cliente cliente = new Cliente(nombre, cedula);
		cliente.setCodigo(ultimoCodigo);
		ultimoCodigo++;
		clientes.add(cliente);
	}

	public Cliente buscarClientePorCedula(String cedula) {
		Cliente c;
		for (int i = 0; i < clientes.size(); i++) {
			c = clientes.get(i);
			if (cedula.equals(c.getCedula())) {
				return c;
			}
		}
		return null;
	}

	public Cliente buscarClientePorCodigo(int codigo) {
		Cliente c;
		for (int i = 0; i < clientes.size(); i++) {
			c = clientes.get(i);
			if (codigo == c.getCodigo()) {
				return c;
			}
		}
		return null;
	}

	public void consumirCerveza(int codigo, String codMaquina, double cantidad) {
		Maquina m = recuperarMaquina(codMaquina);
		Cliente c = buscarClientePorCodigo(codigo);
		double valorConsumido = m.servirCerveza(cantidad);
		registrarConsumo(c, valorConsumido);

	}

	public void registrarConsumo(Cliente cliente, double valorConsumido) {
		double valorTotal = cliente.getTotalConsumido() + valorConsumido;
		cliente.setTotalConsumido(valorTotal);
	}

	public double consultarValorVendido() {
		double valorTotal = 0;
		for (int i = 0; i < clientes.size(); i++) {
			Cliente c = clientes.get(i);
			valorTotal += c.getTotalConsumido();
		}
		return valorTotal;
	}
}
