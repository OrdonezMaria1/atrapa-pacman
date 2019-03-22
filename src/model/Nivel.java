package model;

import java.util.ArrayList;
import java.util.List;

public class Nivel{
	
	private int nivel;
	private List<Pacman> pacman;
	
	public Nivel(int nivel) {
		this.nivel = nivel;
		pacman = new ArrayList<>();
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public List<Pacman> getPacman(){
		return pacman;
	}
}
