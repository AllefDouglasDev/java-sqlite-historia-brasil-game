package model.dao;

public class Migration {
	private Repository t;
	
	public Migration() {
		t = new Repository();
	}
	
	public void migrate() {
		t.createTable("CREATE TABLE IF NOT EXISTS `escola` (`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,`nome` varchar(50) NOT NULL);"); 

		t.createTable("CREATE TABLE IF NOT EXISTS `assunto`(`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,`nome` varchar(40) NOT NULL);");

		t.createTable("CREATE TABLE IF NOT EXISTS `pergunta` (`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `pergunta` VARVHAR(200) NOT NULL,  `respondida` varchar(10) NOT NULL, `id_assunto` INTEGER NOT NULL, FOREIGN KEY (`id_assunto`) REFERENCES assunto (`id`));");

		t.createTable("CREATE TABLE IF NOT EXISTS `alternativa` (`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,  `id_pergunta` INTEGER NOT NULL,  `resposta` varchar(200) NOT NULL,  `correta` varchar(10) NOT NULL,  FOREIGN KEY (`id_pergunta`) REFERENCES pergunta (`id`));");

		t.createTable("CREATE TABLE IF NOT EXISTS `pontuacao` (`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,  `id_escola` INTEGER DEFAULT NULL,  `resposta_certa` INTEGER DEFAULT NULL,  `resposta_errada` INTEGER DEFAULT NULL,  FOREIGN KEY (`id_escola`) REFERENCES escola (`id`));");

		t.createTable("CREATE TABLE IF NOT EXISTS `escola_escolhe_assunto` (`id_escola` INTEGER NOT NULL,  `id_assunto` INTEGER NOT NULL,  PRIMARY KEY (`id_escola`,`id_assunto`),  FOREIGN KEY (`id_assunto`) REFERENCES assunto (`id`),  FOREIGN KEY (`id_escola`) REFERENCES escola (`id`));");
	}
	
	public void seed() {
		createSubjects();
		createQuestions();
		createAlternatives();
	}
	
	public void createSubjects() {
		t.createSubject("Pre-Historia");
		t.createSubject("Historia Antiga");
		t.createSubject("Historia Medieval");
		t.createSubject("Historia Moderna");
		t.createSubject("Historia Contemporania");
		t.createSubject("Historia do Brasil");
	}
	
