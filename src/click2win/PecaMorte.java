package click2win;

import java.util.Collections;
import java.util.List;

public class PecaMorte extends Peca{

	Tabuleiro tabuleiro;
	
	public PecaMorte(Posicao posicao, Tabuleiro tabuleiro) {
		
		super(posicao, tabuleiro, "morte","morte");
		this.tabuleiro=tabuleiro;
	}
	
	
	public void ativar() {
		tabuleiro.incMorteContar();
		if (tabuleiro.getMorteContar()==3)
		{
			tabuleiro.getJogo().terminarJogo();
		}
		List<Posicao> lista = tabuleiro.getPosicoesLivres();
		if (!lista.isEmpty()){
			Collections.shuffle(lista);
			Posicao posicao = lista.get(0);
			Peca peca = new PecaMorte(posicao, tabuleiro);
			tabuleiro.colocar(peca);
			posicao = lista.get(1);
			peca = new PecaMorte(posicao, tabuleiro);
			tabuleiro.colocar(peca);	
			
		}
		
	
	}

}
