package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import model.JuegoPacman;
import threads.PacmanThread0;
import threads.PacmanThread1;
import threads.PacmanThread2;

public class PacmanController {

    @FXML
    private Pane pane;

    @FXML
    private MenuItem nivel00;

    @FXML
    private MenuItem nivel01;

    @FXML
    private MenuItem nivel02;

    @FXML
    private MenuItem guardarJuego;

    @FXML
    private MenuItem salir;

    @FXML
    private MenuItem mejorJugador;

    @FXML
    private MenuItem acercaJuego;

    @FXML
    private Label contadorRepotes;
    
    @FXML
    private Stage stage;
    
    private JuegoPacman juegoPacman;
    
    private ArrayList<Arc> pacman0;
    private ArrayList<Arc> pacman1;
    private ArrayList<Arc> pacman2;

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public double getWidth() {
		return stage.getWidth();
	}
	
	public double getHeight() {
		return stage.getHeight();
	}
	
	public void initialize() throws FileNotFoundException, ClassNotFoundException, IOException {
		juegoPacman = new JuegoPacman();
		pacman0 = new ArrayList<Arc>();
		pacman1 = new ArrayList<Arc>();
		pacman2 = new ArrayList<Arc>();
	}
	
	public void updatePacmans0() {
		for(int i = 0; i<pacman0.size(); i++) {
			pacman0.get(i).setLayoutX(juegoPacman.getNivel()[0].getPacman().get(i).getPosicionX());
			pacman0.get(i).setLayoutY(juegoPacman.getNivel()[0].getPacman().get(i).getPosicionY());
		}
    }
	
	public void updatePacmans1() {
		for(int i = 0; i<pacman0.size(); i++) {
			pacman0.get(i).setLayoutX(juegoPacman.getNivel()[1].getPacman().get(i).getPosicionX());
			pacman0.get(i).setLayoutY(juegoPacman.getNivel()[1].getPacman().get(i).getPosicionY());
		}
    }
	
	public void updatePacmans2() {
		for(int i = 0; i<pacman0.size(); i++) {
			pacman0.get(i).setLayoutX(juegoPacman.getNivel()[2].getPacman().get(i).getPosicionX());
			pacman0.get(i).setLayoutY(juegoPacman.getNivel()[2].getPacman().get(i).getPosicionY());
		}
    }

    @FXML
    public void acercaJuegoM(ActionEvent event) {
    	Label acercaJuego = new Label("El jugador debe detener los pacman haciendo clic sobre cada uno de los que aparecen en la pantalla, lo más rápido posible y antes de que reboten.");
    	pane.getChildren().add(acercaJuego);
    }

    @FXML
    public void cargarNivel00(ActionEvent event) throws IOException {
		juegoPacman.importNivel0("	");
		for(int i = 0; i < juegoPacman.getNivel()[0].getPacman().size(); i++) {
				Arc pacman = new Arc(juegoPacman.getNivel()[0].getPacman().get(i).getPosicionX(), juegoPacman.getNivel()[0].getPacman().get(i).getPosicionY(),juegoPacman.getNivel()[0].getPacman().get(i).getRadio(), juegoPacman.getNivel()[0].getPacman().get(i).getRadio(),45,270);
				pacman.setType(ArcType.ROUND);
				pacman.setFill(Color.YELLOW);
				pacman0.add(pacman);
		}
		pane.getChildren().addAll(pacman0);
		PacmanThread0 pt0 = new PacmanThread0(this, juegoPacman);
		totalRebotes();
		pt0.start();
    }

    @FXML
    public void cargarNivel01(ActionEvent event) throws IOException {
		juegoPacman.importNivel1("	");
		for(int i = 0; i < juegoPacman.getNivel()[1].getPacman().size(); i++) {
				Arc pacman = new Arc(juegoPacman.getNivel()[1].getPacman().get(i).getPosicionX(), juegoPacman.getNivel()[1].getPacman().get(i).getPosicionY(),juegoPacman.getNivel()[1].getPacman().get(i).getRadio(), juegoPacman.getNivel()[1].getPacman().get(i).getRadio(),180,45);
				pacman.setType(ArcType.ROUND);
				pacman.setFill(Color.YELLOW);
				pacman1.add(pacman);
		}pane.getChildren().addAll(pacman1);
		PacmanThread1 pt1 = new PacmanThread1(this, juegoPacman);
		totalRebotes();
		pt1.start();
    }

    @FXML
    public void cargarNivel02(ActionEvent event) throws IOException {
    	juegoPacman.importNivel2("	");
		for(int i = 0; i < juegoPacman.getNivel()[2].getPacman().size(); i++) {
				Arc pacman = new Arc(juegoPacman.getNivel()[2].getPacman().get(i).getPosicionX(), juegoPacman.getNivel()[2].getPacman().get(i).getPosicionY(),juegoPacman.getNivel()[2].getPacman().get(i).getRadio(), juegoPacman.getNivel()[2].getPacman().get(i).getRadio(),180,45);
				pacman.setType(ArcType.ROUND);
				pacman.setFill(Color.YELLOW);
				
				pacman2.add(pacman);
		}pane.getChildren().addAll(pacman2);
		PacmanThread2 pt2 = new PacmanThread2(this, juegoPacman);
		totalRebotes();
		pt2.start();
    }
    
    @FXML
    public void guardarJuegoM(ActionEvent event) throws FileNotFoundException {
    		juegoPacman.guardarNivel0();
    		juegoPacman.guardarNivel1();
    		juegoPacman.guardarNivel2();
    }

    @FXML
    public void mejorJugador(ActionEvent event) {
    	int m = Integer.parseInt(contadorRepotes.getAccessibleText());
    	juegoPacman.mejoresPuntajes(m);
    }

    @FXML
    public void salirM(ActionEvent event) {
    	stage.close();
    }
    
    public int totalRebotes(){
    	int total = 0;
    	for(int i = 0; i<juegoPacman.getNivel().length; i++) {
    		for(int j = 0; j<juegoPacman.getNivel()[i].getPacman().size(); j++) {
    			total += juegoPacman.getNivel()[i].getPacman().get(i).getCantRebotes();
    		}
    	}
    	contadorRepotes.setAccessibleText(""+total);
    	return total;
    }
    
}
