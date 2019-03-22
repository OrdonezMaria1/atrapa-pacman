package threads;

import model.JuegoPacman;
import ui.PacmanController;

public class PacmanThread1 extends Thread{
	private PacmanController pacmanController;
	private JuegoPacman juegoPacman;
	
	public PacmanThread1(PacmanController pacmanController, JuegoPacman juegoPacman) {
		this.pacmanController = pacmanController;
		this.juegoPacman = juegoPacman;
	}
	
	public void run() {
		while(true) {
			for(int i = 0; i<juegoPacman.getNivel()[1].getPacman().size();i++) {
				juegoPacman.getNivel()[0].getPacman().get(i).mover(pacmanController.getWidth(), pacmanController.getHeight());
			}
			pacmanController.updatePacmans0();
			try {
				sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
