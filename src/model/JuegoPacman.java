package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import model.Pacman.Direccion;

public class JuegoPacman {
	
	private final static String NIVEL0 = "data/nivel0.txt";
	private final static String NIVEL1 = "data/nivel1.txt";
	private final static String NIVEL2 = "data/nivel2.txt";
	private final static String NIVEL0GUARDADO = "data/nivel0guardado.txt";
	private final static String NIVEL1GUARDADO = "data/nivel1guardado.txt";
	private final static String NIVEL2GUARDADO = "data/nivel2guardado.txt";
	private final static String MEJORESJUGADORES = "data/mejoresJugadores.txt";
	
	private Puntaje[] puntaje;
	
	private File mejoresJugadores;
	private Nivel[] nivel;
	
	public JuegoPacman() throws FileNotFoundException, IOException, ClassNotFoundException {
		puntaje = new Puntaje[10];
		for(int i = 0; i<puntaje.length; i++) {
			puntaje[0] = new Puntaje(null,0);
		}
		nivel = new Nivel[3];
		mejoresJugadores = new File(MEJORESJUGADORES);
		loadJugadores();
	}

	public Nivel[] getNivel() {
		return nivel;
	}	
	
	public void loadJugadores() throws FileNotFoundException, IOException, ClassNotFoundException {
		if(mejoresJugadores.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(MEJORESJUGADORES));
				nivel = ((Nivel[])ois.readObject());
				ois.close();
			}catch(FileNotFoundException fileNotFoundException) {
				System.out.println("Exception"+ fileNotFoundException);
			}catch(IOException ioException) {
				System.out.println("Exception"+ ioException);
			}catch(ClassNotFoundException classNotFoundException) {
				System.out.println("Exception"+ classNotFoundException);
			}
		}
	}
	public void saveJugadores() throws FileNotFoundException, IOException{
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(MEJORESJUGADORES));
			oos.writeObject(nivel);
			oos.close();
		}catch(FileNotFoundException fileNotFoundException) {
			System.out.println("Exception"+ fileNotFoundException);
		}catch(IOException ioException) {
			System.out.println("Exception"+ ioException);
		}
	}
	
	public void importNivel0(String sep) throws IOException {
		File nivel0 = new File(NIVEL0);
		BufferedReader br = new BufferedReader(new FileReader(nivel0));
		
		String line = br.readLine();
		while(line != null) {
			if(line.startsWith("#") == true){
				line = br.readLine();
			}else {
				int i = 0;
				String j =Integer.toString(i);
				if(line.startsWith(j) == true) {
					nivel[i]= new Nivel(i);
					System.out.println(""+nivel[i].getNivel());
					line = br.readLine();
					System.out.println(""+line);
				}else if(line.startsWith(j) == false){
					if(line.length() == 1) {
						line = br.readLine();
					}else {
						String[] parts = line.split(sep);
						System.out.println(""+parts[0]);
						double radio = Double.parseDouble(parts[0]);
						double posicionX = Double.parseDouble(parts[1]);
						double posicionY = Double.parseDouble(parts[2]);
						double tiempoEspera = Double.parseDouble(parts[3]);
						Direccion direccion = Direccion.valueOf(parts[4]);
						int cantRebotes = Integer.parseInt(parts[5]);
						boolean detenido = Boolean.parseBoolean(parts[6]);
						
						Pacman pacman = new Pacman(radio, posicionX, posicionY,tiempoEspera, direccion,cantRebotes, detenido);
						System.out.println(""+pacman.getPosicionX());
						nivel[i].getPacman().add(pacman);
						System.out.println(""+i);
						line = br.readLine();
					}
				}
			}
		}
		br.close();
	}
	
	public void importNivel1(String sep) throws IOException {
		File nivel1 = new File(NIVEL1);
		BufferedReader br = new BufferedReader(new FileReader(nivel1));
		
		String line = br.readLine();
		while(line != null) {
			if(line.startsWith("#") == true){
				line = br.readLine();
			}else {
				int i = 1;
				String j =Integer.toString(i);
				if(line.startsWith(j) == true) {
					nivel[i]= new Nivel(i);
					System.out.println(""+nivel[i].getNivel());
					line = br.readLine();
					System.out.println(""+line);
				}else if(line.startsWith(j) == false){
					if(line.length() == 1) {
						line = br.readLine();
					}else {
						String[] parts = line.split(sep);
						System.out.println(""+parts[0]);
						double radio = Double.parseDouble(parts[0]);
						double posicionX = Double.parseDouble(parts[1]);
						double posicionY = Double.parseDouble(parts[2]);
						double tiempoEspera = Double.parseDouble(parts[3]);
						Direccion direccion = Direccion.valueOf(parts[4]);
						int cantRebotes = Integer.parseInt(parts[5]);
						boolean detenido = Boolean.parseBoolean(parts[6]);
						
						Pacman pacman = new Pacman(radio, posicionX, posicionY,tiempoEspera, direccion,cantRebotes, detenido);
						System.out.println(""+pacman.getPosicionX());
						nivel[i].getPacman().add(pacman);
						System.out.println(""+i);
						line = br.readLine();
					}
				}
			}
		}
		br.close();
	}
	
	public void importNivel2(String sep) throws IOException {
		File nivel2 = new File(NIVEL2);
		BufferedReader br = new BufferedReader(new FileReader(nivel2));
		
		String line = br.readLine();
		while(line != null) {
			if(line.startsWith("#") == true){
				line = br.readLine();
			}else {
				int i = 2;
				String j =Integer.toString(i);
				if(line.startsWith(j) == true) {
					nivel[i]= new Nivel(i);
					System.out.println(""+nivel[i].getNivel());
					line = br.readLine();
					System.out.println(""+line);
				}else if(line.startsWith(j) == false){
					if(line.length() == 1) {
						line = br.readLine();
					}else {
						String[] parts = line.split(sep);
						System.out.println(""+parts[0]);
						double radio = Double.parseDouble(parts[0]);
						double posicionX = Double.parseDouble(parts[1]);
						double posicionY = Double.parseDouble(parts[2]);
						double tiempoEspera = Double.parseDouble(parts[3]);
						Direccion direccion = Direccion.valueOf(parts[4]);
						int cantRebotes = Integer.parseInt(parts[5]);
						boolean detenido = Boolean.parseBoolean(parts[6]);
						
						Pacman pacman = new Pacman(radio, posicionX, posicionY,tiempoEspera, direccion,cantRebotes, detenido);
						System.out.println(""+pacman.getPosicionX());
						nivel[i].getPacman().add(pacman);
						System.out.println(""+i);
						line = br.readLine();
					}
				}
			}
		}
		br.close();
	}

	public String getReport0() {
		String msg= "#Nivel\n";
		msg += "0\n";
		msg += "#radio posX posY espera direccion rebotes";
		for(int i = 0; i< nivel[0].getPacman().size(); i++) {
			Pacman pacmanc = nivel[0].getPacman().get(i);
			msg += pacmanc.getRadio()+"	"+pacmanc.getPosicionX()+"	"+pacmanc.getPosicionY()+"	"+pacmanc.getTiempoEspera()+"	"+pacmanc.getDirecion()+"	"+pacmanc.getCantRebotes();
		}
		return msg;
	}
	
	public String getReport1() {
		String msg= "#Nivel\n";
		msg += "1\n";
		msg += "#radio posX posY espera direccion rebotes";
		for(int i = 0; i< nivel[1].getPacman().size(); i++) {
			Pacman pacmanc = nivel[1].getPacman().get(i);
			msg += pacmanc.getRadio()+"	"+pacmanc.getPosicionX()+"	"+pacmanc.getPosicionY()+"	"+pacmanc.getTiempoEspera()+"	"+pacmanc.getDirecion()+"	"+pacmanc.getCantRebotes();
		}
		return msg;
	}
	
	public String getReport2() {
		String msg= "#Nivel\n";
		msg += "2\n";
		msg += "#radio posX posY espera direccion rebotes";
		for(int i = 0; i< nivel[2].getPacman().size(); i++) {
			Pacman pacmanc = nivel[2].getPacman().get(i);
			msg += pacmanc.getRadio()+"	"+pacmanc.getPosicionX()+"	"+pacmanc.getPosicionY()+"	"+pacmanc.getTiempoEspera()+"	"+pacmanc.getDirecion()+"	"+pacmanc.getCantRebotes();
		}
		return msg;
	}
	
	
	public void guardarNivel0() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(NIVEL0GUARDADO));
		
		String repStr = getReport0();
		pw.print(repStr);
		
		pw.close();
	}
	
	public void guardarNivel1() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(NIVEL1GUARDADO));
		
		String repStr = getReport1();
		pw.print(repStr);
		
		pw.close();
	}
	
	public void guardarNivel2() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(NIVEL2GUARDADO));
		
		String repStr = getReport2();
		pw.print(repStr);
		
		pw.close();
	}
	
	
	public void mejoresPuntajes(int puntos) {
		for(int i= 0; i<puntaje.length;i++) {
			if(puntos > puntaje[i].getPuntos()) {
			}
		}
	}
}
