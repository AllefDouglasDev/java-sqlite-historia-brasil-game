package model.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoBanco {
		
	private static Connection con;
	private static boolean conexao;
	
	public static Connection obterConexao()
	{
		Connection con = null;
		
		try {
			
			File diretorio = new File("database");
			
			if(diretorio.exists()){
				File banco = new File("database\\ohfafica.db");
				if(!banco.exists()){
					conexao = false;
				}else{
					conexao = true;
				}
			}else{
				conexao = false;
			}
			
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:database/ohfafica.db";  
		        
			try {
				con = DriverManager.getConnection(url);
				//System.out.println("conexao ok");
			} catch (SQLException erro) {
				conexao = false;
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Não conectou drive");
		}
		return con;
	}
	
	// Mtodos pblicos:
	public boolean getStatusConexao()
	{
		return conexao;
	}
	
	public void criarBanco()
	{
		System.out.println("Criando Diretório");
		boolean success = (new File("database")).mkdir();
		
    	File f = new File("database\\ohfafica.db");
		try {
			f.createNewFile();
			//ConexaoBanco.obterConexao();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null,
				      "Ocorreu um erro de conexão. Verifique a Base de Dados indicada !"+"\n" +  erro.getMessage(),"Conexão",3);
				        erro.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		ConexaoBanco cb = new ConexaoBanco();
		cb.obterConexao();
		//criar();
	}
}
