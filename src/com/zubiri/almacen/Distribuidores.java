/**
 * 
 */
package com.zubiri.almacen;


import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author xoni
 *
 */
public class Distribuidores {
	
	private static ArrayList<Distribuidor> listaDistribuidores = new ArrayList<Distribuidor>();	
	
	/**
	 * 
	 */
	private Distribuidores() {
		
	}
	
	public static ArrayList <Distribuidor> getDistribuidores(){
		return listaDistribuidores;
	}

	public static void leerDistribuidores(String fichero) throws IOException {
			String linea;
			FileInputStream f;
		    InputStreamReader fr;
		    BufferedReader br;
		    
		    f = new FileInputStream(fichero);
	    	fr = new InputStreamReader(f, "UTF8");
	    	br = new BufferedReader(fr);
	    	linea = br.readLine();
			
			if (linea == null) {
				System.out.println("No existen distribuidores en el fichero");
			}
			
			while ((linea != null) && (linea.compareTo("") != 0)) {
				Distribuidor distribuidor = new Distribuidor(linea,",");
				listaDistribuidores.add(distribuidor);
				linea = br.readLine();
			}
			br.close();
	 }
	 
	 public static Distribuidor buscarDistribuidor(String nombre) {
		
		int i = 0;
		Distribuidor distribuidor = null;

		do {		
			if (listaDistribuidores.get(i).getNombre().equalsIgnoreCase(nombre)) {
				distribuidor = (Distribuidor)listaDistribuidores.get(i);
			}
			i++;
		} while ((distribuidor == null) && (i < listaDistribuidores.size()));
		
		if (distribuidor == null) {
			System.out.println("Distribuidor: No se ha encontrado el distribuidor en nuestra base de datos. Se cierra el programa.");
			System.exit(-1);
		}

		return distribuidor;
	}
	 
	public static void mostrarDistribuidores() {
		
		if (listaDistribuidores.size() == 0) {
			System.out.println("No se han cargado los distribuidores del fichero");
		}
		for (int i = 0;i < listaDistribuidores.size();i++) {
			System.out.println(listaDistribuidores.get(i).formattedDistribuidor());
		}
	}
}
