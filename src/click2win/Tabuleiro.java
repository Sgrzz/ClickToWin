package click2win;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.GridPanelEventHandler;
import pt.ipleiria.estg.dei.gridpanel.MultipleImageCellRepresentation;

public class Tabuleiro implements GridPanelEventHandler{
	private static MultipleImageCellRepresentation mensagem =  
		new MultipleImageCellRepresentation(1000, true, false,"/imagens/clickToWin.png");
	private final int TEMPO_GERAR_INICIAL = 2000;
	private final int X = 10;
	private final int Y = 10;
	private Jogo jogo;
	private Peca grelha[][];
	private GridPanel gridPanelTabuleiro;
	private Random geradorAleatorios;
	private long tempoGerar;
	private long tempoAgendado;
	private int morteContar;

	public Tabuleiro(GridPanel gridPanelTabuleiro, Jogo jogo) {
		this.gridPanelTabuleiro = gridPanelTabuleiro;
		this.jogo = jogo;
		grelha = new Peca[X][Y];
		geradorAleatorios = new Random();
		gridPanelTabuleiro.setEventHandler(this);
		tempoGerar = TEMPO_GERAR_INICIAL;
		tempoAgendado = System.currentTimeMillis();
		morteContar=0;
	}
	
	public void colocarMensagem() {
		gridPanelTabuleiro.putOverlay(4, 4, mensagem);
	}

	public void retirarMensagem() {
		gridPanelTabuleiro.removeOverlay(4, 4, mensagem);
	}

	public boolean isPosicaoOcupada(int x, int y) {
		return grelha[x][y] != null;
	}

	public void iterar(long tempo) {
		if (!jogo.isTerminado()){
			if (tempo >= tempoAgendado){
				gerarProximaPeca();
				if (tempoGerar > 400)
					tempoGerar -= 50;
				tempoAgendado = tempo + tempoGerar;
			}
			for(int i=0; i < X ;i++){
				for (int j=0 ; j < Y ;j++){
					if (isPosicaoOcupada(i, j)){
						grelha[i][j].iterar(tempo);
					}
				}
			}
		}		
	}

	public List<Posicao> getPosicoesLivres(){
		List<Posicao> lista = new ArrayList<>();
		for (int i=0; i<X; i++){
			for (int j=0; j<Y;j++){
				if (!isPosicaoOcupada(i, j)){
					lista.add(new Posicao(i,j));
				}	
			}
		}
		return lista;
	}
	
	
	public LinkedList<Peca> getPosicoesPecas(){
		LinkedList<Peca> lista = new LinkedList<>() ;
		for (int i=0; i<X; i++){
			for (int j=0; j<Y;j++){
				if (isPosicaoOcupada(i, j)){
					lista.add(grelha[i][j]);
				}	
			}
		}
		return lista;
	}
	
	public Jogo getJogo()
	{
		return jogo;
	}
	
	public int getMorteContar()
	{
		return morteContar;
	}
	
	private void gerarProximaPeca() {
		List<Posicao> lista = getPosicoesLivres();
		if (!lista.isEmpty()){
			Collections.shuffle(lista);
			Posicao posicao = lista.get(0);
			
			
			Peca peca = null ;
			
			switch(geradorAleatorios.nextInt(10))
			{
				case 0:
					peca = new PecaTorre(posicao, this);
					break; 
				case 1:
					peca = new PecaMorte(posicao, this);
					break; 
				case 2:
					peca = new PecaAbelha(posicao, this);
					break;
				case 3:
					peca = new PecaPeixe(posicao, this);
					break;
				case 4:
					peca = new PecaCarraca(posicao, this);
					break;
				case 5:
					peca = new PecaFormiga(posicao, this);
					break;	
				case 6:
					peca = new PecaLobo(posicao, this);
					break;	
				case 7:
					peca = new PecaEscorpiao(posicao, this);
					break;		
				case 8:
					peca = new PecaMalvado(posicao, this);
					break;
					
				case 9:
					peca = new PecaMorcego(posicao,this);
					break;
					
			}
			
			
			
			colocar(peca);
		}else{
			jogo.terminarJogo();
		}
	}
	
	public void colocar(Peca peca) {
		Posicao posicao = peca.getPosicao();
		grelha[posicao.getX()][posicao.getY()] = peca;
		gridPanelTabuleiro.put(posicao.getX(), posicao.getY(),
				peca.getRepresentacao());
	}

	public void atualizar(Peca peca) {
		gridPanelTabuleiro.put(peca.getPosicao().getX(), peca.getPosicao().getY(),
				peca.getRepresentacao());	
	}

	public void retirar(Peca peca) {
		grelha[peca.getPosicao().getX()][peca.getPosicao().getY()] = null;
		gridPanelTabuleiro.clear(peca.getPosicao().getX(), peca.getPosicao().getY());
	}

	@Override
	public void mouseDragged(MouseEvent e, int coluna, int linha) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e, int coluna, int linha) {
	}

	@Override
	public void mousePressed(MouseEvent e, int coluna, int linha) {
		if (!jogo.isTerminado()){
			if (isPosicaoOcupada(coluna, linha))
				grelha[coluna][linha].ativar();
		}else{
			jogo.iniciarJogo();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e, int coluna, int linha) {
	}

	public void reset() {
		for (int i=0; i < X; i++)
			for (int j=0; j < Y; j++)
				grelha[i][j] = null;
		morteContar=0;
		gridPanelTabuleiro.clearAll();
		tempoAgendado=System.currentTimeMillis();
		tempoGerar=TEMPO_GERAR_INICIAL;
	}

	public void incMorteContar() {
		morteContar++;
		
	}
}
