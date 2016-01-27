package click2win;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class PecaDesaparecer extends PecaClicar {

	private String img;
	private long tempo;
	private Tabuleiro tabuleiro;
	public PecaDesaparecer(Posicao posicao, Tabuleiro tabuleiro, String img,long tempo,String tipo) {
		super(posicao, tabuleiro, img,tipo);
		this.tempo=tempo;
		this.img=img;
		this.tabuleiro=tabuleiro;
	}
	
	@Override
	public  void iterar(long tempo) 
	{
		if (tempo > tempoAuxiliar + TEMPO_VERDE){
			representacao = 
					new SingleImageCellRepresentation("/imagens/tile_"+img+".png");
			atualizar();
		}	
		if (tempo > tempoAuxiliar+(this.tempo-2000)){
			representacao = 
					new SingleImageCellRepresentation("/imagens/tile_vermelho_"+img+".png");
			atualizar();
		}	
		if (tempo > tempoAuxiliar+this.tempo){

			remover();
			
			
			
		}
		
	}
	
	protected void remover()
	{
		tabuleiro.retirar(this);
	}
	
	

}
