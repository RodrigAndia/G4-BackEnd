package com.everis.formativa1;

import java.util.ArrayList;

public class RegistroProducto {
	private ArrayList<Medicamento> medicamentos;
	private ArrayList<Suplemento> suplementos;
	
	public RegistroProducto() {
		super();
		this.medicamentos = new ArrayList<Medicamento>();
		this.suplementos = new ArrayList<Suplemento>();
	}

	public ArrayList<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public ArrayList<Suplemento> getSuplementos() {
		return suplementos;
	}

	public void setSuplementos(ArrayList<Suplemento> suplementos) {
		this.suplementos = suplementos;
	}

	public int getCantProductos()
	{
		return this.medicamentos.size() + this.suplementos.size();
	}

	public void registrarMedicamento(Medicamento medicamento)
	{
		int flag=0;
		for (Medicamento medicamento_ : this.medicamentos) {
			if (medicamento.getCodigo().equals(medicamento_.getCodigo()))
			{
				flag=1;
			}
		}
		if (flag == 0)
		{
			medicamentos.add(medicamento);
		}
	}

	public void registrarSuplemento(Suplemento suplemento)
	{
		int flag=0;
		for (Suplemento suplemento_ : this.suplementos) {
			if (suplemento.getCodigo().equals(suplemento_.getCodigo()))
			{
				flag=1;
			}
		}
		if (flag == 0)
		{
			suplementos.add(suplemento);
		}
	}

	public void listarProductos()
	{
		for (Suplemento suplemento_ : this.suplementos) {
			if (suplemento_.getPrecioBase()>10000)
			{
				System.out.println(suplemento_.toString());
			}	
		}
		for (Medicamento medicamento_ : this.medicamentos) {
			if (medicamento_.getPrecioBase()>10000)
			{
				System.out.println(medicamento_.toString());
			}	
		}
	}
	
	public void eliminarProductos()
	{
		ArrayList<Medicamento> removeMedicamentos = new ArrayList<Medicamento>();
		ArrayList<Suplemento> removeSuplementos = new ArrayList<Suplemento>();
		for (Suplemento suplemento_ : this.suplementos) {
			if (suplemento_.getPrecioBase()<2000)
			{
				removeSuplementos.add(suplemento_);
			}	
		}
		for (Medicamento medicamento_ : this.medicamentos) {
			if (medicamento_.getPrecioBase()<2000)
			{
				removeMedicamentos.add(medicamento_);
			}	
		}
		for (int i=0; i<removeSuplementos.size();i++)
		{
			this.suplementos.remove(removeSuplementos.get(i));
		}
		for (int i=0; i<removeMedicamentos.size();i++)
		{
			this.medicamentos.remove(removeMedicamentos.get(i));
		}
	}
	
	@Override
	public String toString() {
		return "RegistroProducto [medicamentos=" + medicamentos + ", suplementos=" + suplementos + "]";
	}
	
	
	
}
