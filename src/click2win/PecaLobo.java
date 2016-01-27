package click2win;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PecaLobo extends PecaDesaparecer{

	private Tabuleiro tabuleiro;
	
	public PecaLobo(Posicao posicao, Tabuleiro tabuleiro) {
		super(posicao, tabuleiro, "Lobo", 8000, "azul");
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
			if (lista.get(x).tipo=="amarelo")
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
