package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemColor;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import controller.JogadoresController;
import model.bean.Jogador;
import util.PropriedadesTela;


public class WInserirJogadores extends JFrame {

	private JPanel contentPane;
	private int i;
	private JTextField tfNomeJogador;
	private JButton btnAceitar;
	public static List<String> listaJogadores;
	private JList listaJogadoresAtt;
	private DefaultListModel model;
	private JButton btnAdicionar;
	private PropriedadesTela pt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WInserirJogadores frame = new WInserirJogadores();
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
	public WInserirJogadores() {
		pt = new PropriedadesTela(returnIn());
		listaJogadores = new ArrayList<String>();
		i = 0;
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\LogoFAFICA.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		setSize((int)(pt.width() * 0.6), (int)(pt.height() * 0.7));
		 
		design();
		
		setLocationRelativeTo(null);
	}
	
	public void design()
	{
		panelHeader();
		panelAddJogadores();
		panelListaJogadores();
		panelFooter();
	}
	
	public void panelHeader()
	{
		JPanel panelHeader = new JPanel();
		panelHeader.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
		panelHeader.setBounds(0, 0, 744, 45);
		panelHeader.setBackground(new Color(32,37,80));
		contentPane.add(panelHeader);
		panelHeader.setLayout(null);
		panelHeader.setSize(getWidth(), (int)(getHeight()* 0.07));
		
		lblSlogan(panelHeader);
		btnFechar(panelHeader);
	}
	
	public void panelAddJogadores()
	{
		JPanel panelAddJogadores = new JPanel();
		panelAddJogadores.setBorder(new MatteBorder(0, 2, 0, 2, (Color) new Color(0, 0, 0)));
		panelAddJogadores.setBackground(SystemColor.text);
		panelAddJogadores.setBounds(0, 45, 372, 382);
		contentPane.add(panelAddJogadores);
		panelAddJogadores.setLayout(null);
		
		panelAddJogadores.setSize((int)(getWidth() * 0.5), (int)(getHeight() * 0.86));
		panelAddJogadores.setLocation(returnIn().left, (int)(getHeight() * 0.07)); 
			
		tfNomeJogador(panelAddJogadores);
		lblPanelAddjogadores(panelAddJogadores);
		
		btnAdicionar(panelAddJogadores);
	}
	
