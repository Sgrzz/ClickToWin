package click2win;

public class PecaClicar extends Peca {

	Tabuleiro tabuleiro; 
	
	public PecaClicar(Posicao posicao, Tabuleiro tabuleiro, String img,String tipo) {
		super(posicao, tabuleiro, img,tipo);
		this.tabuleiro=tabuleiro;
	}
	@Override
	public void ativar() {
		tabuleiro.retirar(this);
	}

}
