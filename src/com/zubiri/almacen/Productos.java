package com.zubiri.almacen;

import java.util.ArrayList;
import java.util.Scanner;

public class Productos {
	
	private ArrayList<Producto> listaProductos = new ArrayList<Producto>();	
	
	public Productos(Scanner sc) {
		do{
			try{
				System.out.println("¿Cuantos productos quieres insertar? ");
				int seleccion = sc.nextInt();
			}catch(InputMismatchException e){
				System.out.println("No ha insertado la opción correcta");
				sc.nextLine();
			}
		}while(seleccion<0);	
		for (int i = 0; i < seleccion; i++) {
			try{
				System.out.println("¿Qué producto quieres insertar?");
				System.out.println("MANZANA:--------1");
				System.out.println("LECHE:----------2");
				System.out.println("LECHUGA:--------3");
			    
				switch(sc.nextInt()) {
					case 1:
						Manzana manzana = new Manzana(sc);
						listaProductos.add(manzana);
						break;
					case 2:
						Leche leche = new Leche(sc);
						listaProductos.add(leche);
						break;
					case 3:
						Lechuga lechuga = new Lechuga(sc);
						listaProductos.add(lechuga);
						break;
					default:
						System.out.println("No ha insertado la opción correcta.");
						break;
				}
			}catch(InputMismatchException e){
				System.out.println("No ha insertado la opción correcta"")
				sc.nextLine();
			}
		}
	} 
		 
	public void mostrarProductos() {
		
		if (listaProductos.size() == 0) {
			System.out.println("No se han cargado los productos");
		}
		for (int i = 0;i < listaProductos.size();i++) {
			Producto producto = listaProductos.get(i);
			producto.mostrarProducto(); //dispatching dinámico a partir de polimorfismo
		}
	}

}