	public void panelListaJogadores()
	{
		JPanel panelListaJogadores = new JPanel();
		panelListaJogadores.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)));
		panelListaJogadores.setBackground(SystemColor.text);
		panelListaJogadores.setBounds(372, 45, 372, 382);
		contentPane.add(panelListaJogadores);
		panelListaJogadores.setLayout(null);
		
		panelListaJogadores.setSize((int)(getWidth() * 0.5), (int)(getHeight() * 0.86));
		panelListaJogadores.setLocation((int)(getWidth() * 0.5), (int)(getHeight() * 0.07)); 
		
		btnAceitar(panelListaJogadores);
		btnRemover(panelListaJogadores);
		list(panelListaJogadores);
	}
	
	public void panelFooter()
	{
		JPanel panelFooter = new JPanel();
		panelFooter.setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panelFooter.setBounds(0, 427, 744, 45);
		panelFooter.setBackground(new Color(32,37,80));
		contentPane.add(panelFooter);
		panelFooter.setLayout(null);
		panelFooter.setSize(getWidth(), (int)(getHeight() * 0.08));
		panelFooter.setLocation(returnIn().left, (int)(getHeight() * 0.93)); 	
		
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
	
	//Início da parte do JPanel panelHeader
	public void lblSlogan(JPanel panelHeader){
		JLabel lblSlogan = new JLabel("");
		lblSlogan.setSize((int)(panelHeader.getWidth() * 0.15), panelHeader.getHeight() - 4);
		lblSlogan.setLocation(2,2);
		ImageIcon imagem = new ImageIcon("img\\Header_Bar_787x206.png");
		lblSlogan.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(lblSlogan.getWidth(), lblSlogan.getHeight(), Image.SCALE_DEFAULT)));
		panelHeader.add(lblSlogan);
	}
	
	public void btnFechar(JPanel panelHeader)
	{
		JButton btnFechar = new JButton();
		btnFechar.setBounds(331, 142, 169, 55);
		btnFechar.setSize((int)(panelHeader.getHeight()* 0.65), (int)(panelHeader.getHeight()* 0.65));
		btnFechar.setLocation((int)(panelHeader.getWidth() * 0.97), (int)(panelHeader.getHeight() * 0.1));

		ImageIcon imagem = new ImageIcon("img\\FontAwesome_f00d(0)_32.png");
		btnFechar.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(btnFechar.getWidth(), btnFechar.getHeight(), Image.SCALE_DEFAULT)));
		
		panelHeader.add(btnFechar);
		
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja fechar?", "Olimpíada de História Fafica",JOptionPane.YES_NO_OPTION);
				if(resposta == JOptionPane.YES_OPTION){
					JogadoresController jc = new JogadoresController();
					jc.zerarGame();
					dispose();
				}else if(resposta == JOptionPane.NO_OPTION){
					
				}
			}
		});
	}
	//Fim da parte do JPanel panelHeader
	
	//Início da parte do JPanel panelAddJogador
	public void tfNomeJogador(JPanel panelAddJogadores)
	{
		tfNomeJogador = new JTextField();
		tfNomeJogador.setFont(new Font("Arial", Font.PLAIN, 20));
		tfNomeJogador.setSize((int)(panelAddJogadores.getWidth()* 0.6), (int)(panelAddJogadores.getHeight()* 0.08));
		tfNomeJogador.setLocation(local(panelAddJogadores.getWidth(), tfNomeJogador.getWidth(), 67), (int)(panelAddJogadores.getHeight() * 0.29));
		panelAddJogadores.add(tfNomeJogador);
		tfNomeJogador.setColumns(10);
		tfNomeJogador.grabFocus();
	}
	
	public void btnAdicionar(JPanel panelAddJogadores)
	{
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(SystemColor.text);
		btnAdicionar.setFocusPainted(false);
		btnAdicionar.setBackground(new Color(32,37,80));
		btnAdicionar.setFont(new Font("Arial", Font.BOLD, 20));
		btnAdicionar.setSize((int)(getWidth() * 0.17), (int)(panelAddJogadores.getHeight() * 0.1));
		btnAdicionar.setLocation(local(panelAddJogadores.getWidth(), btnAdicionar.getWidth(), 70), (int)(panelAddJogadores.getHeight() * 0.45));
		
		getRootPane().setDefaultButton(btnAdicionar);
		
		panelAddJogadores.add(btnAdicionar);
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = tfNomeJogador.getText().toString().toUpperCase();
				int contador = 0;
				if(nome.isEmpty()){
					JOptionPane.showMessageDialog(null, "Por favor, insira o nome do jogador.", "OHF - Erro", JOptionPane.ERROR_MESSAGE);
				}else if(nome.length() > 15){
					JOptionPane.showMessageDialog(null, "Insira um nome de jogador com no máximo 15 caracteres.",
												  "OHF - Erro", JOptionPane.ERROR_MESSAGE);
				}else{
					if(!listaJogadores.isEmpty()){
						for (int i = 0; i < listaJogadores.size(); i++) {
							if(nome.equals(listaJogadores.get(i))){
								contador++;
							}
						}
					}
					if(contador == 0){
						listaJogadores.add(nome);
						model.addElement(listaJogadores.get(i));
						i++;
						tfNomeJogador.setText("");
					}else{
						JOptionPane.showMessageDialog(null, "O jogador " + nome + " já existe.");
					}
				}
				
				if(listaJogadores.size() == 6){
					btnAdicionar.setEnabled(false);
					getRootPane().setDefaultButton(btnAceitar);
				}
				
			}
		});
		
	}
	
	public void lblPanelAddjogadores(JPanel panelAddJogadores)
	{
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setSize((int)(panelAddJogadores.getWidth()*0.15), (int)(panelAddJogadores.getHeight()*0.1));
		int tamanhoFonte = (int)(20 * lblNome.getWidth() / 65);
		lblNome.setLocation((int)(panelAddJogadores.getWidth()*0.1), (int)(panelAddJogadores.getHeight() * 0.275));
		lblNome.setFont(new Font("Arial", Font.PLAIN, tamanhoFonte));
		panelAddJogadores.add(lblNome);
		
		JLabel lblAddJogadores = new JLabel("Adicionar Jogadores");
		lblAddJogadores.setFont(new Font("Arial", Font.PLAIN, 28));
		lblAddJogadores.setSize(259, 56);
		lblAddJogadores.setLocation(local(panelAddJogadores.getWidth(), lblAddJogadores.getWidth(), 50), (int)(panelAddJogadores.getHeight() * 0.07));
		panelAddJogadores.add(lblAddJogadores);
	}
	//Fim da parte do JPanel panelAddJogador
	
	//Início da parte do JPanel panelListaJogadores
	public void btnAceitar(JPanel panelListaJogadores)
	{
		btnAceitar = new JButton("Aceitar");
		btnAceitar.setForeground(SystemColor.text);
		btnAceitar.setFocusPainted(false);
		btnAceitar.setBackground(new Color(32,37,80));
		btnAceitar.setFont(new Font("Arial", Font.BOLD, 20));
		btnAceitar.setSize((int)(getWidth() * 0.17), (int)(panelListaJogadores.getHeight() * 0.1));
		btnAceitar.setLocation(local(panelListaJogadores.getWidth(), btnAceitar.getWidth(), 80), (int)(panelListaJogadores.getHeight() * 0.85));
		panelListaJogadores.add(btnAceitar);
		
		btnAceitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomeIgual = "";
				int contador = 0;
				if(listaJogadores.size() == 6){	
					JogadoresController jc =  new JogadoresController();
					for (int i = 0; i < listaJogadores.size(); i++) {
						jc.insertJogador(listaJogadores.get(i));
					}
					
					List<Jogador> lj = new ArrayList<Jogador>();
					lj.addAll(jc.listarJogadores());
					
					for (int i = 0; i < lj.size(); i++) {
						jc.insertPontuacao(lj.get(i).getId());
					}
					
					WJogadores wj = new WJogadores();
					dispose();
					wj.main(null);
				}else if(!listaJogadores.isEmpty()){
					JOptionPane.showMessageDialog(null, "É necessário 6 jogadores para iniciar.\nFaltam " + (6 - listaJogadores.size()) + " jogadores", "OHF - Erro", JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Nenhum jogador inserido.", "OHF - Erro", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
	}
	
	public void btnRemover(JPanel panelListaJogadores)
	{
		JButton btnRemover = new JButton("Remover");
		btnRemover.setForeground(SystemColor.text);
		btnRemover.setFocusPainted(false);
		btnRemover.setBackground(new Color(32,37,80));
		btnRemover.setFont(new Font("Arial", Font.BOLD, 20));
		btnRemover.setSize((int)(getWidth() * 0.17), (int)(panelListaJogadores.getHeight() * 0.1));
		btnRemover.setLocation(local(panelListaJogadores.getWidth(), btnRemover.getWidth(), 20), (int)(panelListaJogadores.getHeight() * 0.85));
		panelListaJogadores.add(btnRemover);
		
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!listaJogadores.isEmpty() && listaJogadoresAtt.getSelectedIndex() >= 0){
					listaJogadores.remove(listaJogadoresAtt.getSelectedIndex());
					model.removeElementAt(listaJogadoresAtt.getSelectedIndex());
					i--;
					tfNomeJogador.grabFocus();
				}
				if(listaJogadores.size() < 6){
					btnAdicionar.setEnabled(true);
					tfNomeJogador.grabFocus();
					getRootPane().setDefaultButton(btnAdicionar);
				}
			}
		});
	}
	
	public void list(JPanel panelListaJogadores)
	{
		listaJogadoresAtt = new JList();
		listaJogadoresAtt.setFont(new Font("Arial", Font.PLAIN, 25));
		listaJogadoresAtt.setSize(297, 261);
		listaJogadoresAtt.setLocation(local(panelListaJogadores.getWidth(), listaJogadoresAtt.getWidth(), 50), (int)(panelListaJogadores.getHeight() * 0.1));
		panelListaJogadores.add(listaJogadoresAtt);
		
		model = new DefaultListModel();
		listaJogadoresAtt.setModel(model);
	}
	//Fim da parte do JPanel panelListaJogadores
	
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
