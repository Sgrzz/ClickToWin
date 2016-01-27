package click2win;

import javax.sound.sampled.Clip;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.MediaLoader;

public class Jogo {

	private Clip clip;
	private Tabuleiro tabuleiro;
	private boolean terminado = true;

	public Jogo(GridPanel gridPanelTabuleiro) {
		clip = MediaLoader.getClip("/sons/In summer.wav");
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		tabuleiro = new Tabuleiro(gridPanelTabuleiro, this);
		tabuleiro.colocarMensagem();
	}
	
	public void iterar(long tempo) {
		if (!terminado){
			tabuleiro.iterar(tempo);
		}
	}
	
	public void iniciarJogo(){
		terminado = false;
		tabuleiro.reset();
		tabuleiro.retirarMensagem();
	}

	public void terminarJogo(){
		terminado = true;
		tabuleiro.colocarMensagem();
	}

	public boolean isTerminado() {
		return terminado;
	}
}
