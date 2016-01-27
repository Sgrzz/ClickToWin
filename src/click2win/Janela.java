package click2win;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities; 

import pt.ipleiria.estg.dei.gridpanel.GridPanel;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.awt.Color;

public class Janela extends JFrame {

	private JPanel contentPane;
	private JPanel panelFundo;
	private GridPanel gridPanelTabuleiro;
	private Jogo jogo;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Janela() {
		setResizable(false);
		setTitle("Click to Win !");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 960, 730);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelFundo = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(Janela.class
							.getResource("/imagens/fundo.png")), 0, 0,
							this);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		contentPane.add(panelFundo, BorderLayout.CENTER);
		panelFundo.setLayout(null);
		panelFundo.setBackground(Color.BLACK);

		gridPanelTabuleiro = new GridPanel();
		gridPanelTabuleiro.setForeground(Color.DARK_GRAY);
		gridPanelTabuleiro.setBounds(280, 30, 64*10, 64*10);
		gridPanelTabuleiro.setRows(10);
		gridPanelTabuleiro.setRowSize(64);
		gridPanelTabuleiro.setColumns(10);
		gridPanelTabuleiro.setColumnSize(64);
		gridPanelTabuleiro.setShowGridLines(false);
		panelFundo.add(gridPanelTabuleiro);
		
		jogo = new Jogo(gridPanelTabuleiro);

		final Runnable iterar = new Runnable() {
			@Override
			public void run() {
				jogo.iterar(System.currentTimeMillis());
				gridPanelTabuleiro.repaint();
			}
		};
		
		Thread novaThread = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						SwingUtilities.invokeAndWait(iterar);
						sleep(5);
					} catch (InvocationTargetException | InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		novaThread.start();
	}
}
