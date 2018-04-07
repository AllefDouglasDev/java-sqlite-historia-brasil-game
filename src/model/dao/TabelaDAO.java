package model.dao;

public class TabelaDAO {
	public void gerarTabelas(int controle)
	{
		TabelasInsertsDAO t = new TabelasInsertsDAO();
		if(controle == 0){
			t.criarTabela("CREATE TABLE `escola` ("+"`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+"`nome` varchar(50) NOT NULL UNIQUE"+");"); // Escola
			//System.out.println("Tabela "+ (controle + 1) +" criada com sucesso!");
		}else if(controle == 1){
			t.criarTabela("CREATE TABLE `assunto`(`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,`nome` varchar(40) NOT NULL);"); // Assunto
			//System.out.println("Tabela "+ (controle + 1) +" criada com sucesso!");
		}else if(controle == 2){
			t.criarTabela("CREATE TABLE `pergunta` (  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `pergunta` VARVHAR(200) NOT NULL,  `respondida` varchar(10) NOT NULL, `id_assunto` INTEGER NOT NULL, FOREIGN KEY (`id_assunto`) REFERENCES assunto (`id`));");
			//System.out.println("Tabela "+ (controle + 1) +" criada com sucesso!");
		}else if(controle == 3){
			t.criarTabela("CREATE TABLE `alternativa` ( `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,  `id_pergunta` INTEGER NOT NULL,  `resposta` varchar(200) NOT NULL,  `correta` varchar(10) NOT NULL,  FOREIGN KEY (`id_pergunta`) REFERENCES pergunta (`id`));");
			//System.out.println("Tabela "+ (controle + 1) +" criada com sucesso!");
		}else if(controle == 4){
			t.criarTabela("CREATE TABLE `pontuacao` (  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,  `id_escola` INTEGER DEFAULT NULL,  `resposta_certa` INTEGER DEFAULT NULL,  `resposta_errada` INTEGER DEFAULT NULL,  FOREIGN KEY (`id_escola`) REFERENCES escola (`id`));");
			//System.out.println("Tabela "+ (controle + 1) +" criada com sucesso!");
		}else{
			t.criarTabela("CREATE TABLE `escola_escolhe_assunto` (  `id_escola` INTEGER NOT NULL,  `id_assunto` INTEGER NOT NULL,  PRIMARY KEY (`id_escola`,`id_assunto`),  FOREIGN KEY (`id_assunto`) REFERENCES assunto (`id`),  FOREIGN KEY (`id_escola`) REFERENCES escola (`id`));");
			//t.criarTabela("CREATE TABLE `servidor_tempo` (  `id_escola` INTEGER NOT NULL,  `id_assunto` INTEGER NOT NULL,  PRIMARY KEY ()");
			//System.out.println("Tabela "+ (controle + 1) +" criada com sucesso!");
		}		
	}
	
	public void insertAssunto(int controle)
	{
		TabelasInsertsDAO t = new TabelasInsertsDAO();
		if(controle == 6){
			t.inserirAssunto("Pr�-Hist�ria");
			//System.out.println("Pr�-Hist�ria");
		}else if(controle == 7){
			t.inserirAssunto("Hist�ria Antiga");
			//System.out.println("Hist�ria Antiga");
		}else if(controle == 8){
			t.inserirAssunto("Hist�ria Medieval");
			//System.out.println("Hist�ria Medieval");
		}else if(controle == 9){
			t.inserirAssunto("Hist�ria Moderna");
			//System.out.println("Hist�ria Moderna");
		}else if(controle == 10){
			t.inserirAssunto("Hist�ria Contempor�nia");
			//System.out.println("Hist�ria Contempor�nia");
		}else{
			t.inserirAssunto("Hist�ria do Brasil");
			//System.out.println("Hist�ria do Brasil");
		}
	}
	
