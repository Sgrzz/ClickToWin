package click2win;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PecaAbelha extends PecaDesaparecer{

	Tabuleiro tabuleiro;
	
	public PecaAbelha(Posicao posicao, Tabuleiro tabuleiro) {
		super(posicao, tabuleiro, "Abelha", 7000,"verde");
		this.tabuleiro=tabuleiro;
	}
	
	@Override
	public void ativar() {
		tabuleiro.retirar(this);
		LinkedList<Peca> lista = tabuleiro.getPosicoesPecas();
		Collections.shuffle(lista);
		int torreRemovidas = 0;
		int x = 0;
		try{
		while ((torreRemovidas<3) && (lista.size()>=x))
		{	
			if (lista.get(x)instanceof PecaTorre)
			{
				tabuleiro.retirar(lista.get(x));
				torreRemovidas++;		
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
	
		
		List<Posicao> lista = tabuleiro.getPosicoesLivres();
		if (!lista.isEmpty()){
			Collections.shuffle(lista);
			int num = 0;
			while(num<=1){
				
				if (lista.size()!=0)
				{
					Posicao posicao = lista.get(num);
					Peca peca = new PecaAbelha(posicao, tabuleiro);
					tabuleiro.colocar(peca);
					lista = tabuleiro.getPosicoesLivres();
					Collections.shuffle(lista);
				}
				num++;
			}
			
		}
		
		
		tabuleiro.retirar(this);
	}
	

}