	public void createQuestions() {
		t.createQuestion("O per�odo conhecido como Idade dos Metais, caracterizou-se por:", "n", 1);
		t.createQuestion("No per�odo neol�tico:", "n", 1);
		t.createQuestion("Durante o paleol�tico, ficou conhecida a arte rupestre que era:", "n", 1);
		t.createQuestion("Qual o nome para o per�odo onde o fogo foi dominado? ", "n", 1);
		t.createQuestion("S�o caracter�sticas do per�odo conhecido como Neol�tico:", "n", 1);
		t.createQuestion("Durante a chama �Idade da Pedra Lascada� surge como alternativa comunicativa a arte rupestre. O que era a arte rupestre?", "n", 1);
	

		t.createQuestion("Ap�s as grandes expans�es territoriais, qual atividade tornou-se a base da economia no Antigo Imp�rio Romano?", "n", 2);
		t.createQuestion("Na Gr�cia antiga:", "n", 2);
		t.createQuestion("Para que serviam as pir�mides no Egito antigo?", "n", 2);
		t.createQuestion("A lei de Tali�o �Olho por olho, dente por dente� � o mais antigo dos c�digos usados na antiguidade, criado pelo governante:", "n", 2);
		t.createQuestion("com base em seus conhecimentos sobre hist�ria antiga, onde surgiu as primeiras formas de escrita cuneiforme? ", "n", 2);
		t.createQuestion("O Edito de Mil�o, assinado em 313 d.C. por Constantino, mudou a rela��o entre igreja crist� e o estado romano, por qu�?", "n", 2);


		t.createQuestion("Oficialmente, quantas  �Guerras Santas� foram contabilizadas pelos historiadores medievais?", "n", 3);
		t.createQuestion("Sobre a peste negra:", "n", 3);
		t.createQuestion("Qual foi o principal objetivo das cruzadas?", "n", 3);
		t.createQuestion("Quais povos germ�nicos invadiram o Imp�rio Romano a partir do s�culo III d.C.", "n", 3);
		t.createQuestion("Podemos destacar dentro do modo de produ��o feudal os seguintes aspectos:", "n", 3);
		t.createQuestion("As corpora��es de Of�cio, no contexto medieval, t�m como seu objetivo principal:", "n", 3);
		

		t.createQuestion("Entre os fil�sofos que basearam a teoria iluminista, est�o:", "n", 4);
		t.createQuestion("A reforma religiosa inglesa teve como consequ�ncia:", "n", 4);
		t.createQuestion("Na Guerra de Independ�ncia, os EUA tiveram o apoio dos seguintes pa�ses:", "n", 4);
		t.createQuestion("Qual foi o lema que ficou bastante conhecido durante a revolu��o francesa, por resumir todos os desejos da Fran�a em uma s� frase?", "n", 4);
		t.createQuestion("Quais caracter�sticas abaixo, podem ser atribu�das a pol�tica econ�mica mercantilista", "n", 4);
		t.createQuestion("Quais caracter�sticas podemos apontar sobre a arte renascentista:", "n", 4);
		

		t.createQuestion("O Programa de A��o Imediata (PAI), uma das fases do Plano Real, elaborado em 1993 para atender as �necessidades� econ�micas da �poca, n�o tinha como medida:", "n", 5);
		t.createQuestion("A Revolu��o russa:", "n", 5);
		t.createQuestion("O �ludismo� que ocorreu durante a Revolu��o Industrial:", "n", 5);
		t.createQuestion("O dia 11 de setembro de 2001, ficou marcado pelo ataque as Torres G�meas em Nova Iorque. Qual o grupo terrorista que comandou o ataque?", "n", 5);
		t.createQuestion("No quadro �Guernica�, Picasso, registrou a trag�dia e a destrui��o", "n", 5);
		t.createQuestion("O acidente nuclear de Chernobyl fora consequ�ncia:", "n", 5);
		

		t.createQuestion("O principal l�der do partido liberal no per�odo regencial brasileiro foi:", "n", 6);
		t.createQuestion("A cabanagem, influenciada pela Revolu��o Francesa, teve a presen�a dos atuais estados:", "n", 6);
		t.createQuestion("Entre os s�culos XVI e XVII, dois pa�ses tentaram invadir o Brasil e fincar ra�zes para tir�-lo de Portugal. Quais foram esses pa�ses?", "n", 6);
		t.createQuestion("Na primeira constitui��o Brasileira em 1824, existiam quatro poderes. Al�m dos poderes Executivo, Legislativo e Judici�rio, havia:", "n", 6);
		t.createQuestion("Sobre o Segundo Reinado, � incorreto afirmar que", "n", 6);
		t.createQuestion("Get�lio Vargas durante seu governo instruiu o estado novo, que terminou em 1945 por:", "n", 6);
	}
	