	public void insertPergunta(int controle)
	{
		TabelasInsertsDAO t = new TabelasInsertsDAO();
		if(controle == 12){
			t.inserirPergunta("O per�odo conhecido como Idade dos Metais, caracterizou-se por:", "n", 1);
			t.inserirPergunta("No per�odo neol�tico:", "n", 1);
			t.inserirPergunta("Durante o paleol�tico, ficou conhecida a arte rupestre que era:", "n", 1);
			t.inserirPergunta("Qual o nome para o per�odo onde o fogo foi dominado? ", "n", 1);
			t.inserirPergunta("S�o caracter�sticas do per�odo conhecido como Neol�tico:", "n", 1);
			t.inserirPergunta("Durante a chama �Idade da Pedra Lascada� surge como alternativa comunicativa a arte rupestre. O que era a arte rupestre?", "n", 1);
		
			//System.out.println("Completo 1");
		}else if(controle == 13){
			t.inserirPergunta("Ap�s as grandes expans�es territoriais, qual atividade tornou-se a base da economia no Antigo Imp�rio Romano?", "n", 2);
			t.inserirPergunta("Na Gr�cia antiga:", "n", 2);
			t.inserirPergunta("Para que serviam as pir�mides no Egito antigo?", "n", 2);
			t.inserirPergunta("A lei de Tali�o �Olho por olho, dente por dente� � o mais antigo dos c�digos usados na antiguidade, criado pelo governante:", "n", 2);
			t.inserirPergunta("com base em seus conhecimentos sobre hist�ria antiga, onde surgiu as primeiras formas de escrita cuneiforme? ", "n", 2);
			t.inserirPergunta("O Edito de Mil�o, assinado em 313 d.C. por Constantino, mudou a rela��o entre igreja crist� e o estado romano, por qu�?", "n", 2);

			//System.out.println("Completo 2");
		}else if(controle == 14){
			t.inserirPergunta("Oficialmente, quantas  �Guerras Santas� foram contabilizadas pelos historiadores medievais?", "n", 3);
			t.inserirPergunta("Sobre a peste negra:", "n", 3);
			t.inserirPergunta("Qual foi o principal objetivo das cruzadas?", "n", 3);
			t.inserirPergunta("Quais povos germ�nicos invadiram o Imp�rio Romano a partir do s�culo III d.C.", "n", 3);
			t.inserirPergunta("Podemos destacar dentro do modo de produ��o feudal os seguintes aspectos:", "n", 3);
			t.inserirPergunta("As corpora��es de Of�cio, no contexto medieval, t�m como seu objetivo principal:", "n", 3);
			
			//System.out.println("Completo 3");
		}else if(controle == 15){
			t.inserirPergunta("Entre os fil�sofos que basearam a teoria iluminista, est�o:", "n", 4);
			t.inserirPergunta("A reforma religiosa inglesa teve como consequ�ncia:", "n", 4);
			t.inserirPergunta("Na Guerra de Independ�ncia, os EUA tiveram o apoio dos seguintes pa�ses:", "n", 4);
			t.inserirPergunta("Qual foi o lema que ficou bastante conhecido durante a revolu��o francesa, por resumir todos os desejos da Fran�a em uma s� frase?", "n", 4);
			t.inserirPergunta("Quais caracter�sticas abaixo, podem ser atribu�das a pol�tica econ�mica mercantilista", "n", 4);
			t.inserirPergunta("Quais caracter�sticas podemos apontar sobre a arte renascentista:", "n", 4);
			
			//System.out.println("Completo 4");
		}else if(controle == 16){
			t.inserirPergunta("O Programa de A��o Imediata (PAI), uma das fases do Plano Real, elaborado em 1993 para atender as �necessidades� econ�micas da �poca, n�o tinha como medida:", "n", 5);
			t.inserirPergunta("A Revolu��o russa:", "n", 5);
			t.inserirPergunta("O �ludismo� que ocorreu durante a Revolu��o Industrial:", "n", 5);
			t.inserirPergunta("O dia 11 de setembro de 2001, ficou marcado pelo ataque as Torres G�meas em Nova Iorque. Qual o grupo terrorista que comandou o ataque?", "n", 5);
			t.inserirPergunta("No quadro �Guernica�, Picasso, registrou a trag�dia e a destrui��o", "n", 5);
			t.inserirPergunta("O acidente nuclear de Chernobyl fora consequ�ncia:", "n", 5);
			
			//System.out.println("Completo 5");
		}else{
			t.inserirPergunta("O principal l�der do partido liberal no per�odo regencial brasileiro foi:", "n", 6);
			t.inserirPergunta("A cabanagem, influenciada pela Revolu��o Francesa, teve a presen�a dos atuais estados:", "n", 6);
			t.inserirPergunta("Entre os s�culos XVI e XVII, dois pa�ses tentaram invadir o Brasil e fincar ra�zes para tir�-lo de Portugal. Quais foram esses pa�ses?", "n", 6);
			t.inserirPergunta("Na primeira constitui��o Brasileira em 1824, existiam quatro poderes. Al�m dos poderes Executivo, Legislativo e Judici�rio, havia:", "n", 6);
			t.inserirPergunta("Sobre o Segundo Reinado, � incorreto afirmar que", "n", 6);
			t.inserirPergunta("Get�lio Vargas durante seu governo instruiu o estado novo, que terminou em 1945 por:", "n", 6);
			
			//System.out.println("Completo 6");
		}
	}
	
