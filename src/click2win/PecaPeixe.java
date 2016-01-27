package click2win;

import java.util.Collections;
import java.util.LinkedList;

public class PecaPeixe extends PecaDesaparecer{

	Tabuleiro tabuleiro;
	
	public PecaPeixe(Posicao posicao, Tabuleiro tabuleiro) {
		super(posicao, tabuleiro, "Peixe", 6000, "verde");
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
			while ((removidas<3) && (lista.size()>=x))
			{	
				if (lista.get(x).tipo=="amarelo")
				{
					tabuleiro.retirar(lista.get(x));
					removidas++;		
				}	
				x++;
			}}
			catch (Exception e)
			{}
		}
		
		
		
		
	
	@Override
	public void remover(){
		
		tabuleiro.retirar(this);
	}
	
	
	

}
