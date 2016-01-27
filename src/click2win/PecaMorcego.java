package click2win;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PecaMorcego extends PecaDesaparecer {

	private Tabuleiro tabuleiro;
	
	public PecaMorcego(Posicao posicao, Tabuleiro tabuleiro) {
		super(posicao, tabuleiro, "Morcego", 10000, "amarelo");
		this.tabuleiro=tabuleiro;
	}
	
	@Override
	public void ativar() {
			tabuleiro.retirar(this);
		}
		
		
		
		
	
	@Override
	public void remover(){
		
		LinkedList<Peca> lista = tabuleiro.getPosicoesPecas();
		List<Posicao> posicoesLivres = tabuleiro.getPosicoesLivres();
		Collections.shuffle(lista);
		Collections.shuffle(posicoesLivres);
	
		int x = 0;
		try{
		while ( (lista.size()>=x))
		{	
			if (lista.get(x).tipo=="verde")
			{
				tabuleiro.retirar(lista.get(x));
				
				lista.get(x).setPosicao(posicoesLivres.get(x));
				tabuleiro.colocar(lista.get(x));
				
				
				posicoesLivres = tabuleiro.getPosicoesLivres();
				Collections.shuffle(posicoesLivres);	
			}	
			x++;
		}
		}
		catch (Exception e)
		{
			
		}
		tabuleiro.retirar(this);
		
	}

}
