package com.everis.formativa1;

public class Medicamento {
	
	private String codigo;
	private double precioBase;
	private String nombre;
	private boolean generico;
	private int cantVitaminas;
	private String infoVitaminas;
	private String contraindicaciones;
	
	
	//constructor
	public Medicamento(String codigo, double precioBase, String nombre, boolean generico, int cantVitaminas,
			String infoVitaminas, String contraindicaciones) {
		super();
		this.codigo = codigo;
		this.precioBase = precioBase;
		this.nombre = nombre;
		this.generico = generico;
		this.cantVitaminas = cantVitaminas;
		this.infoVitaminas = infoVitaminas;
		this.contraindicaciones = contraindicaciones;
	}

	
	//getter & setters
	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public double getPrecioBase() {
		return precioBase;
	}


	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public boolean isGenerico() {
		return generico;
	}


	public void setGenerico(boolean generico) {
		this.generico = generico;
	}


	public int getCantVitaminas() {
		return cantVitaminas;
	}


	public void setCantVitaminas(int cantVitaminas) {
		this.cantVitaminas = cantVitaminas;
	}


	public String getInfoVitaminas() {
		return infoVitaminas;
	}


	public void setInfoVitaminas(String infoVitaminas) {
		this.infoVitaminas = infoVitaminas;
	}


	public String getContraindicaciones() {
		return contraindicaciones;
	}


	public void setContraindicaciones(String contraindicaciones) {
		this.contraindicaciones = contraindicaciones;
	}


	@Override
	public String toString() {
		return "Medicamentos [codigo=" + codigo + ", precioBase=" + precioBase + ", nombre=" + nombre + ", generico="
				+ generico + ", cantVitaminas=" + cantVitaminas + ", infoVitaminas=" + infoVitaminas
				+ ", contraindicaciones=" + contraindicaciones + "]";
	}
	
	public void descontarMedicamento(String dia) {
		double baseFinal=0;
			if(generico==true) {
			if(dia.equalsIgnoreCase("lunes")) {
				baseFinal=precioBase-(precioBase*0.1);
				System.out.println(baseFinal);
				}
				else {
				System.out.println("no es lunes, no tiene descuento: "+precioBase);
				}
			}
			else {
			System.out.println("No es medicamento generico, no tiene descuento: "+precioBase);
			}
		}

	public void recargarMedicamento() {
		double precioVenta=0;
		if(generico==false) {
			precioVenta=precioBase+(precioBase*0.2);
			System.out.println("Se ha aplicado recargo: "+precioVenta);
		}
		else {
			System.out.println("No se aplica recargo");
		}
	}

}
