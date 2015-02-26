package com.zubiri.almacen;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) throws IOException,UnsupportedEncodingException {
	
		int seleccion=0;
		Scanner sc = new Scanner(System.in);
		Productos productos = null;
		
		if (args.length == 0) {
			System.out.println("El número de argumentos no es válido:");
			System.out.println("java main.java <fichero_distribuidores>");
			System.exit(-1);
		} 
		
    	//Leemos la lista de distribuidores del fichero.
		Distribuidores.leerDistribuidores(args[0]);

		do {
			try{
				//Visualiza por terminal (stdout) las opciones del men�
				System.out.println("Mostrar distribuidores---------------------------1");
				System.out.println("Solicitar productos------------------------------2");
				System.out.println("Mostrar productos--------------------------------3");
				System.out.println("SALIR DEL PROGRAMA-------------------------------4");
				   
				seleccion = sc.nextInt();
				switch (seleccion) {
					
					case 1: //Mostrar distribuidores
						Distribuidores.mostrarDistribuidores();
						break;
						
					case 2: //Solicitar productos
						productos = new Productos(sc);
						break;
					case 3: //Mostrar productos
						if (productos == null) {
							System.out.println("No es posible mostrar productos sin haber sido solicitados");
						}
						productos.mostrarProductos();
						break;
					case 4: //Salimos
						break;
					default:
						System.out.println("No ha insertado la opción correcta");
				}
			}catch(InputMismatchException e){
				System.out.println("No ha insertado la opción correcta"")
				sc.nextLine();
			}
		} while (seleccion != 4);
		System.out.println("Gracias por usar nuestro programa. Que tenga un buen día!");
		sc.close();
	}

}
