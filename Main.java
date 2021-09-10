package com.everis.formativa1;

public class Main {

	public static void main(String[] args) {
		
		Medicamento medicamento1=new Medicamento("1111",10500,"medicamento1",true,3,"muy buenas","adiccion");
		medicamento1.descontarMedicamento("lunes");
		
		Suplemento suplemento1=new Suplemento("01111",10500,"suplemento1",true,4,"super buenas","sueño");
		suplemento1.descontarSuplemento();
		
		Medicamento medicamento2=new Medicamento("1112",9500,"medicamento1",true,5,"muy buenas","adiccion");
		medicamento1.descontarMedicamento("lunes");
		
		Suplemento suplemento2=new Suplemento("01112",1500,"suplemento1",true,6,"super buenas","sueño");
		suplemento1.descontarSuplemento();
		
		
		RegistroProducto productos=new RegistroProducto();
		productos.registrarMedicamento(medicamento1);
		productos.registrarSuplemento(suplemento1);
		productos.registrarMedicamento(medicamento2);
		productos.registrarSuplemento(suplemento2);
		
		System.out.println("Cantidad Productos");
		System.out.println(productos.getCantProductos());
		System.out.println();
		
		System.out.println("Listar Total de Productos");
		productos.toString();
		System.out.println();
		
		System.out.println("Listar de Productos mayores a 10000");
		productos.listarProductos();
		System.out.println();
		
		System.out.println("Eliminar de Productos menores a 2000");
		productos.eliminarProductos();
		System.out.println();
		
		System.out.println("Listar Total de Productos");
		System.out.println(productos.toString());
		System.out.println();
	}

}
