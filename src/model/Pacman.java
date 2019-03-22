package model;

public class Pacman{
	
	public final static int AUMENTAR = 10;
	
	public enum Direccion{IZQUIERDA, DERECHA, ARRIBA, ABAJO};
	
	private double radio;
	private double posicionX;
	private double posicionY;
	private double tiempoEspera;
	private Direccion direccion;
	private int cantRebotes;
	private boolean detenido;

	public Pacman(double radio, double posicionX, double posicionY, double tiempoEspera, Direccion direccion, int cantRebotes, boolean detenido) {
		this.radio = radio;
		this.posicionX = posicionX;
		this.tiempoEspera = tiempoEspera;
		this.direccion = direccion;
		this.cantRebotes = cantRebotes;
		this.detenido = detenido;
	}
	
	public double getRadio() {
		return radio;
	}
	
	public double getPosicionX() {
		return posicionX;
	}
	
	public double getPosicionY() {
		return posicionY;
	}
	
	public double getTiempoEspera() {
		return tiempoEspera;
	}
	
	public Direccion getDirecion() {
		return direccion;
	}
	
	public int getCantRebotes() {
		return cantRebotes;
	}
	
	public boolean getDetenido() {
		return detenido;
	}
	public void mover(double anchoVentana, double largoVentana) {
		switch(direccion) {
		    case IZQUIERDA:
		    	posicionX = posicionX - AUMENTAR;
				if(posicionX <= 0) {
					direccion = Direccion.DERECHA;
					cantRebotes ++;
				}break;
		    case DERECHA:
		    	posicionX = posicionX + AUMENTAR;
				if(posicionX >= anchoVentana) {
					direccion = Direccion.IZQUIERDA;
					cantRebotes ++;
				}break;
		    case ARRIBA:
		    	posicionY = posicionY - AUMENTAR;
		    	if(posicionY <= 0) {
		    		direccion = Direccion.ABAJO;
		    		cantRebotes ++;
		    	}break;
		    case ABAJO:
		    	posicionY = posicionY + AUMENTAR;
		    	if(posicionY <= largoVentana) {
		    		direccion = Direccion.ARRIBA;
		    		cantRebotes ++;
		    	}break;
		}
	}
	public void detener() {
		detenido = true;
	}
}
