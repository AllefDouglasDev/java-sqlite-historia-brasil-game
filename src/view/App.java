package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.net.ServerSocket;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controller.JogadoresController;
import model.dao.ConexaoBanco;
import model.dao.TabelaDAO;
import model.dao.TabelasInsertsDAO;

public class App extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JProgressBar progressBar;
	private JLabel lblCarregando;
	private static ServerSocket s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			App dialog = new App();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class Carrega implements Runnable{
		@Override
		public void run() {
			
			try {
			    s = new ServerSocket(9581);
			} catch (Exception e) {
			    JOptionPane.showMessageDialog(null, "Desculpe, mas só uma aplicação pode ser executada por vez.");
			    System.exit(0);
			}
			
			ConexaoBanco cb = new ConexaoBanco();
			TabelaDAO tdao = new TabelaDAO();
			TabelasInsertsDAO tidao = new TabelasInsertsDAO();
			cb.obterConexao();
			int time = 35;
			boolean testarConexao = cb.getStatusConexao();

			boolean jogoJaInstanciado = false;

			boolean necessidadeCriarTabela = false;
			boolean necessidadeInsertAssunto = false;
			boolean necessidadeInsertPergunta = false;
			boolean necessidadeInsertAlternativa = false;
			boolean zerarJogo = true;
			for (int i = 0; i <= 100; i++) {
				if(testarConexao){
					if(i == 1){
						System.out.println("Conexão feita com sucesso");
					}
					if(necessidadeCriarTabela){
						tdao.gerarTabelas(i - 1);
						if(i > 5){
							necessidadeCriarTabela = false;
						}
					} 

					if(necessidadeInsertAssunto && i > 5){
						tdao.insertAssunto(i);
						if(i > 10){
							necessidadeInsertAssunto = false;
						}
					}
					if(necessidadeInsertPergunta && i > 11){
						tdao.insertPergunta(i);
						if(i > 16){
							necessidadeInsertPergunta = false;
						}
					}

					if(necessidadeInsertAlternativa && i > 17){
						tdao.insertAlternativas(i);
						if(i > 52){
							necessidadeInsertAlternativa = false;
							zerarJogo = true;
						}
					}

				}else{
					zerarJogo = false;
					cb.criarBanco();
					necessidadeCriarTabela = true;
					necessidadeInsertAssunto = true;
					necessidadeInsertPergunta = true;
					necessidadeInsertAlternativa = true;
					cb.obterConexao();
					testarConexao = cb.getStatusConexao();
				}

				if(i == 80 && zerarJogo){
					JogadoresController jc = new JogadoresController();
					jc.zerarGame();
				}

				try {
					Thread.sleep(time);
				} catch (Exception e) {
					// TODO: handle exception
				}

				progressBar.setValue(i);
				lblCarregando.setText("Caregando... " + i + "%"); 	
			}
			WAplicacao app = new WAplicacao();
			dispose();
			app.main(null);
		}
	}

	/**
	 * Create the dialog.
	 */
	public App() 
	{
		setBounds(100, 100, 419, 152);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setModal(true);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		design();
		new Thread(new Carrega()).start();
	}

	public void design()
	{
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel.setBackground(SystemColor.window);
		panel.setBounds(0, 0, 419, 152);
		getContentPane().add(panel);
		panel.setLayout(null);

		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(32,37,80));
		progressBar.setBounds(3, 100, 412, 14);
		panel.add(progressBar);

		lblCarregando = new JLabel("Carregando...");
		lblCarregando.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCarregando.setBounds(10, 74, 229, 27);
		panel.add(lblCarregando);

		JLabel lblSlogan = new JLabel();
		lblSlogan.setSize(130, 100);
		lblSlogan.setLocation(local(panel.getWidth(),lblSlogan.getWidth(), 50), 3);
		ImageIcon imagem = new ImageIcon("img\\fafica_logo_200x225.png");

		lblSlogan.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(lblSlogan.getWidth(), lblSlogan.getHeight(), Image.SCALE_DEFAULT)));

		panel.add(lblSlogan);
	}

	public int local(float tamPanel, float tamContainer, float por){
		por = por / 100;
		float local = (tamPanel - tamContainer) * por;
		return (int)local;
	}
}
