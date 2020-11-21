package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controller.JogadoresController;
import model.bean.Player;
import util.PropriedadesTela;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WJogadores extends JFrame {

	private JPanel contentPane;
	private DefaultListModel model;
	private JList listaJogadores;
	private PropriedadesTela pt;
	private JButton btnJogar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WJogadores frame = new WJogadores();
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
	public WJogadores() {
		pt = new PropriedadesTela(returnIn());
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\LogoFAFICA.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBackground(new Color(255, 255, 255));
		setResizable(false);
		setUndecorated(true);
		
		tamanhoTela();
		design();
	}
	
	public void design()
	{
		btnFechar();
		panelHeader();
		panelCenter();
		panelRodape();
	}
	
	public void tamanhoTela()
	{
		setSize((int)(pt.width()), (int)(pt.height()));
		//setLocation(returnIn().left,returnIn().top);
		setLocationRelativeTo(null);
	}
	
	public void panelHeader()
	{
		JPanel panelHeader = new JPanel();
		panelHeader.setBounds(0, 0, 1914, 45);
		panelHeader.setBackground(new Color(25,30,65)); // cor certa para header e footer
		contentPane.add(panelHeader);
		panelHeader.setLayout(null);
		
		panelHeader.setSize(pt.width(), (int)(pt.height() * 0.07));
		
		lblSlogan(panelHeader);
	}
	
	public void panelCenter(){
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(new Color(255, 255, 255));
		panelCenter.setSize(getWidth(), (int)(getHeight() * 0.838));
		panelCenter.setLocation(returnIn().left, (int)(getHeight() * 0.07));
		contentPane.add(panelCenter);
		panelCenter.setLayout(null);
		
		panelJogadores(panelCenter);
		lblOlimpiadaFafica(panelCenter);
	}
	
	public void panelJogadores(JPanel panelCenter){
		JPanel panelJogadores = new JPanel();
		panelJogadores.setBackground(new Color(255, 255, 255));
		panelJogadores.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panelJogadores.setSize((int)(panelCenter.getWidth() * 0.31), (int)(panelCenter.getHeight() * 0.7));
		panelJogadores.setLocation(local(panelCenter.getWidth(), panelJogadores.getWidth(), 50), (int)(panelCenter.getHeight() * 0.25));
		panelCenter.add(panelJogadores);
		panelJogadores.setLayout(null);
		
		list(panelJogadores);	
		btnJogar(panelJogadores);
		btnRanking(panelJogadores);
	}
	
	public void panelRodape()
	{
		JPanel panelRodape = new JPanel();
		panelRodape.setBounds(0, 952, 1914, 45);
		panelRodape.setBackground(new Color(25,30,65)); 
		contentPane.add(panelRodape);
		panelRodape.setLayout(null);
		
		panelRodape.setSize(pt.width(), (int)(pt.height() * 0.10));
		panelRodape.setLocation(returnIn().left, (int)(getHeight() * 0.9));
	
		lblCopyright(panelRodape);
		
	}
	
	public void lblCopyright(JPanel panelRodape)
	{
		JLabel lblCopyright = new JLabel("� Copyright Grey Tool Co.");
		lblCopyright.setForeground(new Color(255, 255, 255));
		lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyright.setSize((int)(panelRodape.getWidth() * 0.35), (int)(panelRodape.getHeight() * 0.5));
		lblCopyright.setLocation(local(panelRodape.getWidth(), lblCopyright.getWidth(), 50), local(panelRodape.getHeight(), lblCopyright.getHeight(), 50));
		int tamanhoFonte = (int)(19 * lblCopyright.getWidth() / 403);
		lblCopyright.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelRodape.add(lblCopyright);
	}
	
	public void lblSlogan(JPanel panelHeader){
		JLabel lblSlogan = new JLabel("");
		lblSlogan.setSize((int)(panelHeader.getWidth() * 0.15), panelHeader.getHeight() - 4);
		lblSlogan.setLocation(2,2);
		ImageIcon imagem = new ImageIcon("img\\Header_Bar_787x206.png");
		lblSlogan.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(lblSlogan.getWidth(), lblSlogan.getHeight(), Image.SCALE_DEFAULT)));
		panelHeader.add(lblSlogan);
	}
	
	public void lblOlimpiadaFafica(JPanel panelCenter){
		JLabel lblOlimpadaDeHistria = new JLabel("Selecione a Escola");
		lblOlimpadaDeHistria.setFont(new Font("Arial", Font.BOLD, 60));
		lblOlimpadaDeHistria.setHorizontalAlignment(SwingConstants.CENTER);
		lblOlimpadaDeHistria.setSize(750, 100);
		lblOlimpadaDeHistria.setLocation(local(panelCenter.getWidth(), lblOlimpadaDeHistria.getWidth(), 50), (int)(panelCenter.getHeight() * 0.06));
		panelCenter.add(lblOlimpadaDeHistria);
	}
	
	public void btnFechar()
	{
		JButton btnFechar = new JButton();
		btnFechar.setBounds(331, 142, 169, 55);
		btnFechar.setSize((int)(getHeight()* 0.05), (int)(getHeight()* 0.05));
		btnFechar.setLocation((int)(getWidth() * 0.97), (int)(getHeight() * 0.01));

		ImageIcon imagem = new ImageIcon("img\\FontAwesome_f00d(0)_32.png");
		btnFechar.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(btnFechar.getWidth(), btnFechar.getHeight(), Image.SCALE_DEFAULT)));
		
		contentPane.add(btnFechar);
		
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja fechar?", "Oh Fafica",JOptionPane.YES_NO_OPTION);
				if(resposta == JOptionPane.YES_OPTION){
					JogadoresController jc = new JogadoresController();
					jc.zerarGame();
					dispose();
				}else if(resposta == JOptionPane.NO_OPTION){
					
				}
				
			}
		});
	}
	
	public void btnJogar(JPanel panelJogadores)
	{
		btnJogar = new JButton("Jogar");
		btnJogar.setForeground(Color.WHITE);
		
		btnJogar.setFocusPainted(false);
		btnJogar.setBackground(new Color(32,37,80));
		btnJogar.setSize((int)(panelJogadores.getWidth() * 0.3), (int)(panelJogadores.getHeight() * 0.1));
		btnJogar.setLocation(local(panelJogadores.getWidth(), btnJogar.getWidth(), 80), (int)(panelJogadores.getHeight() * 0.85));
		int tamanhoFonte = (int)(20 * btnJogar.getWidth() / 126);
		btnJogar.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelJogadores.add(btnJogar);
		
		getRootPane().setDefaultButton(btnJogar);
		
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JogadoresController jc = new JogadoresController();
				
				if(listaJogadores.getSelectedIndex() >= 0){
					int id = jc.listarJogadores().get(listaJogadores.getSelectedIndex()).getId();
					String nome = jc.listarJogadores().get(listaJogadores.getSelectedIndex()).getNome();
					WAssuntos a = new WAssuntos(id, nome);
					a.main(null);
				}else{
					JOptionPane.showMessageDialog(null, "Nenhum jogador selecionado");
				}
				
			}
		});
	}
	
	public void btnRanking(JPanel panelJogadores){
		JButton btnRanking = new JButton("Ranking");
		btnRanking.setForeground(Color.WHITE);
		btnRanking.setFocusPainted(false);
		btnRanking.setBackground(new Color(32,37,80));
		btnRanking.setSize((int)(panelJogadores.getWidth() * 0.3), (int)(panelJogadores.getHeight() * 0.1));
		btnRanking.setLocation(local(panelJogadores.getWidth(), btnRanking.getWidth(), 20), (int)(panelJogadores.getHeight() * 0.85));
		int tamanhoFonte = (int)(19 * btnRanking.getWidth() / 126);
		btnRanking.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelJogadores.add(btnRanking);
		
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WRanking rk = new WRanking();
				rk.main(null);
			}
		});
	}
	
	public void list(JPanel panelJogadores)
	{
		JogadoresController jc = new JogadoresController();
		
		listaJogadores = new JList();
		model = new DefaultListModel();
		listaJogadores.setModel(model);
		
		listaJogadores.setFont(new Font("Arial", Font.PLAIN, 25));
		listaJogadores.setBackground(new Color(255,255,255));
		listaJogadores.setSize((int)(panelJogadores.getWidth() * 0.8), (int)(panelJogadores.getHeight() * 0.7));
		listaJogadores.setLocation(local(panelJogadores.getWidth(), listaJogadores.getWidth(), 50), (int)(panelJogadores.getHeight() * 0.1));
		panelJogadores.add(listaJogadores);
		
		List<Player> jg = new ArrayList<Player>();
		jg.addAll(jc.listarJogadores());
		
		jg.forEach(n -> model.addElement(n.getNome().toString()));//Express�o lambda para impress�o dos jogadores no list
	}
	
	/**
	 * 
	 * @return
	 */
	
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
