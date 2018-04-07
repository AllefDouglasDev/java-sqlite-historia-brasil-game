package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controller.JogadoresController;
import util.PropriedadesTela;

public class WAssuntos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static int id;
	private static String nome;
	private int tamanhoFonte;
	private PropriedadesTela pt;
	private JButton btnHisDoBrasil;
	private JButton btnHisContemporania;
	private JButton btnHisModerna;
	private JButton btnHisMedieval;
	private JButton btnHisAntiga;
	private JButton btnPreHistoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WAssuntos dialog = new WAssuntos(id, nome);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WAssuntos(int id, String nome) {
		this.nome = nome;
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\LogoFAFICA.jpg"));
		setId(id);
		pt = new PropriedadesTela(returnIn());
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setResizable(false);
		setUndecorated(true);

		design();
	}

	public void design()
	{
		tamanhoTela();

		btnVoltar();

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

		panelLinha(panelCenter);

		btnPreHistoria(panelCenter);
		btnHisAntiga(panelCenter);
		btnHisMedieval(panelCenter);
		btnHisModerna(panelCenter);
		btnHisContemporania(panelCenter);
		btnHisDoBrasil(panelCenter);

		assuntoDisponivel();

		lblPreHistoria(panelCenter);
		lblHisAntiga(panelCenter);
		lblHisMedieval(panelCenter);
		lblHisModerna(panelCenter);
		lblHisContemporania(panelCenter);
		lblHisDoBrasil(panelCenter);

		lblSlogan(panelCenter);
		lblTitulo(panelCenter);
	}

	public void panelLinha(JPanel panelCenter)
	{
		JPanel panelLinha = new JPanel();
		panelLinha.setBackground(new Color(0,0,0));
		panelLinha.setSize((int)(panelCenter.getWidth() * 0.95), 2);
		panelLinha.setLocation(local(panelCenter.getWidth(), panelLinha.getWidth(), 50), (int)(panelCenter.getHeight() * 0.37)); 
		panelCenter.add(panelLinha);

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

	public void btnPreHistoria(JPanel panelCenter)
	{
		btnPreHistoria = new JButton();
		//btnPreHistoria.setBackground(new Color(32,37,80));
		btnPreHistoria.setSize((int)(panelCenter.getWidth()* 0.12), (int)(panelCenter.getWidth()* 0.12));
		btnPreHistoria.setLocation((int)(panelCenter.getWidth() * 0.04), (int)(panelCenter.getHeight() * 0.01));
		panelCenter.add(btnPreHistoria);

		ImageIcon imagem = new ImageIcon("img\\pre_historia_assunto.png");
		btnPreHistoria.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(btnPreHistoria.getWidth(), btnPreHistoria.getHeight(), Image.SCALE_DEFAULT)));

		btnPreHistoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JogadoresController jc = new JogadoresController();
				jc.alterarAssuntoDisponivel(getId(), 1);
				dispose();
				WPergunta wp = new WPergunta(getId(), 1, nome);
				wp.setVisible(true);
			}
		});
	}

	public void btnHisAntiga(JPanel panelCenter)
	{
		btnHisAntiga = new JButton();
		//btnHisAntiga.setBackground(new Color(32,37,80));
		btnHisAntiga.setSize((int)(panelCenter.getWidth()* 0.12), (int)(panelCenter.getWidth()* 0.12));
		btnHisAntiga.setLocation((int)(panelCenter.getWidth() * 0.08 + btnHisAntiga.getWidth()), (int)(panelCenter.getHeight() * 0.01));
		panelCenter.add(btnHisAntiga);
		//assuntoDisponivel(btnHisAntiga, 2);
		
		ImageIcon imagem = new ImageIcon("img\\piramides.png");
		btnHisAntiga.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(btnHisAntiga.getWidth(), btnHisAntiga.getHeight(), Image.SCALE_DEFAULT)));

		btnHisAntiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JogadoresController jc = new JogadoresController();
				jc.alterarAssuntoDisponivel(getId(), 2);
				dispose();
				WPergunta wp = new WPergunta(getId(), 2, nome);
				wp.setVisible(true);
			}
		});
	}

	public void btnHisMedieval(JPanel panelCenter)
	{
		btnHisMedieval = new JButton();
		//btnHisMedieval.setBackground(new Color(32,37,80));;
		btnHisMedieval.setSize((int)(panelCenter.getWidth()* 0.12), (int)(panelCenter.getWidth()* 0.12));
		btnHisMedieval.setLocation((int)(panelCenter.getWidth() * 0.12 + (btnHisMedieval.getWidth() * 2)), (int)(panelCenter.getHeight() * 0.01));
		panelCenter.add(btnHisMedieval);
		//assuntoDisponivel(btnHisMedieval, 3);
		
		ImageIcon imagem = new ImageIcon("img\\castelo.jpg");
		btnHisMedieval.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(btnHisMedieval.getWidth(), btnHisMedieval.getHeight(), Image.SCALE_DEFAULT)));

		btnHisMedieval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JogadoresController jc = new JogadoresController();
				jc.alterarAssuntoDisponivel(getId(), 3);
				dispose();
				WPergunta wp = new WPergunta(getId(), 3, nome);
				wp.setVisible(true);
			}
		});
	}

	public void btnHisModerna(JPanel panelCenter)
	{
		btnHisModerna = new JButton();
		//btnHisModerna.setBackground(new Color(32,37,80));
		btnHisModerna.setSize((int)(panelCenter.getWidth()* 0.12), (int)(panelCenter.getWidth()* 0.12));
		btnHisModerna.setLocation((int)(panelCenter.getWidth() * 0.16 + (btnHisModerna.getWidth() * 3)), (int)(panelCenter.getHeight() * 0.01));
		panelCenter.add(btnHisModerna);
		//assuntoDisponivel(btnHisModerna, 4);

		ImageIcon imagem = new ImageIcon("img\\revolucao.jpg");
		btnHisModerna.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(btnHisModerna.getWidth(), btnHisModerna.getHeight(), Image.SCALE_DEFAULT)));

		
		btnHisModerna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JogadoresController jc = new JogadoresController();
				jc.alterarAssuntoDisponivel(getId(), 4);
				dispose();
				WPergunta wp = new WPergunta(getId(), 4, nome);
				wp.setVisible(true);
			}
		});
	}

	public void btnHisContemporania(JPanel panelCenter)
	{
		btnHisContemporania = new JButton();
		//btnHisContemporania.setBackground(new Color(32,37,80));
		btnHisContemporania.setSize((int)(panelCenter.getWidth()* 0.12), (int)(panelCenter.getWidth()* 0.12));
		btnHisContemporania.setLocation((int)(panelCenter.getWidth() * 0.20 + (btnHisContemporania.getWidth() * 4)), (int)(panelCenter.getHeight() * 0.01));
		panelCenter.add(btnHisContemporania);
		//assuntoDisponivel(btnHisContemporania, 5);

		ImageIcon imagem = new ImageIcon("img\\che.png");
		btnHisContemporania.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(btnHisContemporania.getWidth(), btnHisContemporania.getHeight(), Image.SCALE_DEFAULT)));

		
		btnHisContemporania.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JogadoresController jc = new JogadoresController();
				jc.alterarAssuntoDisponivel(getId(), 5);
				dispose();
				WPergunta wp = new WPergunta(getId(), 5, nome);
				wp.setVisible(true);
			}
		});
	}

	public void btnHisDoBrasil(JPanel panelCenter)
	{
		btnHisDoBrasil = new JButton();
		//btnHisDoBrasil.setBackground(new Color(32,37,80));
		btnHisDoBrasil.setSize((int)(panelCenter.getWidth()* 0.12), (int)(panelCenter.getWidth()* 0.12));
		btnHisDoBrasil.setLocation((int)(panelCenter.getWidth() * 0.24 + (btnHisDoBrasil.getWidth() * 5)), (int)(panelCenter.getHeight() * 0.01));
		panelCenter.add(btnHisDoBrasil);
		//assuntoDisponivel(btnHisDoBrasil, 6);

		ImageIcon imagem = new ImageIcon("img\\lamp.jpg");
		btnHisDoBrasil.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(btnHisDoBrasil.getWidth(), btnHisDoBrasil.getHeight(), Image.SCALE_DEFAULT)));

		
		btnHisDoBrasil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JogadoresController jc = new JogadoresController();
				jc.alterarAssuntoDisponivel(getId(), 6);
				dispose();
				WPergunta wp = new WPergunta(getId(), 6, nome);
				wp.setVisible(true);
			}
		});
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
	
	public void lblPreHistoria(JPanel panelCenter)
	{
		JLabel lblPreHistoria = new JLabel("Pré-História");
		lblPreHistoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreHistoria.setSize((int)(panelCenter.getWidth()* 0.14), (int)(panelCenter.getHeight()* 0.07));
		lblPreHistoria.setLocation((int)(panelCenter.getWidth() * 0.03), (int)(panelCenter.getHeight() * 0.02) + (int)(panelCenter.getWidth() * 0.12));

		tamanhoFonte = (int)(13 * lblPreHistoria.getWidth() / 133);

		lblPreHistoria.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));

		panelCenter.add(lblPreHistoria);

	}

	public void lblHisAntiga(JPanel panelCenter)
	{
		JLabel lblHisAntiga = new JLabel("História Antiga");
		lblHisAntiga.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		lblHisAntiga.setHorizontalAlignment(SwingConstants.CENTER);
		lblHisAntiga.setSize((int)(panelCenter.getWidth()* 0.14), (int)(panelCenter.getHeight()* 0.07));
		lblHisAntiga.setLocation((int)(panelCenter.getWidth() * 0.05 + lblHisAntiga.getWidth()), (int)(panelCenter.getHeight() * 0.02) + (int)(panelCenter.getWidth() * 0.12));

		panelCenter.add(lblHisAntiga);	
	}

	public void lblHisMedieval(JPanel panelCenter)
	{
		JLabel lblHisMedieval = new JLabel("História Medieval");
		lblHisMedieval.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		lblHisMedieval.setHorizontalAlignment(SwingConstants.CENTER);
		lblHisMedieval.setSize((int)(panelCenter.getWidth()* 0.14), (int)(panelCenter.getHeight()* 0.07));
		lblHisMedieval.setLocation((int)(panelCenter.getWidth() * 0.07 + (lblHisMedieval.getWidth() * 2)), (int)(panelCenter.getHeight() * 0.02) + (int)(panelCenter.getWidth() * 0.12));

		panelCenter.add(lblHisMedieval);	
	}

	public void lblHisModerna(JPanel panelCenter)
	{
		JLabel lblHisModerna = new JLabel("História Moderna");
		lblHisModerna.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		lblHisModerna.setHorizontalAlignment(SwingConstants.CENTER);
		lblHisModerna.setSize((int)(panelCenter.getWidth()* 0.14), (int)(panelCenter.getHeight()* 0.07));
		lblHisModerna.setLocation((int)(panelCenter.getWidth() * 0.09 + (lblHisModerna.getWidth() * 3)), (int)(panelCenter.getHeight() * 0.02) + (int)(panelCenter.getWidth() * 0.12));

		panelCenter.add(lblHisModerna);	

	}

	public void lblHisContemporania(JPanel panelCenter)
	{
		JLabel lblHisContemporania = new JLabel("His. Contemporânia");
		lblHisContemporania.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		lblHisContemporania.setHorizontalAlignment(SwingConstants.CENTER);
		lblHisContemporania.setSize((int)(panelCenter.getWidth()* 0.14), (int)(panelCenter.getHeight()* 0.07));
		lblHisContemporania.setLocation((int)(panelCenter.getWidth() * 0.11 + (lblHisContemporania.getWidth() * 4)), (int)(panelCenter.getHeight() * 0.02) + (int)(panelCenter.getWidth() * 0.12));

		panelCenter.add(lblHisContemporania);

	}

	public void lblHisDoBrasil(JPanel panelCenter)
	{
		JLabel lblHisDoBrasil = new JLabel("História do Brasil");
		lblHisDoBrasil.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
		lblHisDoBrasil.setHorizontalAlignment(SwingConstants.CENTER);
		lblHisDoBrasil.setSize((int)(panelCenter.getWidth()* 0.14), (int)(panelCenter.getHeight()* 0.07));
		lblHisDoBrasil.setLocation((int)(panelCenter.getWidth() * 0.13 + (lblHisDoBrasil.getWidth() * 5)), (int)(panelCenter.getHeight() * 0.02) + (int)(panelCenter.getWidth() * 0.12));

		panelCenter.add(lblHisDoBrasil);

	}

	public void btnVoltar()
	{
		JButton btnVoltar = new JButton();
		btnVoltar.setBounds(331, 142, 169, 55);
		btnVoltar.setSize((int)(getHeight()* 0.05), (int)(getHeight()* 0.05));
		btnVoltar.setLocation((int)(getHeight() * 0.01), (int)(getHeight() * 0.01));

		ImageIcon imagem = new ImageIcon("img\\Entypo_2b05(0)_32.png");
		btnVoltar.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(btnVoltar.getWidth(), btnVoltar.getHeight(), Image.SCALE_DEFAULT)));

		contentPanel.add(btnVoltar);

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}

	public void lblSlogan(JPanel panelCenter)
	{
		JLabel lblSlogan = new JLabel("");
		lblSlogan.setSize(200, 114);
		lblSlogan.setLocation(local(panelCenter.getWidth(), lblSlogan.getWidth(), 50), (int)(panelCenter.getHeight() * 0.45) );
		panelCenter.add(lblSlogan);

		ImageIcon imagem = new ImageIcon("img\\fafica_logo_200x225.png");

		lblSlogan.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(lblSlogan.getWidth(), lblSlogan.getHeight(), Image.SCALE_DEFAULT)));;
	}

	public void lblTitulo(JPanel panelCenter)
	{
		JLabel lblOlimpadaDeHistria = new JLabel("Olimp\u00EDada de Hist\u00F3ria");
		lblOlimpadaDeHistria.setFont(new Font("Arial", Font.BOLD, 50));
		lblOlimpadaDeHistria.setHorizontalAlignment(SwingConstants.CENTER);
		lblOlimpadaDeHistria.setSize((int)(panelCenter.getWidth() * 0.7), (int)(panelCenter.getHeight() * 0.40));
		lblOlimpadaDeHistria.setLocation(local(panelCenter.getWidth(), lblOlimpadaDeHistria.getWidth(), 50), (int)(panelCenter.getHeight() * 0.55));
		panelCenter.add(lblOlimpadaDeHistria);

		JLabel lblFafica = new JLabel("FAFICA");
		lblFafica.setHorizontalAlignment(SwingConstants.CENTER);
		lblFafica.setFont(new Font("Arial", Font.BOLD, 50));
		lblFafica.setSize((int)(panelCenter.getWidth() * 0.7), (int)(panelCenter.getHeight() * 0.40));
		lblFafica.setLocation(local(panelCenter.getWidth(), lblFafica.getWidth(), 50), (int)(panelCenter.getHeight() * 0.65));
		panelCenter.add(lblFafica);
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

	public void assuntoDisponivel()
	{
		JogadoresController jc = new JogadoresController();
		int[] assuntoDisp = jc.assuntoDisponivel(getId());
		int contador = 0;

		for (int i = 0; i < assuntoDisp.length; i++) {
			if(assuntoDisp[i] > 0){
				if(assuntoDisp[i] == 1){
					btnPreHistoria.setEnabled(false);
				}else if(assuntoDisp[i] == 2){
					btnHisAntiga.setEnabled(false);
				}else if(assuntoDisp[i] == 3){
					btnHisMedieval.setEnabled(false);
				}else if(assuntoDisp[i] == 4){
					btnHisModerna.setEnabled(false);
				}else if(assuntoDisp[i] == 5){
					btnHisContemporania.setEnabled(false);
				}else if(assuntoDisp[i] == 6){
					btnHisDoBrasil.setEnabled(false);
				}
			}else{
				break;
			}
		}
	}


	public void setId(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return this.id;
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
