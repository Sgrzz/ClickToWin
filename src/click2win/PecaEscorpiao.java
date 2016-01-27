package click2win;

import java.util.Collections;
import java.util.List;

public class PecaEscorpiao extends PecaDesaparecer{

	private Tabuleiro tabuleiro;
	public PecaEscorpiao(Posicao posicao, Tabuleiro tabuleiro) {
		super(posicao, tabuleiro, "Escorpiao", 10000, "amarelo");
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
			try
			{
			while(num<=1){
				
				if (lista.size()!=0)
				{
					Posicao posicao = lista.get(num);
					Peca peca = new PecaMorcego(posicao, tabuleiro);
					tabuleiro.colocar(peca);
					lista = tabuleiro.getPosicoesLivres();
					Collections.shuffle(lista);
				}
				num++;
			}
			}
			catch (Exception e)
			{
				
			}
			
		}
		
		tabuleiro.retirar(this);
		

}
}