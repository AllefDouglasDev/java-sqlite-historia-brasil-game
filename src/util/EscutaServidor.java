package util;

import javax.swing.JOptionPane;

import controller.PerguntaController;
import controller.PontuacaoController;
import view.WPergunta;

public class EscutaServidor implements Runnable{

		private WPergunta pergunta;
		private boolean estaSuspensa;
		private boolean foiTerminada;
		
		public EscutaServidor(WPergunta pergunta)
		{
			this.estaSuspensa = false;
			this.pergunta = pergunta;
			new Thread(this).start();
		}
		
		@Override
		public void run() {

			int contador = 0;
			int min = 1;
			int seg = 59;
			int mil = 0;
			boolean t = true;

			while(t){
				try{
					if(pergunta.getIniciarTh() == 1){
						if(seg >=10){
							pergunta.setLblTempo(min + ":" + seg);
						}else{
							if(seg != -1){
								pergunta.setLblTempo(min + ":0" + seg);	
							}
						}

						if(contador == 0 && seg == -1){
							min = 0;
							seg = 59;
							contador++;
						}
						
						if(pergunta.getNotificacao() || seg == -1){
							if(seg == -1){
								PontuacaoController pc = new PontuacaoController();
								pergunta.respostaCorreta(0);
								pc.atualizarPontuacao(pergunta.getIdEscola(), 2);
								JOptionPane.showMessageDialog(null, "Tempo finalizado!");
								pergunta.dispose();
							}
							stop();
						}
						
						if(mil == 750){
							seg--;
							mil = 0;
						}
						if(seg == 10 && min == 0){
							pergunta.setColorLblTempo();
						}
						
						mil++;
						if(mil < 10){
							pergunta.setLblTempoMil("00"+Integer.toString(mil));
						}else if( mil >= 10 && mil <= 99){
							pergunta.setLblTempoMil("0"+Integer.toString(mil));
						}else{
							pergunta.setLblTempoMil(Integer.toString(mil));
						}
						
						Thread.sleep(1);
					}

					synchronized (this) {
						while(estaSuspensa){
								wait();
						}
						if(this.foiTerminada){
							break;
						}
					}
					
					
				} catch(Exception e) {}
			}		
			
			System.out.println("Thread terminada");
		}
		
		public void suspend()
		{
			this.estaSuspensa = true;
		}
		
		public synchronized void resume(){
			estaSuspensa = false;
			notify();
		}
		
		public synchronized void stop(){
			this.foiTerminada = true;
			notify();
		}

	}