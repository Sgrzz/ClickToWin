package click2win;

import java.util.Collections;
import java.util.LinkedList;

public class PecaFormiga extends PecaDesaparecer {

	private Tabuleiro tabuleiro;
	
	public PecaFormiga(Posicao posicao, Tabuleiro tabuleiro) {
		super(posicao, tabuleiro, "Formiga", 6000, "azul");
		this.tabuleiro=tabuleiro;
	}

	@Override
	public void ativar() {
			tabuleiro.retirar(this);
			
		}
		
		
		
		
	
	@Override
	public void remover(){
		
		LinkedList<Peca> lista = tabuleiro.getPosicoesPecas();
		Collections.shuffle(lista);
		int removidas = 0;
		int x = 0;
		try{
		while ((removidas<3) && (lista.size()>=x))
		{	
			if (lista.get(x).tipo=="torre")
			{
				tabuleiro.colocar(new PecaFormiga(lista.get(x).getPosicao(),tabuleiro));
				
				removidas++;		
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
