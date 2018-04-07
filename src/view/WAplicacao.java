package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import controller.JogadoresController;
import util.PropriedadesTela;

public class WAplicacao extends JFrame {

	private JPanel contentPane;
	private PropriedadesTela pt;
	private int i;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WAplicacao frame = new WAplicacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WAplicacao() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\LogoFAFICA.jpg"));
		i = 0;
		pt = new PropriedadesTela(returnIn());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		setSize((int)(pt.width() * 0.6), (int)(pt.height() * 0.7));
		
		panelTitulo();
		panelBotoes();
		panelFooter();
		
		
		setLocationRelativeTo(null);
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		
		//zerarGame();
	}
	
	
	
	public void panelTitulo()
	{
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
		panelTitulo.setFocusCycleRoot(true);
		panelTitulo.setBackground(new Color(255, 255, 255));
		panelTitulo.setBounds(0, 0, 750, 236);
		panelTitulo.setSize(getWidth(), (int)(getHeight() * 0.45));
		contentPane.add(panelTitulo);
		panelTitulo.setLayout(null);
		
		lblSlogan(panelTitulo);
		lblTitulo(panelTitulo);
	}
	
	public void lblTitulo(JPanel panelTitulo)
	{
		JLabel lblOlimpadaDeHistria = new JLabel("Olimp\u00EDada de Hist\u00F3ria");
		lblOlimpadaDeHistria.setFont(new Font("Arial", Font.BOLD, 50));
		lblOlimpadaDeHistria.setHorizontalAlignment(SwingConstants.CENTER);
		lblOlimpadaDeHistria.setBounds(0, 72, 570, 59);
		lblOlimpadaDeHistria.setLocation(local(panelTitulo.getWidth(), lblOlimpadaDeHistria.getWidth(), 50), 100);
		panelTitulo.add(lblOlimpadaDeHistria);
		
		JLabel lblFafica = new JLabel("FAFICA");
		lblFafica.setHorizontalAlignment(SwingConstants.CENTER);
		lblFafica.setFont(new Font("Arial", Font.BOLD, 50));
		lblFafica.setBounds(0, 130, 570, 59);
		lblFafica.setLocation(local(panelTitulo.getWidth(), lblFafica.getWidth(), 50), 165);
		panelTitulo.add(lblFafica);
	}
	
	public void lblSlogan(JPanel panelTitulo)
	{
		JLabel lblSlogan = new JLabel("");
		lblSlogan.setBounds(0, 2, 200, 114);
		lblSlogan.setLocation(local(panelTitulo.getWidth(), lblSlogan.getWidth(), 50), 2);
		panelTitulo.add(lblSlogan);
		
		ImageIcon imagem = new ImageIcon("img\\fafica_logo_200x225.png");
		
		lblSlogan.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(lblSlogan.getWidth(), lblSlogan.getHeight(), Image.SCALE_DEFAULT)));;
	}
	
	public void panelBotoes(){
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBorder(new MatteBorder(0, 2, 0, 2, (Color) new Color(0, 0, 0)));
		panelBotoes.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelBotoes.setBackground(new Color(255, 255, 255));
		panelBotoes.setBounds(0, 236, 750, 190);
		panelBotoes.setSize(getWidth(), (int)(getHeight() * 0.45));
		panelBotoes.setLocation(returnIn().left, (int)(getHeight() * 0.45));
		contentPane.add(panelBotoes);
		panelBotoes.setLayout(null);
		
		btnSair(panelBotoes);
		btnIniciar(panelBotoes);
	}
	
	public void panelFooter()
	{
		JPanel panelFooter = new JPanel();
		panelFooter.setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panelFooter.setBackground(new Color(32,37,80));
		panelFooter.setBounds(0, 427, 744, 45);
		panelFooter.setSize(getWidth(), (int)(getHeight() * 0.115));
		panelFooter.setLocation(returnIn().left,(int)(getHeight() * 0.89));
		contentPane.add(panelFooter);
		panelFooter.setLayout(null);
		
		lblCopyright(panelFooter);
	}
	
	public void btnIniciar(JPanel panelBotoes){
		JButton btnIniciar = new JButton();	
		getRootPane().setDefaultButton(btnIniciar);
		btnIniciar.setBackground(new Color(66, 231, 20));
		btnIniciar.setBorder(new CompoundBorder(new LineBorder(new Color(51, 153, 51), 2, true), null));
		btnIniciar.setFocusPainted(false);
		ImageIcon imagem = new ImageIcon("img\\Setinha_60x60.png");
		btnIniciar.setIcon(imagem);
		btnIniciar.setSize((int)(panelBotoes.getWidth() * 0.22), (int)(panelBotoes.getHeight() * 0.26));
		btnIniciar.setLocation(local(panelBotoes.getWidth(), btnIniciar.getWidth(), 50), (int)(panelBotoes.getHeight() * 0.20));
		panelBotoes.add(btnIniciar);
		
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				WInserirJogadores in = new WInserirJogadores();
				in.main(null);
				
			}
		});
	}
	
	public void btnSair(JPanel panelBotoes){

		JButton btnSair = new JButton();
		btnSair.setHorizontalTextPosition(SwingConstants.LEFT);
		btnSair.setFocusPainted(false);
		btnSair.setBorder(new CompoundBorder(new LineBorder(new Color(255, 0, 0)), new EmptyBorder(1, 1, 1, 1)));
		btnSair.setBackground(new Color(255, 0, 0));
		btnSair.setFont(new Font("Arial", Font.BOLD, 22));
		ImageIcon imagem = new ImageIcon("img\\Xiszinho_60x60.png");
		btnSair.setIcon(imagem);
		btnSair.setSize((int)(panelBotoes.getWidth() * 0.22), (int)(panelBotoes.getHeight() * 0.26));
		int alturaY = (int)(panelBotoes.getHeight() * 0.20) + btnSair.getHeight() + (int)(panelBotoes.getHeight() * 0.10);
		btnSair.setLocation(local(panelBotoes.getWidth(), btnSair.getWidth(), 50), alturaY);
		panelBotoes.add(btnSair);
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
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
}
