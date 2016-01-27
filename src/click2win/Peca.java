package click2win;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Peca {
	protected final long TEMPO_VERDE = 2000;
	private Tabuleiro tabuleiro;
	private Posicao posicao;
	protected SingleImageCellRepresentation representacao;
	protected long tempoAuxiliar;
	private String img;
	protected String tipo;
	
	public Peca(Posicao posicao, Tabuleiro tabuleiro,String img,String tipo) {
		this.tipo=tipo;
		this.tabuleiro = tabuleiro;
		this.posicao = posicao;
		this.img=img;
		this.representacao = 
				new SingleImageCellRepresentation("/imagens/tile_verde_"+img+".png");
		tempoAuxiliar = System.currentTimeMillis();
	}
	
	public Posicao getPosicao() {
		return posicao;
	}
	
	public void setPosicao(Posicao posicao){
		this.posicao=posicao;
	}
	public SingleImageCellRepresentation getRepresentacao() {
		return representacao;
	}

	public  void iterar(long tempo) 
	{
		if (tempo > tempoAuxiliar + TEMPO_VERDE){
			this.representacao = 
					new SingleImageCellRepresentation("/imagens/tile_"+img+".png");
			atualizar();
		}	
		
	}

	protected void atualizar() {
		tabuleiro.atualizar(this);
	}

	public void ativar() {
		
	}

	
}
