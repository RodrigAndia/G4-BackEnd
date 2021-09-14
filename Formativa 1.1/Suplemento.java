package com.everis.formativa1;

public class Suplemento {

	private String codigo;
	private double precioBase;
	private String nombre;
	private boolean generico;
	private int cantVitaminas;
	private String infoVitaminas;
	private String contraindicaciones;
	
	
	
	//constructor
	public Suplemento(String codigo, double precioBase, String nombre, boolean generico, int cantVitaminas,
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
	public boolean getGenerico() {
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
		return "Suplementos [codigo=" + codigo + ", precioBase=" + precioBase + ", nombre=" + nombre + ", generico="
				+ generico + ", cantVitaminas=" + cantVitaminas + ", infoVitaminas=" + infoVitaminas
				+ ", contraindicaciones=" + contraindicaciones + "]";
	}
	
	
	public void descontarSuplemento() {
		double baseFinal=0;
		
		baseFinal=this.getPrecioBase()-(this.getPrecioBase()*0.1);
		System.out.println(baseFinal);
	}


	public void recargarSuplemento() {
	
		double precioVenta=0;
	
		precioVenta=this.getPrecioBase()+this.getCantVitaminas()*(this.getPrecioBase()*(0.02));
		System.out.println("Se ha aplicado recargo: "+precioVenta);
				
	}
	
}
