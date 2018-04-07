package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controller.JogadoresController;
import controller.PerguntaController;
import controller.PontuacaoController;
import model.bean.Alternativa;
import util.EscutaServidor;
import util.PropriedadesTela;

public class WPergunta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static int idEscola;
	private static int idAssunto;
	private static String nome;
	int idAlternativaCerta;
	private EscutaServidor es;
	private String respostaJogador;
	private int respostaCorreta;
	private boolean notificacao;
	private int idPergunta;
	private int tamanhoFonte;
	private PropriedadesTela pt;
	private JButton btnRespostaUm;
	private JButton btnRespostaDois;
	private JButton btnRespostaTres;
	private JButton btnRespostaQuatro;
	private JButton btnRespostaCinco;
	private JButton btnHisDoBrasil;
	private JButton btnHisContemporania;
	private JButton btnHisModerna;
	private JButton btnHisMedieval;
	private JButton btnHisAntiga;
	private JButton btnPreHistoria;
	private JLabel lblTempo;
	private JLabel lblTempoMil;
	private int iniciarTh;
	private List<Alternativa> listaPergunta;
	//private static WJogadores jogadores;
	
	//static WPergunta dialog;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			WPergunta dialog = new WPergunta(idEscola, idAssunto, nome);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WPergunta(int idEscola, int idAssunto, String nome) {
		this.nome = nome;
		listaPergunta = new ArrayList<Alternativa>();
		notificacao = false;
		setIdEscola(idEscola);
		setIdAssunto(idAssunto);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\LogoFAFICA.jpg"));
		pt = new PropriedadesTela(returnIn());
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setResizable(false);
		setUndecorated(true);
		


		design();
		
		es = new EscutaServidor(this);
	}

	public void design()
	{
		tamanhoTela();

		panelHeader();
		panelCenter();
		panelFooter();
	}

	public void tamanhoTela()
	{
		setSize((int)(pt.width()), (int)(pt.height()));
		setLocationRelativeTo(null);
		setModal(true);
	}

	public void panelHeader()
	{
		JPanel panelHeader = new JPanel();
		panelHeader.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
		panelHeader.setBackground(new Color(32,37,80));
		panelHeader.setSize(getWidth(), (int)(getHeight()* 0.07));
		contentPanel.add(panelHeader);
		panelHeader.setLayout(null);

		lblNomeJogador(panelHeader);
		lblSlogan(panelHeader);
	}

	public void panelCenter()
	{
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new MatteBorder(0, 2, 0, 2, (Color) new Color(0, 0, 0)));
		panelCenter.setBackground(new Color(255,255,255));
		panelCenter.setSize(getWidth(), (int)(getHeight() * 0.87));
		panelCenter.setLocation(returnIn().left, (int)(getHeight() * 0.07)); 
		contentPanel.add(panelCenter);
		panelCenter.setLayout(null);

		tpPergunta(panelCenter, getIdAssunto());
		panelAlternativa(panelCenter);
		btnConfirmar(panelCenter);
		panelTempo(panelCenter);
		btnIniciar(panelCenter);

	}

	public void panelAlternativa(JPanel panelCenter)
	{
		JPanel panelAlternativa = new JPanel();
		panelAlternativa.setLayout(null);
		panelAlternativa.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)));
		//panelAlternativa.setBackground(new Color(25, 255, 255));
		panelAlternativa.setSize((int)(panelCenter.getWidth() * 0.5), (int)(getHeight() * 0.5));
		panelAlternativa.setLocation((int)(panelCenter.getWidth() * 0.05), (int)(panelCenter.getHeight() * 0.30)); 
		panelCenter.add(panelAlternativa);
		
		PerguntaController pc = new PerguntaController();
		listaPergunta.addAll(pc.listaAlternativa(getIdPergunta()));

		btnRespostaUm(panelAlternativa, listaPergunta.get(0).getResposta(), listaPergunta.get(0).getCorreta());
		btnRespostaDois(panelAlternativa, listaPergunta.get(1).getResposta(), listaPergunta.get(1).getCorreta());
		btnRespostaTres(panelAlternativa, listaPergunta.get(2).getResposta(), listaPergunta.get(2).getCorreta());
		btnRespostaQuatro(panelAlternativa, listaPergunta.get(3).getResposta(), listaPergunta.get(3).getCorreta());
		btnRespostaCinco(panelAlternativa, listaPergunta.get(4).getResposta(), listaPergunta.get(4).getCorreta());
	}

	public void panelTempo(JPanel panelCenter)
	{
		JPanel panelTempo = new JPanel();
		panelTempo.setLayout(null);
		panelTempo.setBackground(new Color(255, 255, 255));
		panelTempo.setSize((int)(panelCenter.getWidth() * 0.45), (int)(getHeight() * 0.5));
		panelTempo.setLocation((int)(panelCenter.getWidth() * 0.05 ) + (int)(panelCenter.getWidth() * 0.5), (int)(panelCenter.getHeight() * 0.30)); 
		panelCenter.add(panelTempo);

		PerguntaController pc = new PerguntaController();
		lblTempo(panelTempo);
		lblTempoMil(panelTempo);
	}

	public void panelFooter()
	{
		JPanel panelFooter = new JPanel();
		panelFooter.setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panelFooter.setBackground(new Color(32,37,80));
		panelFooter.setSize(getWidth(), (int)(getHeight() * 0.08));
		panelFooter.setLocation(returnIn().left, (int)(getHeight() * 0.93)); 
		contentPanel.add(panelFooter);
		panelFooter.setLayout(null);
		
		lblCopyright(panelFooter);
		
	}	
	
	public void lblCopyright(JPanel panelFooter)
	{
		JLabel lblCopyright = new JLabel("© Copyright Grey Tool Co.");
		lblCopyright.setForeground(new Color(255, 255, 255));
		lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyright.setSize((int)(panelFooter.getWidth() * 0.35), (int)(panelFooter.getHeight() * 0.5));
		lblCopyright.setLocation(local(panelFooter.getWidth(), lblCopyright.getWidth(), 50), local(panelFooter.getHeight(), lblCopyright.getHeight(), 50));
		int tamanhoFonte = (int)(19 * lblCopyright.getWidth() / 403);
		lblCopyright.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelFooter.add(lblCopyright);
	}

	public void lblSlogan(JPanel panelHeader){
		JLabel lblSlogan = new JLabel("");
		lblSlogan.setSize((int)(panelHeader.getWidth() * 0.15), panelHeader.getHeight() - 4);
		lblSlogan.setLocation(2,2);
		ImageIcon imagem = new ImageIcon("img\\Header_Bar_787x206.png");
		lblSlogan.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(lblSlogan.getWidth(), lblSlogan.getHeight(), Image.SCALE_DEFAULT)));
		panelHeader.add(lblSlogan);
	}
	
	public void lblNomeJogador(JPanel panelHeader)
	{
		JLabel lblNomeJogador = new JLabel(this.nome);
		lblNomeJogador.setForeground(Color.WHITE);
		lblNomeJogador.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeJogador.setSize((int)(panelHeader.getWidth()* 0.2), (int)(panelHeader.getHeight()* 0.5));
		lblNomeJogador.setLocation((int)(panelHeader.getWidth() * 0.07), local(panelHeader.getHeight(), lblNomeJogador.getHeight(), 50));

		tamanhoFonte = (int)(17 * lblNomeJogador.getWidth() / 133);

		lblNomeJogador.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));

		panelHeader.add(lblNomeJogador);

	}
	
	public void tpPergunta(JPanel panelCenter, int idAssunto)
	{
		PerguntaController pc = new PerguntaController();
		setIdPergunta(pc.listaPergunta(idAssunto).get(0).getId());

		JTextPane tpPergunta = new JTextPane();
		tpPergunta.setText(pc.listaPergunta(idAssunto).get(0).getPergunta());
		tpPergunta.setEditable(false);
		tpPergunta.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tpPergunta.setSize((int)(panelCenter.getWidth() * 0.9), (int)(getHeight() * 0.18));
		tpPergunta.setLocation(local(panelCenter.getWidth(), tpPergunta.getWidth(), 50), (int)(panelCenter.getHeight() * 0.05));
		int tamanhoFonte = (int)25 * tpPergunta.getHeight() / 98;

		tpPergunta.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelCenter.add(tpPergunta);
	}


	public void btnRespostaUm(JPanel panelAlternativa, String resposta, String certa)
	{
		btnRespostaUm = new JButton("<html><body>"+resposta+"</body></html>");
		btnRespostaUm.setForeground(Color.WHITE);
		btnRespostaUm.setHorizontalAlignment(SwingConstants.LEFT);
		btnRespostaUm.setFocusPainted(false);
		btnRespostaUm.setBackground(new Color(32,37,80));
		btnRespostaUm.setSize((int)(panelAlternativa.getWidth()), (int)(panelAlternativa.getHeight() * 0.18));
		btnRespostaUm.setLocation(0, 0);
		int tamanhoFonte = (int)(20 * btnRespostaUm.getWidth() / 126);
		btnRespostaUm.setFont(new Font("Arial", Font.PLAIN, 16));
		panelAlternativa.add(btnRespostaUm);

		btnRespostaUm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					respostaJogador = certa;
					respostaCorreta = 1;
					corBotoesAzul();
					corBotoesLaranja(1);
					setNotificacao(true);
			}
		});
	}

	public void btnRespostaDois(JPanel panelAlternativa, String resposta, String certa)
	{
		btnRespostaDois = new JButton("<html><body>"+resposta+"</body></html>");
		btnRespostaDois.setForeground(Color.WHITE);
		btnRespostaDois.setHorizontalAlignment(SwingConstants.LEFT);
		btnRespostaDois.setFocusPainted(false);
		btnRespostaDois.setBackground(new Color(32,37,80));
		btnRespostaDois.setSize((int)(panelAlternativa.getWidth()), (int)(panelAlternativa.getHeight() * 0.18));
		btnRespostaDois.setLocation(0, (int)(panelAlternativa.getHeight() * 0.21));
		int tamanhoFonte = (int)(20 * btnRespostaDois.getWidth() / 126);
		btnRespostaDois.setFont(new Font("Arial", Font.PLAIN, 16));
		panelAlternativa.add(btnRespostaDois);

		btnRespostaDois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				respostaJogador = certa;
				respostaCorreta = 2;
				corBotoesAzul();
				corBotoesLaranja(2);
				setNotificacao(true);
			}
		});
	}

	public void btnRespostaTres(JPanel panelAlternativa, String resposta, String certa)
	{
		btnRespostaTres = new JButton("<html><body>"+resposta+"</body></html>");
		btnRespostaTres.setForeground(Color.WHITE);
		btnRespostaTres.setHorizontalAlignment(SwingConstants.LEFT);
		btnRespostaTres.setFocusPainted(false);
		btnRespostaTres.setBackground(new Color(32,37,80));
		btnRespostaTres.setSize((int)(panelAlternativa.getWidth()), (int)(panelAlternativa.getHeight() * 0.18));
		btnRespostaTres.setLocation(0, (int)(panelAlternativa.getHeight() * 0.235) + (btnRespostaTres.getHeight()));
		int tamanhoFonte = (int)(20 * btnRespostaTres.getWidth() / 126);
		btnRespostaTres.setFont(new Font("Arial", Font.PLAIN, 16));
		panelAlternativa.add(btnRespostaTres);

		btnRespostaTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				respostaJogador = certa;
				respostaCorreta = 3;
				corBotoesAzul();
				corBotoesLaranja(3);
				setNotificacao(true);
			}
		});
	}

	public void btnRespostaQuatro(JPanel panelAlternativa, String resposta, String certa)
	{
		btnRespostaQuatro = new JButton("<html><body>"+resposta+"</body></html>");
		btnRespostaQuatro.setForeground(Color.WHITE);
		btnRespostaQuatro.setHorizontalAlignment(SwingConstants.LEFT);
		btnRespostaQuatro.setFocusPainted(false);
		btnRespostaQuatro.setBackground(new Color(32,37,80));
		btnRespostaQuatro.setSize((int)(panelAlternativa.getWidth()), (int)(panelAlternativa.getHeight() * 0.18));
		btnRespostaQuatro.setLocation(0, (int)(panelAlternativa.getHeight() * 0.26) + (btnRespostaQuatro.getHeight() * 2));
		int tamanhoFonte = (int)(20 * btnRespostaQuatro.getWidth() / 126);
		btnRespostaQuatro.setFont(new Font("Arial", Font.PLAIN, 16));
		panelAlternativa.add(btnRespostaQuatro);

		btnRespostaQuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				respostaJogador = certa;
				corBotoesAzul();
				corBotoesLaranja(4);
				setNotificacao(true);

				respostaCorreta = 4;
			}
		});
	}

	public void btnRespostaCinco(JPanel panelAlternativa, String resposta, String certa)
	{
		btnRespostaCinco = new JButton("<html><body>"+resposta+"</body></html>");
		btnRespostaCinco.setForeground(Color.WHITE);
		btnRespostaCinco.setHorizontalAlignment(SwingConstants.LEFT);
		btnRespostaCinco.setFocusPainted(false);
		btnRespostaCinco.setBackground(new Color(32,37,80));
		btnRespostaCinco.setSize((int)(panelAlternativa.getWidth()), (int)(panelAlternativa.getHeight() * 0.18));
		btnRespostaCinco.setLocation(0, (int)(panelAlternativa.getHeight() * 0.285) + (btnRespostaCinco.getHeight() * 3));
		int tamanhoFonte = (int)(20 * btnRespostaCinco.getWidth() / 126);
		btnRespostaCinco.setFont(new Font("Arial", Font.PLAIN, 16));
		panelAlternativa.add(btnRespostaCinco);

		btnRespostaCinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				respostaJogador = certa;
				corBotoesAzul();
				corBotoesLaranja(5);
				respostaCorreta = 5;
				setNotificacao(true);
			}
		});
	}

	public void corBotoesAzul(){
		btnRespostaUm.setBackground(new Color(32,37,80));
		btnRespostaDois.setBackground(new Color(32,37,80));
		btnRespostaTres.setBackground(new Color(32,37,80));
		btnRespostaQuatro.setBackground(new Color(32,37,80));
		btnRespostaCinco.setBackground(new Color(32,37,80));
		
		btnRespostaUm.setForeground(Color.WHITE);
		btnRespostaDois.setForeground(Color.WHITE);
		btnRespostaTres.setForeground(Color.WHITE);
		btnRespostaQuatro.setForeground(Color.WHITE);
		btnRespostaCinco.setForeground(Color.WHITE);
	}
	
	public void corBotoesVerde(int botao)
	{
		if(botao == 1){
			btnRespostaUm.setBackground(new Color(14, 146, 0));
		}else if(botao == 2){
			btnRespostaDois.setBackground(new Color(14, 146, 0));
		}else if(botao == 3){
			btnRespostaTres.setBackground(new Color(14, 146, 0));
		}else if(botao == 4){
			btnRespostaQuatro.setBackground(new Color(14, 146, 0));
		}else{
			btnRespostaCinco.setBackground(new Color(14, 146, 0));
		}
	}
	
	public void corBotoesLaranja(int botao)
	{
		if(botao == 1){
			btnRespostaUm.setBackground(Color.ORANGE);
			btnRespostaUm.setForeground(Color.BLACK);
		}else if(botao == 2){
			btnRespostaDois.setBackground(Color.ORANGE);
			btnRespostaDois.setForeground(Color.BLACK);
		}else if(botao == 3){
			btnRespostaTres.setBackground(Color.ORANGE);
			btnRespostaTres.setForeground(Color.BLACK);
		}else if(botao == 4){
			btnRespostaQuatro.setBackground(Color.ORANGE);
			btnRespostaQuatro.setForeground(Color.BLACK);
		}else{
			btnRespostaCinco.setBackground(Color.ORANGE);
			btnRespostaCinco.setForeground(Color.BLACK);
		}
	}
	
	public void corBotoesVermelho(int botao)
	{
		if(botao == 1){
			btnRespostaUm.setBackground(Color.RED);
		}else if(botao == 2){
			btnRespostaDois.setBackground(Color.RED);
		}else if(botao == 3){
			btnRespostaTres.setBackground(Color.RED);
		}else if(botao == 4){
			btnRespostaQuatro.setBackground(Color.RED);
		}else{
			btnRespostaCinco.setBackground(Color.RED);
		}
	}
	
	public void respostaCorreta(int index)
	{
		corBotoesAzul();
		int resposta = 0;
		for (int i = 0; i < listaPergunta.size(); i++) {
			if(listaPergunta.get(i).getCorreta().equals("s")){
				resposta = i + 1;
			}
		}
		corBotoesVerde(resposta);
		if(index == 1){
			corBotoesVermelho(respostaCorreta);
		}
	}

	public void btnConfirmar(JPanel panelCenter)
	{
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setForeground(Color.WHITE);

		btnConfirmar.setFocusPainted(false);
		btnConfirmar.setBackground(new Color(14, 146, 0));
		btnConfirmar.setSize((int)(getWidth() * 0.17), (int)(panelCenter.getHeight() * 0.1));
		btnConfirmar.setLocation((int)(panelCenter.getWidth() * 0.05), (int)(panelCenter.getHeight() * 0.9));
		int tamanhoFonte = (int)(19 * btnConfirmar.getWidth() / 143);

		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 18));
		panelCenter.add(btnConfirmar);

		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(respostaJogador != null && !respostaJogador.isEmpty()){
					JogadoresController jc = new JogadoresController();
					PontuacaoController pc = new PontuacaoController();
					
					if(respostaJogador.equals("s")){
						corBotoesAzul();
						corBotoesVerde(respostaCorreta);
						pc.atualizarPontuacao(getIdEscola(), 1);
						JOptionPane.showMessageDialog(null, "Resposta certa!");
					}else{
						pc.atualizarPontuacao(getIdEscola(), 2);
						respostaCorreta(1);
						JOptionPane.showMessageDialog(null, "Resposta errada!");
					}
					jc.atualizarPerguntaRespondida(getIdPergunta());
					es.stop();
					dispose();
				}	
			}
		});
	}

	public void lblTempo(JPanel panelTempo)
	{
		lblTempo = new JLabel("2:00");
		lblTempo.setForeground(Color.BLACK);
		lblTempo.setSize((int)(panelTempo.getWidth() * 0.45), (int)(panelTempo.getHeight() * 0.4));
		lblTempo.setLocation(local(panelTempo.getWidth(), lblTempo.getWidth(), 50), (int)(panelTempo.getHeight() * 0.1));
		int tamanhoFonte = (int)(100 * lblTempo.getWidth() / 207);
		lblTempo.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelTempo.add(lblTempo);
	}
	
	public void lblTempoMil(JPanel panelTempo)
	{
		lblTempoMil = new JLabel("000");
		lblTempoMil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTempoMil.setForeground(Color.BLACK);
		lblTempoMil.setSize((int)(panelTempo.getWidth() * 0.08), (int)(panelTempo.getHeight() * 0.05));
		lblTempoMil.setLocation(local(panelTempo.getWidth(), lblTempo.getWidth(), 50) + lblTempo.getWidth(), (int)(panelTempo.getHeight() * 0.37));
		//int tamanhoFonte = (int)(15 * lblTempo.getWidth() / 36);
		lblTempoMil.setFont(new Font("Arial", Font.BOLD, 15));
		panelTempo.add(lblTempoMil);
	}

	public void btnIniciar(JPanel panelCenter)
	{
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setForeground(Color.WHITE);

		btnIniciar.setFocusPainted(false);
		btnIniciar.setBackground(new Color(255, 0, 0));
		btnIniciar.setSize((int)(getWidth() * 0.17), (int)(panelCenter.getHeight() * 0.1));
		btnIniciar.setLocation((int)(panelCenter.getWidth() * 0.8), (int)(panelCenter.getHeight() * 0.9));
		int tamanhoFonte = (int)(19 * btnIniciar.getWidth() / 143);

		btnIniciar.setFont(new Font("Arial", Font.BOLD, 18));
		panelCenter.add(btnIniciar);

		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setIniciarTh(1);
			}
		});
	}

	public void setColorLblTempo()
	{
		lblTempoMil.setForeground(Color.RED);
		lblTempo.setForeground(Color.RED);
	}
	
	public void setLblTempo(String tempo)
	{
		lblTempo.setText(tempo);
	}

	public void setLblTempoMil(String tempo)
	{
		lblTempoMil.setText(tempo);
	}
	
	public void setIdEscola(int idEscola)
	{
		this.idEscola = idEscola;
	}

	public int getIdEscola()
	{
		return this.idEscola;
	}

	public void setIdAssunto(int idAssunto)
	{
		this.idAssunto = idAssunto;
	}

	public int getIdAssunto()
	{
		return this.idAssunto;
	}

	public void setIdPergunta(int idPergunta)
	{
		this.idPergunta = idPergunta;
	}

	public int getIdPergunta()
	{
		return this.idPergunta;
	}

	public boolean getNotificacao()
	{
		return notificacao;
	}

	public void setNotificacao(boolean notificacao)
	{
		this.notificacao = notificacao;
	}

	public Insets returnIn()
	{
		Insets in = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
		return in;
	}

	public int local(float tamPanel, float tamContainer, float por){
		por = por / 100;
		float local = (tamPanel - tamContainer) * por;
		return (int)local;
	}

	public int getIniciarTh()
	{
		return iniciarTh;
	}

	public void setIniciarTh(int iniciarTh)
	{
		this.iniciarTh = iniciarTh;
	}

}
