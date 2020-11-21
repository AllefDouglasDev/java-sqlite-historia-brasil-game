package view;

import java.awt.EventQueue;
import java.net.ServerSocket;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import controller.JogadoresController;
import model.dao.DatabaseConnection;
import model.dao.Migration;
import model.dao.Repository;

/**
 * Launch the application.
 */
public class App {
	
	public static void main(String[] args) {
		try {
			checkInstance();
			checkDatabaseConnection();
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						WAplicacao application = new WAplicacao();
						
						application.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						application.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao inicializar o jogo");
			e.printStackTrace();
		}
	}
	
	private static void checkDatabaseConnection() {
		DatabaseConnection.getConnection();
		
		if (!DatabaseConnection.isConnected) {					
			JOptionPane.showMessageDialog(null, "Erro ao se conectar ao banco de dados.");
			System.exit(0);
		}
		
		/** Migration */
		Migration migration = new Migration();
		migration.migrate();
		
		/** If has no data, make seed */
		Repository repository = new Repository();
		
		if (repository.getSubjects().size() == 0) {
			System.out.println("Inserting data");
			migration.seed();
		}
		
		new JogadoresController().zerarGame();
	}
	
	@SuppressWarnings("resource")
	private static void checkInstance() {
		try {
		    new ServerSocket(9581);
		} catch (Exception e) {
		    JOptionPane.showMessageDialog(null, "Ja existe uma aplicacao rodando.");
		    System.exit(0);
		}
		
	}
}
