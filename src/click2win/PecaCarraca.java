package click2win;

import java.util.Collections;
import java.util.LinkedList;

public class PecaCarraca extends PecaDesaparecer{

	private Tabuleiro tabuleiro;
	
	public PecaCarraca(Posicao posicao, Tabuleiro tabuleiro) {
		super(posicao, tabuleiro, "Carraca", 150000, "azul");
		this.tabuleiro=tabuleiro;
	}
	
	@Override
	public void ativar() {
			tabuleiro.retirar(this);
			LinkedList<Peca> lista = tabuleiro.getPosicoesPecas();
			Collections.shuffle(lista);
			int removidas = 0;
			int x = 0;
			try{
			while ((removidas<2) && (lista.size()>=x))
			{	
				if (lista.get(x).tipo=="morte")
				{
					tabuleiro.colocar(new PecaTorre(lista.get(x).getPosicao(),tabuleiro));
					
					removidas++;		
				}	
				x++;
			}
			}
			catch (Exception e)
			{
				
			}
		}
		
		
		
		
	
	@Override
	public void remover(){
		
		tabuleiro.retirar(this);
	}

}