	public void createAlternatives() {
		t.createAlternative(1, "A) Desenvolvimento de m�quinas industriais durante a Revolu��o Industrial", "n");
		t.createAlternative(1, "B) Desenvolvimento de t�cnicas de fundir e moldar artigos como o cobre e o estanho", "s");
		t.createAlternative(1, "C) Cria��o de artigos como o ferro, o cobre e o estanho, assim como a descoberta do fogo", "n");
		t.createAlternative(1, "D) Desenvolvimento de moldagem de moedas, o que deu inicio aos primeiros sistemas econ�micos", "n");
		t.createAlternative(1, "E) Desenvolvimento do ferro e sua utiliza��o na arte pr�-hist�rica", "n");

		t.createAlternative(2, "A) O homem pr�-hist�rico utilizava a pedra polida", "s");
		t.createAlternative(2, "B) O homem pr�-hist�rico n�o tinha controle sobre o fogo", "n");
		t.createAlternative(2, "C) Os seres humanos eram n�mades", "n");
		t.createAlternative(2, "D) Os seres humanos ainda n�o dominavam t�cnicas agr�colas", "n");
		t.createAlternative(2, "E) O homem pr�-hist�rico utilizava a pedra lascada", "n");

		t.createAlternative(3, "A) Arte feita no corpo humano utilizando tinturas naturais", "n");
		t.createAlternative(3, "B) Arte criada pelos gregos, onde se esculpiam est�tuas de deuses", "n");
		t.createAlternative(3, "C) Arte feita na parede de cavernas ou em pedras", "s");
		t.createAlternative(3, "D) Arte feita pelos escravos durante o per�odo colonial no Brasil", "n");
		t.createAlternative(3, "E) Arte feita pelos povos chin�s durante a dinastia Han", "n");

		t.createAlternative(4, "A) Neol�tico", "n");
		t.createAlternative(4, "B) Paleol�tico", "s");
		t.createAlternative(4, "C) Mesol�tico", "n");
		t.createAlternative(4, "D) Paleol�tico", "n");
		t.createAlternative(4, "E) Idade da pedra polida", "n");

		t.createAlternative(5, "A) A habita��o em cavernas, a ca�a rudimentar e a escrita", "n");
		t.createAlternative(5, "B) A forma��o de corpos sociais coletivos com a finalidade de preserva��o da esp�cie", "n");
		t.createAlternative(5, "C) O in�cio do processo de sedentariza��o com a pr�tica da agricultura e a domestica��o de animais", "s");
		t.createAlternative(5, "D) Os seres humanos n�o dominavam a escrita ou se quer dispunham de qualquer recurso para se comunicarem", "n");
		t.createAlternative(5, "E) O uso intensivo de utens�lios provenientes de metais", "n");

		t.createAlternative(6, "A) Tipo de arte feita na Pr�-hist�ria com caracter�sticas de culto �s divindades da natureza", "n");
		t.createAlternative(6, "B) Pinturas corporais utilizadas como s�mbolo de bom aug�rio entre os ca�adores", "n");
		t.createAlternative(6, "C) Estilo art�stico desenvolvido na Pr�-Hist�ria utilizado como forma de comunica��o n�made", "n");
		t.createAlternative(6, "D) Arte dos �rupus�. Grupos isolados respons�veis por grandes monumentos ostensivos aos povos rivais", "n");
		t.createAlternative(6, "E) A arte rupestre era composta por representa��es gr�ficas (desenhos, s�mbolos, sinais) feitas em paredes de cavernas ou pedras pelos homens do per�odo Paleol�tico", "s");

		t.createAlternative(7, "A) Agricultura", "n");
		t.createAlternative(7, "B) Com�rcio", "n");
		t.createAlternative(7, "C) M�o de obra escrava", "s");
		t.createAlternative(7, "D) Sistema de Vassalagem", "n");
		t.createAlternative(7, "E) Manufatura", "n");

		t.createAlternative(8, "A) O Estado surge na �poca cl�ssica", "n");
		t.createAlternative(8, "B) As primeiras P�lis teriam surgido na Gr�cia asi�tica pelos J�nios e os e�lios", "s");
		t.createAlternative(8, "C) O surgimento da escravid�o impossibilitou a divis�o do trabalho em agricultura e artesanato", "n");
		t.createAlternative(8, "D) Os artigos de artesanato eram, na sua maior parte, importados das col�nias espalhadas pelo mediterr�neo", "n");
		t.createAlternative(8, "E) A cidade-estado de Esparta foi fundada sobre territ�rio conquistado pelos J�nios", "n");

		t.createAlternative(9, "A) Serviam basicamente como o principal local de com�rcio", "n");
		t.createAlternative(9, "B) Serviam de templo religioso", "n");
		t.createAlternative(9, "C) Serviam para proteger e conservar o corpo do fara� mumificado", "s");
		t.createAlternative(9, "D) Serviam como pal�cio para os fara�s", "n");
		t.createAlternative(9, "E) Serviam como monumento ao deus Amon", "n");

		t.createAlternative(10, "A) Sarg�o I", "n");
		t.createAlternative(10, "B) Ramses", "n");
		t.createAlternative(10, "C) Torah", "n");
		t.createAlternative(10, "D) Hamurabi", "s");
		t.createAlternative(10, "E) Nabucodonosor", "n");

		t.createAlternative(11, "A) Mesopot�mia", "s");
		t.createAlternative(11, "B) Fen�cia", "n");
		t.createAlternative(11, "C) P�rsia", "n");
		t.createAlternative(11, "D) Palestina", "n");
		t.createAlternative(11, "E) Egito", "n");

		t.createAlternative(12, "A) Proibiu a religi�o crist� no Imp�rio","n");
		t.createAlternative(12, "B) Assegurou a liberdade de culto aos crist�os", "s");
		t.createAlternative(12, "C) Tornou o cristianismo a religi�o oficial do Imp�rio", "n");
		t.createAlternative(12, "D) Submeteu os crist�os ao culto oficial do Imperador", "n");
		t.createAlternative(12, "E) Contribuiu para a aceita��o do polite�smo pelos crist�os", "n");

		t.createAlternative(13, "A) Tr�s", "n");
		t.createAlternative(13, "B) Seis", "n");
		t.createAlternative(13, "C) Sete", "n");
		t.createAlternative(13, "D) Oito", "s");
		t.createAlternative(13, "E) Dez", "n");

		t.createAlternative(14, "A) Surgiu no Oriente e era transmitida atrav�s da pulga do rato", "s");
		t.createAlternative(14, "B) Teve seu auge na Alta Idade M�dia", "n");
		t.createAlternative(14, "C) A Peste pneum�nica � transmitida atrav�s do contato sangu�neo", "n");
		t.createAlternative(14, "D) As condi��es de higiene na Idade M�dia n�o propiciaram a prolifera��o da peste", "n");
		t.createAlternative(14, "E) As pessoas n�o acreditavam que iriam se curar atrav�s da f�", "n");

		t.createAlternative(15, "A) Consolidar o feudalismo", "n");
		t.createAlternative(15, "B) Conquistar a terra santa", "s");
		t.createAlternative(15, "C) Favorecer as forma��es dos crist�es", "n");
		t.createAlternative(15, "D) Conquistar estabilidade pol�tica e econ�mica", "n");
		t.createAlternative(15, "E) Diminuir o prestigio do clero", "n");

		t.createAlternative(16, "A) Lombardos, visigodos e cartagineses", "n");
		t.createAlternative(16, "B) Persas, francos e eslavos", "n");
		t.createAlternative(16, "C) Hebreus, ostrogodos e eg�pcios", "n");
		t.createAlternative(16, "D) Lombardos, francos e v�ndalos", "s");
		t.createAlternative(16, "E) Vikings, eslavos, persas", "n");

		t.createAlternative(17, "A) Regime de trabalho servil, fragmenta��o pol�tica e economia agr�ria", "s");
		t.createAlternative(17, "B) La�os de vassalagem, explora��o burguesa da terra e economia autossuficiente", "n");
		t.createAlternative(17, "C) Economia monetizada, cultura clericalizada e estado mon�rquico", "n");
		t.createAlternative(17, "D) Estado centralizado, economia agr�ria e mentalidade fortemente religiosa", "n");
		t.createAlternative(17, "E) Estado fragmentado, economia monet�ria e mentalidade pag�", "n");

		t.createAlternative(18, "A) Proteger os of�cios contra a concorr�ncia e controlar a produ��o", "s");
		t.createAlternative(18, "B) Combater os judeus e mul�umanos que eram comerciantes", "n");
		t.createAlternative(18, "C) Combater o sistema feudal e disseminar os princ�pios capitalistas", "n");
		t.createAlternative(18, "D) Comercializar especiarias e colonizar a Am�rica", "n");
		t.createAlternative(18, "E) Fortalecer os la�os feudais e impedir o surgimento do capitalismo", "n");

		t.createAlternative(19, "A) Rousseau, Voltaire e Nietzsche", "n");
		t.createAlternative(19, "B) Engels, John Locke e Rousseau", "n");
		t.createAlternative(19, "C) Montesquieu, Voltaire e D�Alembert", "s");
		t.createAlternative(19, "D) John Locke, Thomas Hobbes e Montesquieu", "n");
		t.createAlternative(19, "E) Diderot, Engels e Rousseau", "n");

		t.createAlternative(20, "A) O anglicanismo surgiu na Inglaterra a partir do div�rcio de Henrique VIII com Catarina de Arag�o", "n");
		t.createAlternative(20, "B) Henrique VIII desvincula-se da igreja cat�lica ap�s o papa negar seu pedido de div�rcio com Ana Bolena", "n");
		t.createAlternative(20, "C) O rei da Inglaterra torna-se chefe supremo do Estado e da Igreja anglicana", "s");
		t.createAlternative(20, "D) Henrique VIII manteve o celibato para sacerdotes na Igreja anglicana", "n");
		t.createAlternative(20, "E) A partir do anglicanismo surgiram na Inglaterra os presbiterianos e puritanos", "n");

		t.createAlternative(21, "A) Fran�a e Espanha", "s");
		t.createAlternative(21, "B) Fran�a e Inglaterra", "n");
		t.createAlternative(21, "C) Holanda e Espanha", "n");
		t.createAlternative(21, "D) Espanha e Inglaterra", "n");
		t.createAlternative(21, "E) Fran�a e Holanda", "n");

		t.createAlternative(22, "A) Libert�, Gagner, Fraternit�", "n");
		t.createAlternative(22, "B) Frapper, Conqu�rir, Libert�", "n");
		t.createAlternative(22, "C) Se battre, Egalit�, Gagner", "n");
		t.createAlternative(22, "D) Se battre, Conqu�rir, Gagner", "n");
		t.createAlternative(22, "E) Libert�, Egalit�, Fraternit�", "s");

		t.createAlternative(23, "A) Balan�a comercial favor�vel, protecionismo e metalismo", "s");
		t.createAlternative(23, "B) Aus�ncias do estado, combate ao monop�lio e acumulo de metais preciosos", "n");
		t.createAlternative(23, "C) Protecionismo, interfer�ncia estatal e aus�ncia de acumulo de metais preciosos", "n");
		t.createAlternative(23, "D) Combate ao monop�lio, protecionismo e empenho no acumulo de moeda", "n");
		t.createAlternative(23, "E) Protecionismo, metalismo e aus�ncia estatal", "n");

		t.createAlternative(24, "A) A perspectiva tridimensional e a pintura a �leo", "s");
		t.createAlternative(24, "B) Pinturas referente a vida de santos e o nu", "n");
		t.createAlternative(24, "C) O retrato e o estilo rom�nico na arquitetura", "n");
		t.createAlternative(24, "D) A influ�ncia da arte bizantina e �rabe", "n");
		t.createAlternative(24, "E) As alegorias mitol�gicas e o mosaico", "n");

		t.createAlternative(25, "A) Rigidez econ�mica com Estados e Munic�pios", "n");
		t.createAlternative(25, "B) Recupera��o da Receita", "n");
		t.createAlternative(25, "C) Ajustes nos bancos estaduais", "n");
		t.createAlternative(25, "D) Corte de gastos p�blicos", "n");
		t.createAlternative(25, "E) A estatiza��o de empresas privadas", "s");

		t.createAlternative(26, "A) Propiciou a chegada dos mencheviques ao poder", "n");
		t.createAlternative(26, "B) Propiciou a chegada dos bolcheviques ao poder", "s");
		t.createAlternative(26, "C) Levou o soviete de Petrogrado a derrubar o czar Nicolau II", "n");
		t.createAlternative(26, "D) Deu in�cio a segunda na��o socialista do planeta", "n");
		t.createAlternative(26, "E) Teve como principal l�der L�on Tr�tski", "n");

		t.createAlternative(27, "A) Foi um movimento liberal para a difus�o do capitalismo", "n");
		t.createAlternative(27, "B) Foi um movimento contra a Revolu��o Industrial, onde manifestantes destru�am m�quinas", "s");
		t.createAlternative(27, "C) Foi um movimento contra a difus�o do pensamento marxista", "n");
		t.createAlternative(27, "D) Foi um movimento que protestava contra a expans�o do estado", "n");
		t.createAlternative(27, "E) Foi um movimento que empres�rios se reuniam para planejar expans�o dos neg�cios", "n");

		t.createAlternative(28, "A) FARC", "n");
		t.createAlternative(28, "B) Al Qaeda", "s");
		t.createAlternative(28, "C) Talib�", "n");
		t.createAlternative(28, "D) ETA", "n");
		t.createAlternative(28, "E) Estado Isl�mico", "n");

		t.createAlternative(29, "A) Da cidade de Guernica bombardeada pela avia��o alem� em apoio ao general Franco", "s");
		t.createAlternative(29, "B) Das cidades espanholas pelo General Franco contra os republicanos", "n");
		t.createAlternative(29, "C) Das vilas espanholas pelas tropas nazistas durante a Segunda Guerra Mundial", "n");
		t.createAlternative(29, "D) Da cidade de Guernica, pelos republicanos contra o governo do General Franco", "n");
		t.createAlternative(29, "E) Das cidades espanholas pelos nazistas durante a Segunda Guerra Mundial", "n");

		t.createAlternative(30, "A) Do ambiente de instabilidade b�lica no leste europeu", "n");
		t.createAlternative(30, "B) Do fracasso na aplica��o pr�tica do composto at�mico posto em teste", "n");
		t.createAlternative(30, "C) Do comportamento inesperado de um dos reatores", "s");
		t.createAlternative(30, "D) De um equ�voco diplom�tico", "n");
		t.createAlternative(30, "E) Do rompimento da c�mara de conten��o por eleva��o da pot�ncia", "n");

		t.createAlternative(31, "A) Jos� da Costa Carvalho", "n");
		t.createAlternative(31, "B) Pedro de Ara�jo Lima (Marqu�s de Olinda)", "n");
		t.createAlternative(31, "C) Diogo Feij�", "s");
		t.createAlternative(31, "D) Sebasti�o Jos� de Carvalho e Melo (Marqu�s de Pombal)", "n");
		t.createAlternative(31, "E) Jos� Bonif�cio", "n");

		t.createAlternative(32, "A) Pernambuco, Bahia, Para�ba, Cear� e Maranh�o", "n");
		t.createAlternative(32, "B) Amazonas, Par�, Amap�, Roraima e Rond�nia", "s");
		t.createAlternative(32, "C) S�o Paulo, Rio de Janeiro, Santa Catarina, Minas Gerais", "n");
		t.createAlternative(32, "D) Rio Grande do Sul, Paran�, S�o Paulo, Minas Gerais e a regi�o da Cisplatina", "n");
		t.createAlternative(32, "E) Mato Grosso, Mato Grosso do Sul, Piau�, Pernambuco e Bahia", "n");

		t.createAlternative(33, "A) Holanda e Fran�a", "s");
		t.createAlternative(33, "B) Fran�a e Espanha", "n");
		t.createAlternative(33, "C) Espanha e Inglaterra", "n");
		t.createAlternative(33, "D) Holanda e Espanha", "n");
		t.createAlternative(33, "E) Fran�a e Inglaterra", "n");

		t.createAlternative(34, "A) Absoluto", "n");
		t.createAlternative(34, "B) Moderador", "s");
		t.createAlternative(34, "C) R�gio", "n");
		t.createAlternative(34, "D) Patriarcal", "n");
		t.createAlternative(34, "E) Hier�rquico", "n");

		t.createAlternative(35, "A) Foi marcado pela extin��o do poder moderador", "s");
		t.createAlternative(35, "B) Foi marcado pelas leis graduais de aboli��o da escravid�o", "n");
		t.createAlternative(35, "C) Foi marcado pelo tr�fico transatl�ntico de escravos", "n");
		t.createAlternative(35, "D) Foi marcado pela expans�o da cafeicultura", "n");
		t.createAlternative(35, "E) Foi marcado pelo revezamento dos partidos conservadores e liberais, no poder", "n");

		t.createAlternative(36, "A) Deposi��o", "s");
		t.createAlternative(36, "B) Ren�ncia", "n");
		t.createAlternative(36, "C) Suic�dio", "n");
		t.createAlternative(36, "D) Fim do mandato", "n");
		t.createAlternative(36, "E) Morte natural", "n");
	}
	
}

