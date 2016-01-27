package click2win;

import java.util.Collections;
import java.util.List;

public class PecaMalvado extends PecaDesaparecer{

	private Tabuleiro tabuleiro;
	public PecaMalvado(Posicao posicao, Tabuleiro tabuleiro) {
		super(posicao, tabuleiro, "Malvado", 10000, "amarelo");
		this.tabuleiro=tabuleiro;
	}
	@Override
	public void ativar() {
			tabuleiro.retirar(this);
		}
		
		
		
		
	
	@Override
	public void remover(){
		
		List<Posicao> lista = tabuleiro.getPosicoesLivres();
		if (!lista.isEmpty()){
			Collections.shuffle(lista);
			int num = 0;
			try{
			while(num<=3){
				if ((lista.size()!=0) )
				{
					Posicao posicao = lista.get(num);
					Peca peca = new PecaMalvado(posicao, tabuleiro);
					tabuleiro.colocar(peca);
					lista = tabuleiro.getPosicoesLivres();
					Collections.shuffle(lista);
				}
				num++;
			}
			}
			catch (Exception e)
			{}
			
		}
		
		tabuleiro.retirar(this);
		
	}
}
