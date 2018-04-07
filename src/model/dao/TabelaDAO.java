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
			t.inserirAssunto("Pré-História");
			//System.out.println("Pré-História");
		}else if(controle == 7){
			t.inserirAssunto("História Antiga");
			//System.out.println("História Antiga");
		}else if(controle == 8){
			t.inserirAssunto("História Medieval");
			//System.out.println("História Medieval");
		}else if(controle == 9){
			t.inserirAssunto("História Moderna");
			//System.out.println("História Moderna");
		}else if(controle == 10){
			t.inserirAssunto("História Contemporânia");
			//System.out.println("História Contemporânia");
		}else{
			t.inserirAssunto("História do Brasil");
			//System.out.println("História do Brasil");
		}
	}
	
	public void insertPergunta(int controle)
	{
		TabelasInsertsDAO t = new TabelasInsertsDAO();
		if(controle == 12){
			t.inserirPergunta("O período conhecido como Idade dos Metais, caracterizou-se por:", "n", 1);
			t.inserirPergunta("No período neolítico:", "n", 1);
			t.inserirPergunta("Durante o paleolítico, ficou conhecida a arte rupestre que era:", "n", 1);
			t.inserirPergunta("Qual o nome para o período onde o fogo foi dominado? ", "n", 1);
			t.inserirPergunta("São características do período conhecido como Neolítico:", "n", 1);
			t.inserirPergunta("Durante a chama “Idade da Pedra Lascada” surge como alternativa comunicativa a arte rupestre. O que era a arte rupestre?", "n", 1);
		
			//System.out.println("Completo 1");
		}else if(controle == 13){
			t.inserirPergunta("Após as grandes expansões territoriais, qual atividade tornou-se a base da economia no Antigo Império Romano?", "n", 2);
			t.inserirPergunta("Na Grécia antiga:", "n", 2);
			t.inserirPergunta("Para que serviam as pirâmides no Egito antigo?", "n", 2);
			t.inserirPergunta("A lei de Talião “Olho por olho, dente por dente” é o mais antigo dos códigos usados na antiguidade, criado pelo governante:", "n", 2);
			t.inserirPergunta("com base em seus conhecimentos sobre história antiga, onde surgiu as primeiras formas de escrita cuneiforme? ", "n", 2);
			t.inserirPergunta("O Edito de Milão, assinado em 313 d.C. por Constantino, mudou a relação entre igreja cristã e o estado romano, por quê?", "n", 2);

			//System.out.println("Completo 2");
		}else if(controle == 14){
			t.inserirPergunta("Oficialmente, quantas  “Guerras Santas” foram contabilizadas pelos historiadores medievais?", "n", 3);
			t.inserirPergunta("Sobre a peste negra:", "n", 3);
			t.inserirPergunta("Qual foi o principal objetivo das cruzadas?", "n", 3);
			t.inserirPergunta("Quais povos germânicos invadiram o Império Romano a partir do século III d.C.", "n", 3);
			t.inserirPergunta("Podemos destacar dentro do modo de produção feudal os seguintes aspectos:", "n", 3);
			t.inserirPergunta("As corporações de Ofício, no contexto medieval, têm como seu objetivo principal:", "n", 3);
			
			//System.out.println("Completo 3");
		}else if(controle == 15){
			t.inserirPergunta("Entre os filósofos que basearam a teoria iluminista, estão:", "n", 4);
			t.inserirPergunta("A reforma religiosa inglesa teve como consequência:", "n", 4);
			t.inserirPergunta("Na Guerra de Independência, os EUA tiveram o apoio dos seguintes países:", "n", 4);
			t.inserirPergunta("Qual foi o lema que ficou bastante conhecido durante a revolução francesa, por resumir todos os desejos da França em uma só frase?", "n", 4);
			t.inserirPergunta("Quais características abaixo, podem ser atribuídas a política econômica mercantilista", "n", 4);
			t.inserirPergunta("Quais características podemos apontar sobre a arte renascentista:", "n", 4);
			
			//System.out.println("Completo 4");
		}else if(controle == 16){
			t.inserirPergunta("O Programa de Ação Imediata (PAI), uma das fases do Plano Real, elaborado em 1993 para atender as “necessidades” econômicas da época, não tinha como medida:", "n", 5);
			t.inserirPergunta("A Revolução russa:", "n", 5);
			t.inserirPergunta("O “ludismo” que ocorreu durante a Revolução Industrial:", "n", 5);
			t.inserirPergunta("O dia 11 de setembro de 2001, ficou marcado pelo ataque as Torres Gêmeas em Nova Iorque. Qual o grupo terrorista que comandou o ataque?", "n", 5);
			t.inserirPergunta("No quadro “Guernica”, Picasso, registrou a tragédia e a destruição", "n", 5);
			t.inserirPergunta("O acidente nuclear de Chernobyl fora consequência:", "n", 5);
			
			//System.out.println("Completo 5");
		}else{
			t.inserirPergunta("O principal líder do partido liberal no período regencial brasileiro foi:", "n", 6);
			t.inserirPergunta("A cabanagem, influenciada pela Revolução Francesa, teve a presença dos atuais estados:", "n", 6);
			t.inserirPergunta("Entre os séculos XVI e XVII, dois países tentaram invadir o Brasil e fincar raízes para tirá-lo de Portugal. Quais foram esses países?", "n", 6);
			t.inserirPergunta("Na primeira constituição Brasileira em 1824, existiam quatro poderes. Além dos poderes Executivo, Legislativo e Judiciário, havia:", "n", 6);
			t.inserirPergunta("Sobre o Segundo Reinado, é incorreto afirmar que", "n", 6);
			t.inserirPergunta("Getúlio Vargas durante seu governo instruiu o estado novo, que terminou em 1945 por:", "n", 6);
			
			//System.out.println("Completo 6");
		}
	}
	
	public void insertAlternativas(int controle)
	{
		TabelasInsertsDAO t = new TabelasInsertsDAO();
		if(controle == 18){
			t.inserirResposta(1, "A) Desenvolvimento de máquinas industriais durante a Revolução Industrial", "n");
			t.inserirResposta(1, "B) Desenvolvimento de técnicas de fundir e moldar artigos como o cobre e o estanho", "s");
			t.inserirResposta(1, "C) Criação de artigos como o ferro, o cobre e o estanho, assim como a descoberta do fogo", "n");
			t.inserirResposta(1, "D) Desenvolvimento de moldagem de moedas, o que deu inicio aos primeiros sistemas econômicos", "n");
			t.inserirResposta(1, "E) Desenvolvimento do ferro e sua utilização na arte pré-histórica", "n");
		}else if(controle == 19){
			t.inserirResposta(2, "A) O homem pré-histórico utilizava a pedra polida", "s");
			t.inserirResposta(2, "B) O homem pré-histórico não tinha controle sobre o fogo", "n");
			t.inserirResposta(2, "C) Os seres humanos eram nômades", "n");
			t.inserirResposta(2, "D) Os seres humanos ainda não dominavam técnicas agrícolas", "n");
			t.inserirResposta(2, "E) O homem pré-histórico utilizava a pedra lascada", "n");
		}else if(controle == 20){
			t.inserirResposta(3, "A) Arte feita no corpo humano utilizando tinturas naturais", "n");
			t.inserirResposta(3, "B) Arte criada pelos gregos, onde se esculpiam estátuas de deuses", "n");
			t.inserirResposta(3, "C) Arte feita na parede de cavernas ou em pedras", "s");
			t.inserirResposta(3, "D) Arte feita pelos escravos durante o período colonial no Brasil", "n");
			t.inserirResposta(3, "E) Arte feita pelos povos chinês durante a dinastia Han", "n");
		}else if(controle == 21){
			t.inserirResposta(4, "A) Neolítico", "n");
			t.inserirResposta(4, "B) Paleolítico", "s");
			t.inserirResposta(4, "C) Mesolítico", "n");
			t.inserirResposta(4, "D) Paleolítico", "n");
			t.inserirResposta(4, "E) Idade da pedra polida", "n");
		}else if(controle == 22){
			t.inserirResposta(5, "A) A habitação em cavernas, a caça rudimentar e a escrita", "n");
			t.inserirResposta(5, "B) A formação de corpos sociais coletivos com a finalidade de preservação da espécie", "n");
			t.inserirResposta(5, "C) O início do processo de sedentarização com a prática da agricultura e a domesticação de animais", "s");
			t.inserirResposta(5, "D) Os seres humanos não dominavam a escrita ou se quer dispunham de qualquer recurso para se comunicarem", "n");
			t.inserirResposta(5, "E) O uso intensivo de utensílios provenientes de metais", "n");
		}else if(controle == 23){
			t.inserirResposta(6, "A) Tipo de arte feita na Pré-história com características de culto às divindades da natureza", "n");
			t.inserirResposta(6, "B) Pinturas corporais utilizadas como símbolo de bom augúrio entre os caçadores", "n");
			t.inserirResposta(6, "C) Estilo artístico desenvolvido na Pré-História utilizado como forma de comunicação nômade", "n");
			t.inserirResposta(6, "D) Arte dos “rupus”. Grupos isolados responsáveis por grandes monumentos ostensivos aos povos rivais", "n");
			t.inserirResposta(6, "E) A arte rupestre era composta por representações gráficas (desenhos, símbolos, sinais) feitas em paredes de cavernas ou pedras pelos homens do período Paleolítico", "s");
		}else if(controle == 24){
			t.inserirResposta(7, "A) Agricultura", "n");
			t.inserirResposta(7, "B) Comércio", "n");
			t.inserirResposta(7, "C) Mão de obra escrava", "s");
			t.inserirResposta(7, "D) Sistema de Vassalagem", "n");
			t.inserirResposta(7, "E) Manufatura", "n");
		}else if(controle == 25){
			t.inserirResposta(8, "A) O Estado surge na época clássica", "n");
			t.inserirResposta(8, "B) As primeiras Pólis teriam surgido na Grécia asiática pelos Jônios e os eólios", "s");
			t.inserirResposta(8, "C) O surgimento da escravidão impossibilitou a divisão do trabalho em agricultura e artesanato", "n");
			t.inserirResposta(8, "D) Os artigos de artesanato eram, na sua maior parte, importados das colônias espalhadas pelo mediterrâneo", "n");
			t.inserirResposta(8, "E) A cidade-estado de Esparta foi fundada sobre território conquistado pelos Jônios", "n");
		}else if(controle == 26){
			t.inserirResposta(9, "A) Serviam basicamente como o principal local de comércio", "n");
			t.inserirResposta(9, "B) Serviam de templo religioso", "n");
			t.inserirResposta(9, "C) Serviam para proteger e conservar o corpo do faraó mumificado", "s");
			t.inserirResposta(9, "D) Serviam como palácio para os faraós", "n");
			t.inserirResposta(9, "E) Serviam como monumento ao deus Amon", "n");
		}else if(controle == 27){
			t.inserirResposta(10, "A) Sargão I", "n");
			t.inserirResposta(10, "B) Ramses", "n");
			t.inserirResposta(10, "C) Torah", "n");
			t.inserirResposta(10, "D) Hamurabi", "s");
			t.inserirResposta(10, "E) Nabucodonosor", "n");
		}else if(controle == 28){
			t.inserirResposta(11, "A) Mesopotâmia", "s");
			t.inserirResposta(11, "B) Fenícia", "n");
			t.inserirResposta(11, "C) Pérsia", "n");
			t.inserirResposta(11, "D) Palestina", "n");
			t.inserirResposta(11, "E) Egito", "n");
		}else if(controle == 29){
			t.inserirResposta(12, "A) Proibiu a religião cristã no Império","n");
			t.inserirResposta(12, "B) Assegurou a liberdade de culto aos cristãos", "s");
			t.inserirResposta(12, "C) Tornou o cristianismo a religião oficial do Império", "n");
			t.inserirResposta(12, "D) Submeteu os cristãos ao culto oficial do Imperador", "n");
			t.inserirResposta(12, "E) Contribuiu para a aceitação do politeísmo pelos cristãos", "n");
		}else if(controle == 30){
			t.inserirResposta(13, "A) Três", "n");
			t.inserirResposta(13, "B) Seis", "n");
			t.inserirResposta(13, "C) Sete", "n");
			t.inserirResposta(13, "D) Oito", "s");
			t.inserirResposta(13, "E) Dez", "n");
		}else if(controle == 31){
			t.inserirResposta(14, "A) Surgiu no Oriente e era transmitida através da pulga do rato", "s");
			t.inserirResposta(14, "B) Teve seu auge na Alta Idade Média", "n");
			t.inserirResposta(14, "C) A Peste pneumônica é transmitida através do contato sanguíneo", "n");
			t.inserirResposta(14, "D) As condições de higiene na Idade Média não propiciaram a proliferação da peste", "n");
			t.inserirResposta(14, "E) As pessoas não acreditavam que iriam se curar através da fé", "n");
		}else if(controle == 32){
			t.inserirResposta(15, "A) Consolidar o feudalismo", "n");
			t.inserirResposta(15, "B) Conquistar a terra santa", "s");
			t.inserirResposta(15, "C) Favorecer as formações dos cristões", "n");
			t.inserirResposta(15, "D) Conquistar estabilidade política e econômica", "n");
			t.inserirResposta(15, "E) Diminuir o prestigio do clero", "n");
		}else if(controle == 33){
			t.inserirResposta(16, "A) Lombardos, visigodos e cartagineses", "n");
			t.inserirResposta(16, "B) Persas, francos e eslavos", "n");
			t.inserirResposta(16, "C) Hebreus, ostrogodos e egípcios", "n");
			t.inserirResposta(16, "D) Lombardos, francos e vândalos", "s");
			t.inserirResposta(16, "E) Vikings, eslavos, persas", "n");
		}else if(controle == 34){
			t.inserirResposta(17, "A) Regime de trabalho servil, fragmentação política e economia agrária", "s");
			t.inserirResposta(17, "B) Laços de vassalagem, exploração burguesa da terra e economia autossuficiente", "n");
			t.inserirResposta(17, "C) Economia monetizada, cultura clericalizada e estado monárquico", "n");
			t.inserirResposta(17, "D) Estado centralizado, economia agrária e mentalidade fortemente religiosa", "n");
			t.inserirResposta(17, "E) Estado fragmentado, economia monetária e mentalidade pagã", "n");
		}else if(controle == 35){
			t.inserirResposta(18, "A) Proteger os ofícios contra a concorrência e controlar a produção", "s");
			t.inserirResposta(18, "B) Combater os judeus e mulçumanos que eram comerciantes", "n");
			t.inserirResposta(18, "C) Combater o sistema feudal e disseminar os princípios capitalistas", "n");
			t.inserirResposta(18, "D) Comercializar especiarias e colonizar a América", "n");
			t.inserirResposta(18, "E) Fortalecer os laços feudais e impedir o surgimento do capitalismo", "n");
		}else if(controle == 36){
			t.inserirResposta(19, "A) Rousseau, Voltaire e Nietzsche", "n");
			t.inserirResposta(19, "B) Engels, John Locke e Rousseau", "n");
			t.inserirResposta(19, "C) Montesquieu, Voltaire e D’Alembert", "s");
			t.inserirResposta(19, "D) John Locke, Thomas Hobbes e Montesquieu", "n");
			t.inserirResposta(19, "E) Diderot, Engels e Rousseau", "n");
		}else if(controle == 37){
			t.inserirResposta(20, "A) O anglicanismo surgiu na Inglaterra a partir do divórcio de Henrique VIII com Catarina de Aragão", "n");
			t.inserirResposta(20, "B) Henrique VIII desvincula-se da igreja católica após o papa negar seu pedido de divórcio com Ana Bolena", "n");
			t.inserirResposta(20, "C) O rei da Inglaterra torna-se chefe supremo do Estado e da Igreja anglicana", "s");
			t.inserirResposta(20, "D) Henrique VIII manteve o celibato para sacerdotes na Igreja anglicana", "n");
			t.inserirResposta(20, "E) A partir do anglicanismo surgiram na Inglaterra os presbiterianos e puritanos", "n");
		}else if(controle == 38){
			t.inserirResposta(21, "A) França e Espanha", "s");
			t.inserirResposta(21, "B) França e Inglaterra", "n");
			t.inserirResposta(21, "C) Holanda e Espanha", "n");
			t.inserirResposta(21, "D) Espanha e Inglaterra", "n");
			t.inserirResposta(21, "E) França e Holanda", "n");
		}else if(controle == 39){
			t.inserirResposta(22, "A) Liberté, Gagner, Fraternité", "n");
			t.inserirResposta(22, "B) Frapper, Conquérir, Liberté", "n");
			t.inserirResposta(22, "C) Se battre, Egalité, Gagner", "n");
			t.inserirResposta(22, "D) Se battre, Conquérir, Gagner", "n");
			t.inserirResposta(22, "E) Liberté, Egalité, Fraternité", "s");
		}else if(controle == 40){
			t.inserirResposta(23, "A) Balança comercial favorável, protecionismo e metalismo", "s");
			t.inserirResposta(23, "B) Ausências do estado, combate ao monopólio e acumulo de metais preciosos", "n");
			t.inserirResposta(23, "C) Protecionismo, interferência estatal e ausência de acumulo de metais preciosos", "n");
			t.inserirResposta(23, "D) Combate ao monopólio, protecionismo e empenho no acumulo de moeda", "n");
			t.inserirResposta(23, "E) Protecionismo, metalismo e ausência estatal", "n");
		}else if(controle == 41){
			t.inserirResposta(24, "A) A perspectiva tridimensional e a pintura a óleo", "s");
			t.inserirResposta(24, "B) Pinturas referente a vida de santos e o nu", "n");
			t.inserirResposta(24, "C) O retrato e o estilo românico na arquitetura", "n");
			t.inserirResposta(24, "D) A influência da arte bizantina e árabe", "n");
			t.inserirResposta(24, "E) As alegorias mitológicas e o mosaico", "n");
		}else if(controle == 42){
			t.inserirResposta(25, "A) Rigidez econômica com Estados e Municípios", "n");
			t.inserirResposta(25, "B) Recuperação da Receita", "n");
			t.inserirResposta(25, "C) Ajustes nos bancos estaduais", "n");
			t.inserirResposta(25, "D) Corte de gastos públicos", "n");
			t.inserirResposta(25, "E) A estatização de empresas privadas", "s");
		}else if(controle == 43){
			t.inserirResposta(26, "A) Propiciou a chegada dos mencheviques ao poder", "n");
			t.inserirResposta(26, "B) Propiciou a chegada dos bolcheviques ao poder", "s");
			t.inserirResposta(26, "C) Levou o soviete de Petrogrado a derrubar o czar Nicolau II", "n");
			t.inserirResposta(26, "D) Deu início a segunda nação socialista do planeta", "n");
			t.inserirResposta(26, "E) Teve como principal líder Léon Trótski", "n");
		}else if(controle == 44){
			t.inserirResposta(27, "A) Foi um movimento liberal para a difusão do capitalismo", "n");
			t.inserirResposta(27, "B) Foi um movimento contra a Revolução Industrial, onde manifestantes destruíam máquinas", "s");
			t.inserirResposta(27, "C) Foi um movimento contra a difusão do pensamento marxista", "n");
			t.inserirResposta(27, "D) Foi um movimento que protestava contra a expansão do estado", "n");
			t.inserirResposta(27, "E) Foi um movimento que empresários se reuniam para planejar expansão dos negócios", "n");
		}else if(controle == 45){
			t.inserirResposta(28, "A) FARC", "n");
			t.inserirResposta(28, "B) Al Qaeda", "s");
			t.inserirResposta(28, "C) Talibã", "n");
			t.inserirResposta(28, "D) ETA", "n");
			t.inserirResposta(28, "E) Estado Islâmico", "n");
		}else if(controle == 46){
			t.inserirResposta(29, "A) Da cidade de Guernica bombardeada pela aviação alemã em apoio ao general Franco", "s");
			t.inserirResposta(29, "B) Das cidades espanholas pelo General Franco contra os republicanos", "n");
			t.inserirResposta(29, "C) Das vilas espanholas pelas tropas nazistas durante a Segunda Guerra Mundial", "n");
			t.inserirResposta(29, "D) Da cidade de Guernica, pelos republicanos contra o governo do General Franco", "n");
			t.inserirResposta(29, "E) Das cidades espanholas pelos nazistas durante a Segunda Guerra Mundial", "n");
		}else if(controle == 47){
			t.inserirResposta(30, "A) Do ambiente de instabilidade bélica no leste europeu", "n");
			t.inserirResposta(30, "B) Do fracasso na aplicação prática do composto atômico posto em teste", "n");
			t.inserirResposta(30, "C) Do comportamento inesperado de um dos reatores", "s");
			t.inserirResposta(30, "D) De um equívoco diplomático", "n");
			t.inserirResposta(30, "E) Do rompimento da câmara de contenção por elevação da potência", "n");
		}else if(controle == 48){
			t.inserirResposta(31, "A) José da Costa Carvalho", "n");
			t.inserirResposta(31, "B) Pedro de Araújo Lima (Marquês de Olinda)", "n");
			t.inserirResposta(31, "C) Diogo Feijó", "s");
			t.inserirResposta(31, "D) Sebastião José de Carvalho e Melo (Marquês de Pombal)", "n");
			t.inserirResposta(31, "E) José Bonifácio", "n");
		}else if(controle == 49){
			t.inserirResposta(32, "A) Pernambuco, Bahia, Paraíba, Ceará e Maranhão", "n");
			t.inserirResposta(32, "B) Amazonas, Pará, Amapá, Roraima e Rondônia", "s");
			t.inserirResposta(32, "C) São Paulo, Rio de Janeiro, Santa Catarina, Minas Gerais", "n");
			t.inserirResposta(32, "D) Rio Grande do Sul, Paraná, São Paulo, Minas Gerais e a região da Cisplatina", "n");
			t.inserirResposta(32, "E) Mato Grosso, Mato Grosso do Sul, Piauí, Pernambuco e Bahia", "n");
		}else if(controle == 50){
			t.inserirResposta(33, "A) Holanda e França", "s");
			t.inserirResposta(33, "B) França e Espanha", "n");
			t.inserirResposta(33, "C) Espanha e Inglaterra", "n");
			t.inserirResposta(33, "D) Holanda e Espanha", "n");
			t.inserirResposta(33, "E) França e Inglaterra", "n");
		}else if(controle == 51){
			t.inserirResposta(34, "A) Absoluto", "n");
			t.inserirResposta(34, "B) Moderador", "s");
			t.inserirResposta(34, "C) Régio", "n");
			t.inserirResposta(34, "D) Patriarcal", "n");
			t.inserirResposta(34, "E) Hierárquico", "n");
		}else if(controle == 52){
			t.inserirResposta(35, "A) Foi marcado pela extinção do poder moderador", "s");
			t.inserirResposta(35, "B) Foi marcado pelas leis graduais de abolição da escravidão", "n");
			t.inserirResposta(35, "C) Foi marcado pelo tráfico transatlântico de escravos", "n");
			t.inserirResposta(35, "D) Foi marcado pela expansão da cafeicultura", "n");
			t.inserirResposta(35, "E) Foi marcado pelo revezamento dos partidos conservadores e liberais, no poder", "n");
		}else if(controle == 53){
			t.inserirResposta(36, "A) Deposição", "s");
			t.inserirResposta(36, "B) Renúncia", "n");
			t.inserirResposta(36, "C) Suicídio", "n");
			t.inserirResposta(36, "D) Fim do mandato", "n");
			t.inserirResposta(36, "E) Morte natural", "n");
		}

	}
	
}