	public void insertAlternativas(int controle)
	{
		TabelasInsertsDAO t = new TabelasInsertsDAO();
		if(controle == 18){
			t.inserirResposta(1, "A) Desenvolvimento de m�quinas industriais durante a Revolu��o Industrial", "n");
			t.inserirResposta(1, "B) Desenvolvimento de t�cnicas de fundir e moldar artigos como o cobre e o estanho", "s");
			t.inserirResposta(1, "C) Cria��o de artigos como o ferro, o cobre e o estanho, assim como a descoberta do fogo", "n");
			t.inserirResposta(1, "D) Desenvolvimento de moldagem de moedas, o que deu inicio aos primeiros sistemas econ�micos", "n");
			t.inserirResposta(1, "E) Desenvolvimento do ferro e sua utiliza��o na arte pr�-hist�rica", "n");
		}else if(controle == 19){
			t.inserirResposta(2, "A) O homem pr�-hist�rico utilizava a pedra polida", "s");
			t.inserirResposta(2, "B) O homem pr�-hist�rico n�o tinha controle sobre o fogo", "n");
			t.inserirResposta(2, "C) Os seres humanos eram n�mades", "n");
			t.inserirResposta(2, "D) Os seres humanos ainda n�o dominavam t�cnicas agr�colas", "n");
			t.inserirResposta(2, "E) O homem pr�-hist�rico utilizava a pedra lascada", "n");
		}else if(controle == 20){
			t.inserirResposta(3, "A) Arte feita no corpo humano utilizando tinturas naturais", "n");
			t.inserirResposta(3, "B) Arte criada pelos gregos, onde se esculpiam est�tuas de deuses", "n");
			t.inserirResposta(3, "C) Arte feita na parede de cavernas ou em pedras", "s");
			t.inserirResposta(3, "D) Arte feita pelos escravos durante o per�odo colonial no Brasil", "n");
			t.inserirResposta(3, "E) Arte feita pelos povos chin�s durante a dinastia Han", "n");
		}else if(controle == 21){
			t.inserirResposta(4, "A) Neol�tico", "n");
			t.inserirResposta(4, "B) Paleol�tico", "s");
			t.inserirResposta(4, "C) Mesol�tico", "n");
			t.inserirResposta(4, "D) Paleol�tico", "n");
			t.inserirResposta(4, "E) Idade da pedra polida", "n");
		}else if(controle == 22){
			t.inserirResposta(5, "A) A habita��o em cavernas, a ca�a rudimentar e a escrita", "n");
			t.inserirResposta(5, "B) A forma��o de corpos sociais coletivos com a finalidade de preserva��o da esp�cie", "n");
			t.inserirResposta(5, "C) O in�cio do processo de sedentariza��o com a pr�tica da agricultura e a domestica��o de animais", "s");
			t.inserirResposta(5, "D) Os seres humanos n�o dominavam a escrita ou se quer dispunham de qualquer recurso para se comunicarem", "n");
			t.inserirResposta(5, "E) O uso intensivo de utens�lios provenientes de metais", "n");
		}else if(controle == 23){
			t.inserirResposta(6, "A) Tipo de arte feita na Pr�-hist�ria com caracter�sticas de culto �s divindades da natureza", "n");
			t.inserirResposta(6, "B) Pinturas corporais utilizadas como s�mbolo de bom aug�rio entre os ca�adores", "n");
			t.inserirResposta(6, "C) Estilo art�stico desenvolvido na Pr�-Hist�ria utilizado como forma de comunica��o n�made", "n");
			t.inserirResposta(6, "D) Arte dos �rupus�. Grupos isolados respons�veis por grandes monumentos ostensivos aos povos rivais", "n");
			t.inserirResposta(6, "E) A arte rupestre era composta por representa��es gr�ficas (desenhos, s�mbolos, sinais) feitas em paredes de cavernas ou pedras pelos homens do per�odo Paleol�tico", "s");
		}else if(controle == 24){
			t.inserirResposta(7, "A) Agricultura", "n");
			t.inserirResposta(7, "B) Com�rcio", "n");
			t.inserirResposta(7, "C) M�o de obra escrava", "s");
			t.inserirResposta(7, "D) Sistema de Vassalagem", "n");
			t.inserirResposta(7, "E) Manufatura", "n");
		}else if(controle == 25){
			t.inserirResposta(8, "A) O Estado surge na �poca cl�ssica", "n");
			t.inserirResposta(8, "B) As primeiras P�lis teriam surgido na Gr�cia asi�tica pelos J�nios e os e�lios", "s");
			t.inserirResposta(8, "C) O surgimento da escravid�o impossibilitou a divis�o do trabalho em agricultura e artesanato", "n");
			t.inserirResposta(8, "D) Os artigos de artesanato eram, na sua maior parte, importados das col�nias espalhadas pelo mediterr�neo", "n");
			t.inserirResposta(8, "E) A cidade-estado de Esparta foi fundada sobre territ�rio conquistado pelos J�nios", "n");
		}else if(controle == 26){
			t.inserirResposta(9, "A) Serviam basicamente como o principal local de com�rcio", "n");
			t.inserirResposta(9, "B) Serviam de templo religioso", "n");
			t.inserirResposta(9, "C) Serviam para proteger e conservar o corpo do fara� mumificado", "s");
			t.inserirResposta(9, "D) Serviam como pal�cio para os fara�s", "n");
			t.inserirResposta(9, "E) Serviam como monumento ao deus Amon", "n");
		}else if(controle == 27){
			t.inserirResposta(10, "A) Sarg�o I", "n");
			t.inserirResposta(10, "B) Ramses", "n");
			t.inserirResposta(10, "C) Torah", "n");
			t.inserirResposta(10, "D) Hamurabi", "s");
			t.inserirResposta(10, "E) Nabucodonosor", "n");
		}else if(controle == 28){
			t.inserirResposta(11, "A) Mesopot�mia", "s");
			t.inserirResposta(11, "B) Fen�cia", "n");
			t.inserirResposta(11, "C) P�rsia", "n");
			t.inserirResposta(11, "D) Palestina", "n");
			t.inserirResposta(11, "E) Egito", "n");
		}else if(controle == 29){
			t.inserirResposta(12, "A) Proibiu a religi�o crist� no Imp�rio","n");
			t.inserirResposta(12, "B) Assegurou a liberdade de culto aos crist�os", "s");
			t.inserirResposta(12, "C) Tornou o cristianismo a religi�o oficial do Imp�rio", "n");
			t.inserirResposta(12, "D) Submeteu os crist�os ao culto oficial do Imperador", "n");
			t.inserirResposta(12, "E) Contribuiu para a aceita��o do polite�smo pelos crist�os", "n");
		}else if(controle == 30){
			t.inserirResposta(13, "A) Tr�s", "n");
			t.inserirResposta(13, "B) Seis", "n");
			t.inserirResposta(13, "C) Sete", "n");
			t.inserirResposta(13, "D) Oito", "s");
			t.inserirResposta(13, "E) Dez", "n");
		}else if(controle == 31){
			t.inserirResposta(14, "A) Surgiu no Oriente e era transmitida atrav�s da pulga do rato", "s");
			t.inserirResposta(14, "B) Teve seu auge na Alta Idade M�dia", "n");
			t.inserirResposta(14, "C) A Peste pneum�nica � transmitida atrav�s do contato sangu�neo", "n");
			t.inserirResposta(14, "D) As condi��es de higiene na Idade M�dia n�o propiciaram a prolifera��o da peste", "n");
			t.inserirResposta(14, "E) As pessoas n�o acreditavam que iriam se curar atrav�s da f�", "n");
		}else if(controle == 32){
			t.inserirResposta(15, "A) Consolidar o feudalismo", "n");
			t.inserirResposta(15, "B) Conquistar a terra santa", "s");
			t.inserirResposta(15, "C) Favorecer as forma��es dos crist�es", "n");
			t.inserirResposta(15, "D) Conquistar estabilidade pol�tica e econ�mica", "n");
			t.inserirResposta(15, "E) Diminuir o prestigio do clero", "n");
		}else if(controle == 33){
			t.inserirResposta(16, "A) Lombardos, visigodos e cartagineses", "n");
			t.inserirResposta(16, "B) Persas, francos e eslavos", "n");
			t.inserirResposta(16, "C) Hebreus, ostrogodos e eg�pcios", "n");
			t.inserirResposta(16, "D) Lombardos, francos e v�ndalos", "s");
			t.inserirResposta(16, "E) Vikings, eslavos, persas", "n");
		}else if(controle == 34){
			t.inserirResposta(17, "A) Regime de trabalho servil, fragmenta��o pol�tica e economia agr�ria", "s");
			t.inserirResposta(17, "B) La�os de vassalagem, explora��o burguesa da terra e economia autossuficiente", "n");
			t.inserirResposta(17, "C) Economia monetizada, cultura clericalizada e estado mon�rquico", "n");
			t.inserirResposta(17, "D) Estado centralizado, economia agr�ria e mentalidade fortemente religiosa", "n");
			t.inserirResposta(17, "E) Estado fragmentado, economia monet�ria e mentalidade pag�", "n");
		}else if(controle == 35){
			t.inserirResposta(18, "A) Proteger os of�cios contra a concorr�ncia e controlar a produ��o", "s");
			t.inserirResposta(18, "B) Combater os judeus e mul�umanos que eram comerciantes", "n");
			t.inserirResposta(18, "C) Combater o sistema feudal e disseminar os princ�pios capitalistas", "n");
			t.inserirResposta(18, "D) Comercializar especiarias e colonizar a Am�rica", "n");
			t.inserirResposta(18, "E) Fortalecer os la�os feudais e impedir o surgimento do capitalismo", "n");
		}else if(controle == 36){
			t.inserirResposta(19, "A) Rousseau, Voltaire e Nietzsche", "n");
			t.inserirResposta(19, "B) Engels, John Locke e Rousseau", "n");
			t.inserirResposta(19, "C) Montesquieu, Voltaire e D�Alembert", "s");
			t.inserirResposta(19, "D) John Locke, Thomas Hobbes e Montesquieu", "n");
			t.inserirResposta(19, "E) Diderot, Engels e Rousseau", "n");
		}else if(controle == 37){
			t.inserirResposta(20, "A) O anglicanismo surgiu na Inglaterra a partir do div�rcio de Henrique VIII com Catarina de Arag�o", "n");
			t.inserirResposta(20, "B) Henrique VIII desvincula-se da igreja cat�lica ap�s o papa negar seu pedido de div�rcio com Ana Bolena", "n");
			t.inserirResposta(20, "C) O rei da Inglaterra torna-se chefe supremo do Estado e da Igreja anglicana", "s");
			t.inserirResposta(20, "D) Henrique VIII manteve o celibato para sacerdotes na Igreja anglicana", "n");
			t.inserirResposta(20, "E) A partir do anglicanismo surgiram na Inglaterra os presbiterianos e puritanos", "n");
		}else if(controle == 38){
			t.inserirResposta(21, "A) Fran�a e Espanha", "s");
			t.inserirResposta(21, "B) Fran�a e Inglaterra", "n");
			t.inserirResposta(21, "C) Holanda e Espanha", "n");
			t.inserirResposta(21, "D) Espanha e Inglaterra", "n");
			t.inserirResposta(21, "E) Fran�a e Holanda", "n");
		}else if(controle == 39){
			t.inserirResposta(22, "A) Libert�, Gagner, Fraternit�", "n");
			t.inserirResposta(22, "B) Frapper, Conqu�rir, Libert�", "n");
			t.inserirResposta(22, "C) Se battre, Egalit�, Gagner", "n");
			t.inserirResposta(22, "D) Se battre, Conqu�rir, Gagner", "n");
			t.inserirResposta(22, "E) Libert�, Egalit�, Fraternit�", "s");
		}else if(controle == 40){
			t.inserirResposta(23, "A) Balan�a comercial favor�vel, protecionismo e metalismo", "s");
			t.inserirResposta(23, "B) Aus�ncias do estado, combate ao monop�lio e acumulo de metais preciosos", "n");
			t.inserirResposta(23, "C) Protecionismo, interfer�ncia estatal e aus�ncia de acumulo de metais preciosos", "n");
			t.inserirResposta(23, "D) Combate ao monop�lio, protecionismo e empenho no acumulo de moeda", "n");
			t.inserirResposta(23, "E) Protecionismo, metalismo e aus�ncia estatal", "n");
		}else if(controle == 41){
			t.inserirResposta(24, "A) A perspectiva tridimensional e a pintura a �leo", "s");
			t.inserirResposta(24, "B) Pinturas referente a vida de santos e o nu", "n");
			t.inserirResposta(24, "C) O retrato e o estilo rom�nico na arquitetura", "n");
			t.inserirResposta(24, "D) A influ�ncia da arte bizantina e �rabe", "n");
			t.inserirResposta(24, "E) As alegorias mitol�gicas e o mosaico", "n");
		}else if(controle == 42){
			t.inserirResposta(25, "A) Rigidez econ�mica com Estados e Munic�pios", "n");
			t.inserirResposta(25, "B) Recupera��o da Receita", "n");
			t.inserirResposta(25, "C) Ajustes nos bancos estaduais", "n");
			t.inserirResposta(25, "D) Corte de gastos p�blicos", "n");
			t.inserirResposta(25, "E) A estatiza��o de empresas privadas", "s");
		}else if(controle == 43){
			t.inserirResposta(26, "A) Propiciou a chegada dos mencheviques ao poder", "n");
			t.inserirResposta(26, "B) Propiciou a chegada dos bolcheviques ao poder", "s");
			t.inserirResposta(26, "C) Levou o soviete de Petrogrado a derrubar o czar Nicolau II", "n");
			t.inserirResposta(26, "D) Deu in�cio a segunda na��o socialista do planeta", "n");
			t.inserirResposta(26, "E) Teve como principal l�der L�on Tr�tski", "n");
		}else if(controle == 44){
			t.inserirResposta(27, "A) Foi um movimento liberal para a difus�o do capitalismo", "n");
			t.inserirResposta(27, "B) Foi um movimento contra a Revolu��o Industrial, onde manifestantes destru�am m�quinas", "s");
			t.inserirResposta(27, "C) Foi um movimento contra a difus�o do pensamento marxista", "n");
			t.inserirResposta(27, "D) Foi um movimento que protestava contra a expans�o do estado", "n");
			t.inserirResposta(27, "E) Foi um movimento que empres�rios se reuniam para planejar expans�o dos neg�cios", "n");
		}else if(controle == 45){
			t.inserirResposta(28, "A) FARC", "n");
			t.inserirResposta(28, "B) Al Qaeda", "s");
			t.inserirResposta(28, "C) Talib�", "n");
			t.inserirResposta(28, "D) ETA", "n");
			t.inserirResposta(28, "E) Estado Isl�mico", "n");
		}else if(controle == 46){
			t.inserirResposta(29, "A) Da cidade de Guernica bombardeada pela avia��o alem� em apoio ao general Franco", "s");
			t.inserirResposta(29, "B) Das cidades espanholas pelo General Franco contra os republicanos", "n");
			t.inserirResposta(29, "C) Das vilas espanholas pelas tropas nazistas durante a Segunda Guerra Mundial", "n");
			t.inserirResposta(29, "D) Da cidade de Guernica, pelos republicanos contra o governo do General Franco", "n");
			t.inserirResposta(29, "E) Das cidades espanholas pelos nazistas durante a Segunda Guerra Mundial", "n");
		}else if(controle == 47){
			t.inserirResposta(30, "A) Do ambiente de instabilidade b�lica no leste europeu", "n");
			t.inserirResposta(30, "B) Do fracasso na aplica��o pr�tica do composto at�mico posto em teste", "n");
			t.inserirResposta(30, "C) Do comportamento inesperado de um dos reatores", "s");
			t.inserirResposta(30, "D) De um equ�voco diplom�tico", "n");
			t.inserirResposta(30, "E) Do rompimento da c�mara de conten��o por eleva��o da pot�ncia", "n");
		}else if(controle == 48){
			t.inserirResposta(31, "A) Jos� da Costa Carvalho", "n");
			t.inserirResposta(31, "B) Pedro de Ara�jo Lima (Marqu�s de Olinda)", "n");
			t.inserirResposta(31, "C) Diogo Feij�", "s");
			t.inserirResposta(31, "D) Sebasti�o Jos� de Carvalho e Melo (Marqu�s de Pombal)", "n");
			t.inserirResposta(31, "E) Jos� Bonif�cio", "n");
		}else if(controle == 49){
			t.inserirResposta(32, "A) Pernambuco, Bahia, Para�ba, Cear� e Maranh�o", "n");
			t.inserirResposta(32, "B) Amazonas, Par�, Amap�, Roraima e Rond�nia", "s");
			t.inserirResposta(32, "C) S�o Paulo, Rio de Janeiro, Santa Catarina, Minas Gerais", "n");
			t.inserirResposta(32, "D) Rio Grande do Sul, Paran�, S�o Paulo, Minas Gerais e a regi�o da Cisplatina", "n");
			t.inserirResposta(32, "E) Mato Grosso, Mato Grosso do Sul, Piau�, Pernambuco e Bahia", "n");
		}else if(controle == 50){
			t.inserirResposta(33, "A) Holanda e Fran�a", "s");
			t.inserirResposta(33, "B) Fran�a e Espanha", "n");
			t.inserirResposta(33, "C) Espanha e Inglaterra", "n");
			t.inserirResposta(33, "D) Holanda e Espanha", "n");
			t.inserirResposta(33, "E) Fran�a e Inglaterra", "n");
		}else if(controle == 51){
			t.inserirResposta(34, "A) Absoluto", "n");
			t.inserirResposta(34, "B) Moderador", "s");
			t.inserirResposta(34, "C) R�gio", "n");
			t.inserirResposta(34, "D) Patriarcal", "n");
			t.inserirResposta(34, "E) Hier�rquico", "n");
		}else if(controle == 52){
			t.inserirResposta(35, "A) Foi marcado pela extin��o do poder moderador", "s");
			t.inserirResposta(35, "B) Foi marcado pelas leis graduais de aboli��o da escravid�o", "n");
			t.inserirResposta(35, "C) Foi marcado pelo tr�fico transatl�ntico de escravos", "n");
			t.inserirResposta(35, "D) Foi marcado pela expans�o da cafeicultura", "n");
			t.inserirResposta(35, "E) Foi marcado pelo revezamento dos partidos conservadores e liberais, no poder", "n");
		}else if(controle == 53){
			t.inserirResposta(36, "A) Deposi��o", "s");
			t.inserirResposta(36, "B) Ren�ncia", "n");
			t.inserirResposta(36, "C) Suic�dio", "n");
			t.inserirResposta(36, "D) Fim do mandato", "n");
			t.inserirResposta(36, "E) Morte natural", "n");
		}

	}
	
}

