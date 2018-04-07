package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.JogadoresController;
import controller.PontuacaoController;
import model.bean.Jogador;
import model.bean.Pontuacao;
import util.PropriedadesTela;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.border.MatteBorder;
import java.awt.Rectangle;
import java.awt.Component;

public class WRanking extends JDialog {

	private final JPanel contentPanel = new JPanel();
	PontuacaoController pc;
	private int j = 0;
	private JLabel lblEscola1;
	private JLabel lblEscola2;
	private JLabel lblEscola3;
	private JLabel lblEscola4;
	private JLabel lblEscola5;
	private JLabel lblEscola6;
	private JLabel lblRespostaCerta1;
	private JLabel lblRespostaCerta2;
	private JLabel lblRespostaCerta3;
	private JLabel lblRespostaCerta4;
	private JLabel lblRespostaCerta5;
	private JLabel lblRespostaCerta6;
	private JLabel lblRespostaErrada1;
	private JLabel lblRespostaErrada2;
	private JLabel lblRespostaErrada3;
	private JLabel lblRespostaErrada4;
	private JLabel lblRespostaErrada5;
	private JLabel lblRespostaErrada6;
	private JLabel lblFaltaResponder1;
	private JLabel lblFaltaResponder2;
	private JLabel lblFaltaResponder3;
	private JLabel lblFaltaResponder4;
	private JLabel lblFaltaResponder5;
	private JLabel lblFaltaResponder6;
	private JLabel lbl1PanelAjuda;
	private JLabel lbl2PanelAjuda;
	private JLabel lbl3PanelAjuda;
	private JLabel lblPanelAjudaCor1;
	private JLabel lblPanelAjudaCor2;
	private JLabel lblPanelAjudaCor3;
	private JPanel panelAjuda;
	private PropriedadesTela pt;
	private JPanel panelLugarNome;
	private JPanel panelLugarRespostaCerta;
	private JPanel panelLugarRespostaErrada;
	private JPanel panelLugarFaltaResponder;
	private JPanel panelPrincipal;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WRanking dialog = new WRanking();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WRanking() 
	{
		pt = new PropriedadesTela(returnIn());
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setModal(true);
		
		tamanhoTela();
		
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		panelHeader();
		panelRodape();
		panelPrincipal();
		
		setLocationRelativeTo(null);
	}
	
	
	public void tamanhoTela()
	{
		setSize((int)(pt.width() * 0.8), (int)(pt.height() * 0.8));
		setLocationRelativeTo(null);
		setModal(true);
	}
	
	public void panelHeader()
	{
		JPanel panelHeader = new JPanel();
		panelHeader.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
		panelHeader.setSize(getWidth(), (int)(getHeight()* 0.07));
		panelHeader.setBackground(new Color(25,30,65)); // cor certa para header e footer
		contentPanel.add(panelHeader);
		panelHeader.setLayout(null);
		
		lblSlogan(panelHeader);
	}
	
	public void panelPrincipal(){
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new MatteBorder(0, 2, 0, 2, (Color) new Color(0, 0, 0)));
		panelPrincipal.setSize(getWidth(), (int)(getHeight() * 0.87));
		panelPrincipal.setLocation(returnIn().left, (int)(getHeight() * 0.07)); 
		contentPanel.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		panelAjuda(panelPrincipal);
		panelLugar(panelPrincipal);
		panelLugarNome(panelPrincipal);
		panelLugarRespostaCerta(panelPrincipal);
		panelLugarRespostaErrada(panelPrincipal);
		panelLugarFaltaResponder(panelPrincipal);
		listaRankNome();
		listaRankResposta();

