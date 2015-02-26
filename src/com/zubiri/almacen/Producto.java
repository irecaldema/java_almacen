/**
 * 
 */
package com.zubiri.almacen;

import java.util.Scanner;

/**
 * @author xoni
 *
 */

public abstract class Producto {
	
	private Distribuidor distribuidor;
	private String marca;
	private Double precio;
	private String procedencia;
	
	public Producto(Distribuidor distribuidor, String marca, Double precio, String procedencia) {
		
		this.distribuidor = distribuidor;
		this.marca = marca;
		this.precio = precio;
		this.procedencia = procedencia;
	}
	
	public Producto(Scanner sc) {
		
		System.out.println("Marca del producto:");
		this.setMarca(sc.next());
		System.out.println("Precio del producto:");
		this.setPrecio(sc.nextDouble());
		System.out.println("Procedencia del producto:");
		this.setProcedencia(sc.next());
		System.out.println("Distribuidor del producto:");
		this.setDistribuidor(Distribuidores.buscarDistribuidor(sc.next()));
	}
	
	public Distribuidor getDistribuidor() {
		return distribuidor;
	}
	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getProcedencia() {
		return procedencia;
	}
	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void mostrarProducto() {
		System.out.println("\tmarca:" + this.getMarca());
		System.out.println("\tprodecendia:" + this.getProcedencia());
		System.out.println("\tprecio: " + this.getPrecio());
		System.out.println("\tdistribuidor: " + this.getDistribuidor().getNombre());
	}
}
