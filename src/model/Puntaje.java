package model;

public class Puntaje {
	
	private String nombre;
	private int puntos;

	public Puntaje(String nombre, int puntos) {
		this.nombre = nombre;
		this.puntos = puntos;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getPuntos() {
		return puntos;
	}
}