		btnVoltar(panelPrincipal);
		lblRanking(panelPrincipal);	
	}
	
	public void panelAjuda(JPanel panelPrincipal){
		
		panelAjuda = new JPanel();
		panelAjuda.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panelAjuda.setSize((int)(panelPrincipal.getWidth() * 0.27), (int)(panelPrincipal.getHeight() * 0.3));
		panelAjuda.setLocation((int)(panelPrincipal.getWidth() * 0.725), (int)(getHeight() * 0.285)); 
		panelPrincipal.add(panelAjuda);
		panelAjuda.setLayout(null);
		
		lblAjudaCor(panelAjuda);
		lblLegendaRanking(panelAjuda);
	}
	
	public void panelLugar(JPanel panelPrincipal)
	{
		JPanel panelLugar = new JPanel();
		panelLugar.setSize((int)(panelPrincipal.getWidth() * 0.04), (int)(panelPrincipal.getHeight() * 0.5));
		panelLugar.setLocation((int)(panelPrincipal.getWidth() * 0.10), (int)(getHeight() * 0.20)); 
		panelLugar.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panelPrincipal.add(panelLugar);
		panelLugar.setLayout(null);
		
		lblClassificacao(panelLugar);
	}
	
	public void panelLugarNome(JPanel panelPrincipal){
		panelLugarNome = new JPanel();
		panelLugarNome.setSize((int)(panelPrincipal.getWidth() * 0.5), (int)(panelPrincipal.getHeight() * 0.5));
		panelLugarNome.setLocation((int)(panelPrincipal.getWidth() * 0.10), (int)(getHeight() * 0.20)); 
		panelLugarNome.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panelPrincipal.add(panelLugarNome);
		panelLugarNome.setLayout(null);
	}
	
	public void panelLugarRespostaErrada(JPanel panelPrincipal){
		panelLugarRespostaErrada = new JPanel();
		panelLugarRespostaErrada.setSize((int)(panelPrincipal.getWidth() * 0.44), (int)(panelPrincipal.getHeight() * 0.5));
		panelLugarRespostaErrada.setLocation((int)(panelPrincipal.getWidth() * 0.24), (int)(getHeight() * 0.20)); 
		panelLugarRespostaErrada.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panelPrincipal.add(panelLugarRespostaErrada);
		panelLugarRespostaErrada.setLayout(null);
	}
	
	public void panelLugarRespostaCerta(JPanel panelPrincipal){
		panelLugarRespostaCerta = new JPanel();
		panelLugarRespostaCerta.setSize((int)(panelPrincipal.getWidth() * 0.4), (int)(panelPrincipal.getHeight() * 0.5));
		panelLugarRespostaCerta.setLocation((int)(panelPrincipal.getWidth() * 0.24), (int)(getHeight() * 0.20)); 
		panelLugarRespostaCerta.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panelPrincipal.add(panelLugarRespostaCerta);
		panelLugarRespostaCerta.setLayout(null);
	}
	
	public void panelLugarFaltaResponder(JPanel panelPrincipal){
		panelLugarFaltaResponder = new JPanel();
		panelLugarFaltaResponder.setSize((int)(panelPrincipal.getWidth() * 0.48), (int)(panelPrincipal.getHeight() * 0.5));
		panelLugarFaltaResponder.setLocation((int)(panelPrincipal.getWidth() * 0.24), (int)(getHeight() * 0.20)); 
		panelLugarFaltaResponder.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panelPrincipal.add(panelLugarFaltaResponder);
		panelLugarFaltaResponder.setLayout(null);
	}
	
	public void panelRodape()
	{
		JPanel panelRodape = new JPanel();
		panelRodape.setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panelRodape.setBackground(new Color(25,30,65)); 
		contentPanel.add(panelRodape);
		
		panelRodape.setSize(getWidth(), (int)(getHeight() * 0.08));
		panelRodape.setLocation(returnIn().left, (int)(getHeight() * 0.93));
		

		panelRodape.setLayout(null);
		lblCopyright(panelRodape);
	}
	
	public void lblCopyright(JPanel panelRodape)
	{
		JLabel lblCopyright = new JLabel("© Copyright Grey Tool Co.");
		lblCopyright.setForeground(new Color(255, 255, 255));
		lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyright.setSize((int)(panelRodape.getWidth() * 0.35), (int)(panelRodape.getHeight() * 0.5));
		lblCopyright.setLocation(local(panelRodape.getWidth(), lblCopyright.getWidth(), 50), local(panelRodape.getHeight(), lblCopyright.getHeight(), 50));
		int tamanhoFonte = (int)(19 * lblCopyright.getWidth() / 403);
		lblCopyright.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelRodape.add(lblCopyright);
	}
	
	public void btnVoltar(JPanel panelPrincipal)
	{
		JButton button = new JButton("Voltar");
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setBackground(Color.RED);
		button.setSize((int)(getWidth() * 0.17), (int)(panelPrincipal.getHeight() * 0.1));
		button.setLocation((int)(panelPrincipal.getWidth() * 0.02), (int)(panelPrincipal.getHeight() * 0.83) );
		int tamanhoFonte = (int)(27 * button.getWidth() / 143);
		button.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		getRootPane().setDefaultButton(button);
		panelPrincipal.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
	
	public void lblRanking(JPanel panel){
		JLabel lblRanking = new JLabel("Ranking");
		lblRanking.setHorizontalAlignment(SwingConstants.CENTER);
		lblRanking.setSize((int)(panel.getWidth() * 0.4), (int)(panel.getHeight() * 0.15));
		lblRanking.setLocation((int)(panel.getWidth() * 0.30), (int)(getHeight() * 0.01)); 
		int tamanhoFonte = (int)(80 * lblRanking.getWidth() / 576);
		lblRanking.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panel.add(lblRanking);
	}
	
	
	
	public void lblSlogan(JPanel panelHeader){
		JLabel lblSlogan = new JLabel("");
		lblSlogan.setSize((int)(panelHeader.getWidth() * 0.15), panelHeader.getHeight() - 4);
		lblSlogan.setLocation(2,2);
		ImageIcon imagem = new ImageIcon("img\\Header_Bar_787x206.png");
		lblSlogan.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(lblSlogan.getWidth(), lblSlogan.getHeight(), Image.SCALE_DEFAULT)));
		panelHeader.add(lblSlogan);
	}
	
	public void lblAjudaCor(JPanel panelAjuda){

		JLabel lblPanelAjudaCor1 = new JLabel("asd");
		lblPanelAjudaCor1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GREEN));
		lblPanelAjudaCor1.setOpaque(true);
		lblPanelAjudaCor1.setBackground(Color.GREEN);
		lblPanelAjudaCor1.setForeground(Color.GREEN);
		lblPanelAjudaCor1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelAjudaCor1.setSize((int)(panelAjuda.getWidth() * 0.09), (int)(panelAjuda.getHeight() * 0.15));
		lblPanelAjudaCor1.setLocation((int)(panelAjuda.getWidth() * 0.01), (int)(getHeight() * 0.01)); 
		panelAjuda.add(lblPanelAjudaCor1);
		
		JLabel lblPanelAjudaCor2 = new JLabel("asd");
		lblPanelAjudaCor2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
		lblPanelAjudaCor2.setOpaque(true);
		lblPanelAjudaCor2.setBackground(Color.RED);
		lblPanelAjudaCor2.setForeground(Color.RED);
		lblPanelAjudaCor2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelAjudaCor2.setSize((int)(panelAjuda.getWidth() * 0.09), (int)(panelAjuda.getHeight() * 0.15));
		lblPanelAjudaCor2.setLocation((int)(panelAjuda.getWidth() * 0.01), (int)(panelAjuda.getHeight()* 0.275)+ (lblPanelAjudaCor2.getHeight())); 
		panelAjuda.add(lblPanelAjudaCor2);
		
		JLabel lblPanelAjudaCor3 = new JLabel("asd");
		lblPanelAjudaCor3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.ORANGE));
		lblPanelAjudaCor3.setOpaque(true);
		lblPanelAjudaCor3.setBackground(Color.ORANGE);
		lblPanelAjudaCor3.setForeground(Color.ORANGE);
		lblPanelAjudaCor3.setHorizontalAlignment(SwingConstants.CENTER);		
		lblPanelAjudaCor3.setSize((int)(panelAjuda.getWidth() * 0.09), (int)(panelAjuda.getHeight() * 0.15));
		lblPanelAjudaCor3.setLocation((int)(panelAjuda.getWidth() * 0.01), (int)(panelAjuda.getHeight()* 0.524)+ (lblPanelAjudaCor3.getHeight()*2));
		panelAjuda.add(lblPanelAjudaCor3);
		
	}
	
	public void lblLegendaRanking(JPanel panelAjuda){
		lbl1PanelAjuda = new JLabel("Acertos");
		lbl1PanelAjuda.setHorizontalAlignment(SwingConstants.LEFT);
		lbl1PanelAjuda.setSize(panelAjuda.getWidth(), (int)(panelAjuda.getHeight() * 0.1666667));
		lbl1PanelAjuda.setLocation((int)(panelAjuda.getWidth() * 0.12), (int)(panelAjuda.getHeight() * 0.02));
		int tamanhoFonte = (int)(130 * lbl1PanelAjuda.getWidth() / 1440);
		lbl1PanelAjuda.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelAjuda.add(lbl1PanelAjuda);
		
		lbl2PanelAjuda = new JLabel("Erros");
		lbl2PanelAjuda.setHorizontalAlignment(SwingConstants.LEFT);
		lbl2PanelAjuda.setSize(panelAjuda.getWidth(), (int)(panelAjuda.getHeight() * 0.1666667));
		lbl2PanelAjuda.setLocation((int)(panelAjuda.getWidth() * 0.12), (int)(panelAjuda.getHeight() * 0.255) + (lbl2PanelAjuda.getHeight()));
		lbl2PanelAjuda.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelAjuda.add(lbl2PanelAjuda);
		
		lbl3PanelAjuda = new JLabel("Falta Responder");
		lbl3PanelAjuda.setHorizontalAlignment(SwingConstants.LEFT);
		lbl3PanelAjuda.setSize(panelAjuda.getWidth(), (int)(panelAjuda.getHeight() * 0.1666667));
		lbl3PanelAjuda.setLocation((int)(panelAjuda.getWidth() * 0.12), (int)(panelAjuda.getHeight() * 0.486) + (lbl3PanelAjuda.getHeight()*2));
		lbl3PanelAjuda.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelAjuda.add(lbl3PanelAjuda);
	}
	
	public void lblClassificacao(JPanel panelLugar){
		JLabel label1 = new JLabel("1");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setSize(panelLugar.getWidth(), (int)(panelLugar.getHeight() * 0.1666667));
		label1.setLocation(0, (int)(panelLugar.getHeight() * 0.01));
		int tamanhoFonte = (int)(60 * label1.getWidth() / 57);
		label1.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugar.add(label1);
		
		JLabel label2 = new JLabel("2");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setSize(panelLugar.getWidth(), (int)(panelLugar.getHeight() * 0.1666667));
		label2.setLocation(0, (int)(panelLugar.getHeight() * 0.005) + (label2.getHeight()));
		label2.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugar.add(label2);
		
		JLabel label3 = new JLabel("3");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setSize(panelLugar.getWidth(), (int)(panelLugar.getHeight() * 0.1666667));
		label3.setLocation(0, (int)(panelLugar.getHeight() * 0.006) + (label3.getHeight() * 2));
		label3.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugar.add(label3);
		
		JLabel label4 = new JLabel("4");
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setSize(panelLugar.getWidth(), (int)(panelLugar.getHeight() * 0.1666667));
		label4.setLocation(0, (int)(panelLugar.getHeight() * 0.007) + (label4.getHeight() * 3));
		label4.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugar.add(label4);
		
		JLabel label5 = new JLabel("5");
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setSize(panelLugar.getWidth(), (int)(panelLugar.getHeight() * 0.1666667));
		label5.setLocation(0, (int)(panelLugar.getHeight() * 0.008) + (label5.getHeight() * 4));
		label5.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugar.add(label5);
		
		JLabel label6 = new JLabel("6");
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		label6.setSize(panelLugar.getWidth(), (int)(panelLugar.getHeight() * 0.1666667));
		label6.setLocation(0, (int)(panelLugar.getHeight() * 0.009) + (label6.getHeight() * 5));
		label6.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugar.add(label6);
	}
	
	public void lblEscolas(JPanel panelLugarNome)
	{
		lblEscola1 = new JLabel("lblEscola");
		lblEscola1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblEscola1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEscola1.setSize(panelLugarNome.getWidth(), (int)(panelLugarNome.getHeight() * 0.1666667));
		lblEscola1.setLocation((int)(panelLugarNome.getWidth()*0.08), (int)(panelLugarNome.getHeight() * 0.01));
		int tamanhoFonte = (int)(60 * lblEscola1.getWidth() / 720);
		lblEscola1.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarNome.add(lblEscola1);
		
		lblEscola2 = new JLabel("lblEscola2");
		lblEscola2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblEscola2.setHorizontalAlignment(SwingConstants.LEFT);
		lblEscola2.setSize(panelLugarNome.getWidth(), (int)(panelLugarNome.getHeight() * 0.1666667));
		lblEscola2.setLocation((int)(panelLugarNome.getWidth()*0.08), (int)(panelLugarNome.getHeight() * 0.005) + (lblEscola2.getHeight()));
		lblEscola2.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarNome.add(lblEscola2);
		
		lblEscola3 = new JLabel("lblEscola3");
		lblEscola3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblEscola3.setHorizontalAlignment(SwingConstants.LEFT);
		lblEscola3.setSize(panelLugarNome.getWidth(), (int)(panelLugarNome.getHeight() * 0.1666667));
		lblEscola3.setLocation((int)(panelLugarNome.getWidth()*0.08), (int)(panelLugarNome.getHeight() * 0.006) + (lblEscola3.getHeight()*2));
		lblEscola3.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarNome.add(lblEscola3);
		
		lblEscola4 = new JLabel("lblEscola4");
		lblEscola4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblEscola4.setHorizontalAlignment(SwingConstants.LEFT);
		lblEscola4.setFont(new Font("Arial", Font.BOLD, 60));
		lblEscola4.setSize(panelLugarNome.getWidth(), (int)(panelLugarNome.getHeight() * 0.1666667));
		lblEscola4.setLocation((int)(panelLugarNome.getWidth()*0.08), (int)(panelLugarNome.getHeight() * 0.007) + (lblEscola4.getHeight()*3));
		lblEscola4.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarNome.add(lblEscola4);
		
		lblEscola5 = new JLabel("lblEscola5");
		lblEscola5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblEscola5.setHorizontalAlignment(SwingConstants.LEFT);
		lblEscola5.setFont(new Font("Arial", Font.BOLD, 60));
		lblEscola5.setSize(panelLugarNome.getWidth(), (int)(panelLugarNome.getHeight() * 0.1666667));
		lblEscola5.setLocation((int)(panelLugarNome.getWidth()*0.08), (int)(panelLugarNome.getHeight() * 0.008) + (lblEscola5.getHeight()*4));
		lblEscola5.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarNome.add(lblEscola5);
		
		lblEscola6 = new JLabel("lblEscola6");
		lblEscola6.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		lblEscola6.setHorizontalAlignment(SwingConstants.LEFT);
		lblEscola6.setFont(new Font("Arial", Font.BOLD, 60));
		lblEscola6.setSize(panelLugarNome.getWidth(), (int)(panelLugarNome.getHeight() * 0.1666667));
		lblEscola6.setLocation((int)(panelLugarNome.getWidth()*0.08), (int)(panelLugarNome.getHeight() * 0.009) + (lblEscola6.getHeight()*5));
		lblEscola6.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarNome.add(lblEscola6);
	}

	public void lblRespostasCertas(JPanel panelLugarRespostaCerta)
	{		
		lblRespostaCerta1 = new JLabel("asdasdasdasdasdasd");
		lblRespostaCerta1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblRespostaCerta1.setForeground(Color.GREEN);
		lblRespostaCerta1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespostaCerta1.setSize(panelLugarRespostaCerta.getWidth(), (int)(panelLugarRespostaCerta.getHeight() * 0.1666667));
		lblRespostaCerta1.setLocation((int)(panelLugarRespostaCerta.getWidth()*0.45), (int)(panelLugarRespostaCerta.getHeight() * 0.01));
		int tamanhoFonte = (int)(60 * lblRespostaCerta1.getWidth() / 576);
		lblRespostaCerta1.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarRespostaCerta.add(lblRespostaCerta1);
		
		lblRespostaCerta2 = new JLabel("2");
		lblRespostaCerta2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblRespostaCerta2.setForeground(Color.GREEN);
		lblRespostaCerta2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespostaCerta2.setSize(panelLugarRespostaCerta.getWidth(), (int)(panelLugarRespostaCerta.getHeight() * 0.1666667));
		lblRespostaCerta2.setLocation((int)(panelLugarRespostaCerta.getWidth()*0.45), (int)(panelLugarRespostaCerta.getHeight() * 0.005) + (lblRespostaCerta2.getHeight()));
	
		lblRespostaCerta2.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarRespostaCerta.add(lblRespostaCerta2);
		
		lblRespostaCerta3 = new JLabel("3");
		lblRespostaCerta3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblRespostaCerta3.setForeground(Color.GREEN);
		lblRespostaCerta3.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespostaCerta3.setSize(panelLugarRespostaCerta.getWidth(), (int)(panelLugarRespostaCerta.getHeight() * 0.1666667));
		lblRespostaCerta3.setLocation((int)(panelLugarRespostaCerta.getWidth()*0.45),(int)(panelLugarRespostaCerta.getHeight() * 0.006) + (lblRespostaCerta3.getHeight()*2));
		
		lblRespostaCerta3.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarRespostaCerta.add(lblRespostaCerta3);
		
		lblRespostaCerta4 = new JLabel("4");
		lblRespostaCerta4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblRespostaCerta4.setForeground(Color.GREEN);
		lblRespostaCerta4.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespostaCerta4.setSize(panelLugarRespostaCerta.getWidth(), (int)(panelLugarRespostaCerta.getHeight() * 0.1666667));
		lblRespostaCerta4.setLocation((int)(panelLugarRespostaCerta.getWidth()*0.45), (int)(panelLugarRespostaCerta.getHeight() * 0.007) + (lblRespostaCerta4.getHeight()*3));

		lblRespostaCerta4.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarRespostaCerta.add(lblRespostaCerta4);
		
		lblRespostaCerta5 = new JLabel("5");
		lblRespostaCerta5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblRespostaCerta5.setForeground(Color.GREEN);
		lblRespostaCerta5.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespostaCerta5.setSize(panelLugarRespostaCerta.getWidth(), (int)(panelLugarRespostaCerta.getHeight() * 0.1666667));
		lblRespostaCerta5.setLocation((int)(panelLugarRespostaCerta.getWidth()*0.45), (int)(panelLugarRespostaCerta.getHeight() * 0.008) + (lblRespostaCerta5.getHeight()*4));

		lblRespostaCerta5.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarRespostaCerta.add(lblRespostaCerta5);
		
		lblRespostaCerta6 = new JLabel("6");
		lblRespostaCerta6.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		lblRespostaCerta6.setForeground(Color.GREEN);
		lblRespostaCerta6.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespostaCerta6.setSize(panelLugarRespostaCerta.getWidth(), (int)(panelLugarRespostaCerta.getHeight() * 0.1666667));
		lblRespostaCerta6.setLocation((int)(panelLugarRespostaCerta.getWidth()*0.45), (int)(panelLugarRespostaCerta.getHeight() * 0.009) + (lblRespostaCerta6.getHeight()*5));
		lblRespostaCerta6.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarRespostaCerta.add(lblRespostaCerta6);
	}
	
	public void lblRespostasErradas(JPanel panelLugarRespostaErrada){
		
		lblRespostaErrada1 = new JLabel("1");
		lblRespostaErrada1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblRespostaErrada1.setForeground(Color.RED);
		lblRespostaErrada1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespostaErrada1.setSize(panelLugarRespostaErrada.getWidth(), (int)(panelLugarRespostaErrada.getHeight() * 0.1666667));
		lblRespostaErrada1.setLocation((int)(panelLugarRespostaCerta.getWidth()*0.5), (int)(panelLugarRespostaErrada.getHeight()*0.01));
		int tamanhoFonte = (int)(60 * lblRespostaErrada1.getWidth() / 633);
		lblRespostaErrada1.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarRespostaErrada.add(lblRespostaErrada1);
		
		lblRespostaErrada2 = new JLabel("2");
		lblRespostaErrada2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblRespostaErrada2.setForeground(Color.RED);
		lblRespostaErrada2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespostaErrada2.setSize(panelLugarRespostaErrada.getWidth(), (int)(panelLugarRespostaErrada.getHeight() * 0.1666667));
		lblRespostaErrada2.setLocation((int)(panelLugarRespostaCerta.getWidth()*0.5), (int)(panelLugarRespostaErrada.getHeight()*0.005) + (lblRespostaErrada2.getHeight()));
		lblRespostaErrada2.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarRespostaErrada.add(lblRespostaErrada2);
		
		lblRespostaErrada3 = new JLabel("3");
		lblRespostaErrada3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblRespostaErrada3.setForeground(Color.RED);
		lblRespostaErrada3.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespostaErrada3.setSize(panelLugarRespostaErrada.getWidth(), (int)(panelLugarRespostaErrada.getHeight() * 0.1666667));
		lblRespostaErrada3.setLocation((int)(panelLugarRespostaCerta.getWidth()*0.5), (int)(panelLugarRespostaErrada.getHeight()*0.006) + (lblRespostaErrada3.getHeight()*2));
		
		lblRespostaErrada3.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarRespostaErrada.add(lblRespostaErrada3);

		lblRespostaErrada4 = new JLabel("4");
		lblRespostaErrada4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblRespostaErrada4.setForeground(Color.RED);
		lblRespostaErrada4.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespostaErrada4.setSize(panelLugarRespostaErrada.getWidth(), (int)(panelLugarRespostaErrada.getHeight() * 0.1666667));
		lblRespostaErrada4.setLocation((int)(panelLugarRespostaCerta.getWidth()*0.5), (int)(panelLugarRespostaErrada.getHeight()*0.007) + (lblRespostaErrada4.getHeight()*3));
		
		lblRespostaErrada4.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarRespostaErrada.add(lblRespostaErrada4);

		lblRespostaErrada5 = new JLabel("5");
		lblRespostaErrada5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblRespostaErrada5.setForeground(Color.RED);
		lblRespostaErrada5.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespostaErrada5.setSize(panelLugarRespostaErrada.getWidth(), (int)(panelLugarRespostaErrada.getHeight() * 0.1666667));
		lblRespostaErrada5.setLocation((int)(panelLugarRespostaCerta.getWidth()*0.5), (int)(panelLugarRespostaErrada.getHeight()*0.008) + (lblRespostaErrada5.getHeight()*4));
		
		lblRespostaErrada5.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarRespostaErrada.add(lblRespostaErrada5);

		lblRespostaErrada6 = new JLabel("6");
		lblRespostaErrada6.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		lblRespostaErrada6.setForeground(Color.RED);
		lblRespostaErrada6.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespostaErrada6.setSize(panelLugarRespostaErrada.getWidth(), (int)(panelLugarRespostaErrada.getHeight() * 0.1666667));
		lblRespostaErrada6.setLocation((int)(panelLugarRespostaCerta.getWidth()*0.5), (int)(panelLugarRespostaErrada.getHeight()*0.009) + (lblRespostaErrada6.getHeight()*5));
		
		lblRespostaErrada6.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarRespostaErrada.add(lblRespostaErrada6);
	}

	
	public void lblFaltaResponder(JPanel panelLugarFaltaResponder){
		
		lblFaltaResponder1 = new JLabel("1");
		lblFaltaResponder1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblFaltaResponder1.setForeground(Color.ORANGE);
		lblFaltaResponder1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFaltaResponder1.setSize(panelLugarFaltaResponder.getWidth(), (int)(panelLugarFaltaResponder.getHeight() * 0.1666667));
		lblFaltaResponder1.setLocation((int)(panelLugarFaltaResponder.getWidth()*0.455), (int)(panelLugarFaltaResponder.getHeight()* 0.01));
		int tamanhoFonte = (int)(60 * lblFaltaResponder1.getWidth() / 691);
		lblFaltaResponder1.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarFaltaResponder.add(lblFaltaResponder1);
		
		lblFaltaResponder2 = new JLabel("2");
		lblFaltaResponder2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblFaltaResponder2.setForeground(Color.ORANGE);
		lblFaltaResponder2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFaltaResponder2.setSize(panelLugarFaltaResponder.getWidth(), (int)(panelLugarFaltaResponder.getHeight() * 0.1666667));
		lblFaltaResponder2.setLocation((int)(panelLugarFaltaResponder.getWidth()*0.455), (int)(panelLugarFaltaResponder.getHeight()* 0.005) + (lblFaltaResponder2.getHeight()));
		//lblEscola2.setLocation((int)(panelLugarNome.getWidth()*0.08), (int)(panelLugarNome.getHeight() * 0.005) + (lblEscola2.getHeight()));
		lblFaltaResponder2.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarFaltaResponder.add(lblFaltaResponder2);
		
		lblFaltaResponder3 = new JLabel("3");
		lblFaltaResponder3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblFaltaResponder3.setForeground(Color.ORANGE);
		lblFaltaResponder3.setHorizontalAlignment(SwingConstants.CENTER);
		lblFaltaResponder3.setSize(panelLugarFaltaResponder.getWidth(), (int)(panelLugarFaltaResponder.getHeight() * 0.1666667));
		lblFaltaResponder3.setLocation((int)(panelLugarFaltaResponder.getWidth()*0.455), (int)(panelLugarFaltaResponder.getHeight()* 0.006) + (lblFaltaResponder3.getHeight()*2));
		
		lblFaltaResponder3.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarFaltaResponder.add(lblFaltaResponder3);
		
		lblFaltaResponder4 = new JLabel("4");
		lblFaltaResponder4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblFaltaResponder4.setForeground(Color.ORANGE);
		lblFaltaResponder4.setHorizontalAlignment(SwingConstants.CENTER);
		lblFaltaResponder4.setSize(panelLugarFaltaResponder.getWidth(), (int)(panelLugarFaltaResponder.getHeight() * 0.1666667));
		lblFaltaResponder4.setLocation((int)(panelLugarFaltaResponder.getWidth()*0.455), (int)(panelLugarFaltaResponder.getHeight()* 0.007) + (lblFaltaResponder4.getHeight()*3));
		
		lblFaltaResponder4.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarFaltaResponder.add(lblFaltaResponder4);
		
		lblFaltaResponder5 = new JLabel("5");
		lblFaltaResponder5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblFaltaResponder5.setForeground(Color.ORANGE);
		lblFaltaResponder5.setHorizontalAlignment(SwingConstants.CENTER);
		lblFaltaResponder5.setSize(panelLugarFaltaResponder.getWidth(), (int)(panelLugarFaltaResponder.getHeight() * 0.1666667));
		lblFaltaResponder5.setLocation((int)(panelLugarFaltaResponder.getWidth()*0.455), (int)(panelLugarFaltaResponder.getHeight()* 0.008) + (lblFaltaResponder5.getHeight()*4));
	
		lblFaltaResponder5.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarFaltaResponder.add(lblFaltaResponder5);
		
		lblFaltaResponder6 = new JLabel("6");
		lblFaltaResponder6.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		lblFaltaResponder6.setForeground(Color.ORANGE);
		lblFaltaResponder6.setHorizontalAlignment(SwingConstants.CENTER);
		lblFaltaResponder6.setSize(panelLugarFaltaResponder.getWidth(), (int)(panelLugarFaltaResponder.getHeight() * 0.1666667));
		lblFaltaResponder6.setLocation((int)(panelLugarFaltaResponder.getWidth()*0.455), (int)(panelLugarFaltaResponder.getHeight()* 0.009) + (lblFaltaResponder6.getHeight()*5));
		
		lblFaltaResponder6.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		panelLugarFaltaResponder.add(lblFaltaResponder6);
	}
	
	public void listaRankNome()
	{
		JogadoresController jc = new JogadoresController();
		List<Jogador> jg = new ArrayList<Jogador>();
		jg.addAll(jc.listarlistaOgranizadaRespostaCerta());
		
		lblEscolas(panelLugarNome);
		
		lblEscola1.setText(jg.get(0).getNome().toString());
		lblEscola2.setText(jg.get(1).getNome().toString());
		lblEscola3.setText(jg.get(2).getNome().toString());
		lblEscola4.setText(jg.get(3).getNome().toString());
		lblEscola5.setText(jg.get(4).getNome().toString());
		lblEscola6.setText(jg.get(5).getNome().toString());
	}
	
	public void listaRankResposta(){
		
		pc = new PontuacaoController();
		List<Pontuacao> pont = new ArrayList<Pontuacao>();
		pont.addAll(pc.listaOgranizadaRespostaCerta());
		
		lblRespostasCertas(panelLugarRespostaCerta);
		
		lblRespostaCerta1.setText(String.valueOf(pont.get(0).getRespostaCerta()));
		lblRespostaCerta2.setText(String.valueOf(pont.get(1).getRespostaCerta()));
		lblRespostaCerta3.setText(String.valueOf(pont.get(2).getRespostaCerta()));
		lblRespostaCerta4.setText(String.valueOf(pont.get(3).getRespostaCerta()));
		lblRespostaCerta5.setText(String.valueOf(pont.get(4).getRespostaCerta()));
		lblRespostaCerta6.setText(String.valueOf(pont.get(5).getRespostaCerta()));
		
		lblRespostasErradas(panelLugarRespostaErrada);
		
		lblRespostaErrada1.setText(String.valueOf(pont.get(0).getRespostaErrada()));
		lblRespostaErrada2.setText(String.valueOf(pont.get(1).getRespostaErrada()));
		lblRespostaErrada3.setText(String.valueOf(pont.get(2).getRespostaErrada()));
		lblRespostaErrada4.setText(String.valueOf(pont.get(3).getRespostaErrada()));
		lblRespostaErrada5.setText(String.valueOf(pont.get(4).getRespostaErrada()));
		lblRespostaErrada6.setText(String.valueOf(pont.get(5).getRespostaErrada()));
		
		lblFaltaResponder(panelLugarFaltaResponder);
		
		int um = 6 - (pont.get(0).getRespostaCerta() + pont.get(0).getRespostaErrada());
		int dois = 6 - (pont.get(1).getRespostaCerta() + pont.get(1).getRespostaErrada());
		int tres = 6 - (pont.get(2).getRespostaCerta() + pont.get(2).getRespostaErrada());
		int quatro = 6 - (pont.get(3).getRespostaCerta() + pont.get(3).getRespostaErrada());
		int cinco = 6 - (pont.get(4).getRespostaCerta() + pont.get(4).getRespostaErrada());
		int seis = 6 - (pont.get(5).getRespostaCerta() + pont.get(5).getRespostaErrada());
		
		lblFaltaResponder1.setText(Integer.toString(um));
		lblFaltaResponder2.setText(Integer.toString(dois));
		lblFaltaResponder3.setText(Integer.toString(tres));
		lblFaltaResponder4.setText(Integer.toString(quatro));
		lblFaltaResponder5.setText(Integer.toString(cinco));
		lblFaltaResponder6.setText(Integer.toString(seis));
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