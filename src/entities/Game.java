package entities;

import java.util.Scanner;

public class Game {

	
	private char[][] tabuleiro;
	private AI ai;
	private Scanner sc;
	private char vencedor;
	
	// Esquema de funcionamento do tabuleiro: 
	/*
	 *  0          1          2
	0 (0,0)  |   (0,1)  |   (0,2)
      -------|----------|--------
	1 (1,0)  |   (1,1)  |   (1,2)
      -------|----------|--------
	2 (2,0)  |   (2,1)  |   (2,2)


 	1 | 2 | 3 
 	4 | 5 | 6 
 	7 | 8 | 9 */
	
	public Game() {
        this.tabuleiro = new char[3][3];
        this.ai = new AI();
        this.sc = new Scanner(System.in);
        preencheJG();
        start();
	}

	public void preencheJG() {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				tabuleiro[i][j]=' ';
			}
		}
	}
	
	public void mostraEstadoTabu() {
	    System.out.println("");
	    System.out.println("                    1 | 2 | 3 ");
	    System.out.println("                   -----------");
	    System.out.println("                    4 | 5 | 6 ");
	    System.out.println("                   -----------");
	    System.out.println("                    7 | 8 | 9 ");
	    System.out.println("");
	    System.out.println("                   -----------");
	    System.out.println("");
	    
	    for (int i = 0; i < tabuleiro.length; i++) {
	        System.out.print("                   ");
	        for (int j = 0; j < tabuleiro[i].length; j++) {
	            System.out.print(" " + tabuleiro[i][j] + " ");
	            if (j < tabuleiro[i].length - 1) {
	                System.out.print("|");
	            }
	        }
	        System.out.println("");
	        if (i < tabuleiro.length - 1) {
	            System.out.println("                   -----------");
	        }
	    }
	    System.out.println("");
	    System.out.println("");
	}


	
	public void fazJogada(int local, char jogadorAtual) {
        int linha;
        int coluna;
        switch (local) {
            case 1: {
                linha = 0;
                coluna = 0;
                break;
            }
            case 2: {
                linha = 0;
                coluna = 1;
                break;
            }
            case 3: {
                linha = 0;
                coluna = 2;
                break;
            }
            case 4: {
                linha = 1;
                coluna = 0;
                break;
            }
            case 5: {
                linha = 1;
                coluna = 1;
                break;
            }
            case 6: {
                linha = 1;
                coluna = 2;
                break;
            }
            case 7: {
                linha = 2;
                coluna = 0;
                break;
            }
            case 8: {
                linha = 2;
                coluna = 1;
                break;
            }
            case 9: {
                linha = 2;
                coluna = 2;
                break;
            }
            default:
                throw new IllegalArgumentException("Valor inesperado: " + local);
        }

        if (tabuleiro[linha][coluna] == ' ') {
            tabuleiro[linha][coluna] = jogadorAtual;
        } else {
            System.out.println("Posição ocupada. Escolha outra posição.");
        }
    }
	
	//Forma alternativa de fazer o verifica vitoria
	/*public boolean verificaVitoria(char[][] tabuleiro) {
	    // linhas
	    for (int i = 0; i < tabuleiro.length; i++) {
	        int contX = 0;
	        int contO = 0;
	        for (int j = 0; j < tabuleiro[i].length; j++) {
	            if (tabuleiro[i][j] == 'X') {
	                contX++;
	            } else if (tabuleiro[i][j] == 'O') {
	                contO++;
	            }
	        }
	        if (contX == 3 || contO == 3) {
	            return true;
	        }
	    }

	    // colunas
	    for (int j = 0; j < tabuleiro[0].length; j++) {
	        int contX = 0;
	        int contO = 0;
	        for (int i = 0; i < tabuleiro.length; i++) {
	            if (tabuleiro[i][j] == 'X') {
	                contX++;
	            } else if (tabuleiro[i][j] == 'O') {
	                contO++;
	            }
	        }
	        if (contX == 3 || contO == 3) {
	            return true;
	        }
	    }

	    // diagonal principal
	    int contX = 0;
	    int contO = 0;
	    for (int i = 0; i < tabuleiro.length; i++) {
	        if (tabuleiro[i][i] == 'X') {
	            contX++;
	        } else if (tabuleiro[i][i] == 'O') {
	            contO++;
	        }
	    }
	    if (contX == 3 || contO == 3) {
	        return true;
	    }

	    // diagonal secundária
	    contX = 0;
	    contO = 0;
	    for (int i = 0; i < tabuleiro.length; i++) {
	        if (tabuleiro[i][tabuleiro.length - 1 - i] == 'X') {
	            contX++;
	        } else if (tabuleiro[i][tabuleiro.length - 1 - i] == 'O') {
	            contO++;
	        }
	    }
	    if (contX == 3 || contO == 3) {
	        return true;
	    }

	    return false; 
	}*/

	public boolean verificaVitoria(char[][] tabuleiro) {
        // Verifica linhas
        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i][0] != ' ' && tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                vencedor=tabuleiro[i][0];
            	return true;
            }
        }
        // Verifica colunas
        for (int j = 0; j < tabuleiro[0].length; j++) {
            if (tabuleiro[0][j] != ' ' && tabuleiro[0][j] == tabuleiro[1][j] && tabuleiro[1][j] == tabuleiro[2][j]) {
            	vencedor=tabuleiro[0][j];
            	return true;
            }
        }
        // Verifica diagonal principal
        if (tabuleiro[0][0] != ' ' && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
        	vencedor=tabuleiro[0][0];
        	return true;
        }
        // Verifica diagonal secundária
        if (tabuleiro[0][2] != ' ' && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
        	vencedor=tabuleiro[0][2];
        	return true;
        }
        return false;
    }
	   
	public void play_O() {
        int posicao;
        boolean jogadaValida = false;
        while (!jogadaValida) {
            mostraEstadoTabu();
            System.out.println("========================================================");
            System.out.print("Escolha uma vaga que não foi preenchida de (1-9): ");
            posicao = sc.nextInt();
            System.out.println("========================================================");
            if (posicao >= 1 && posicao <= 9) {
                int linha = (posicao - 1) / 3;
                int coluna = (posicao - 1) % 3;
                if (tabuleiro[linha][coluna] == ' ') {
                    fazJogada(posicao, 'O');
                    jogadaValida = true;
                } else {
                    System.out.println("Posição ocupada. Escolha outra posição.");
                    System.out.println("========================================================");
                }
            } else {
                System.out.println("Posição inválida. Escolha um número entre 1 e 9.");
                System.out.println("========================================================");
            }
        }
    }

	
	public void start() {
        preencheJG();
        mostraEstadoTabu();
        ai.mov01(tabuleiro);

        while (!verificaVitoria(tabuleiro) && !tabuleiroCheio(tabuleiro)) {
            play_O();
            if (verificaVitoria(tabuleiro) || tabuleiroCheio(tabuleiro)) break;
            ai.mov02(tabuleiro);
            if (verificaVitoria(tabuleiro) || tabuleiroCheio(tabuleiro)) break;
            play_O();
            if (verificaVitoria(tabuleiro) || tabuleiroCheio(tabuleiro)) break;
            ai.mov03(tabuleiro);
            if (verificaVitoria(tabuleiro) || tabuleiroCheio(tabuleiro)) break;
            play_O();
            if (verificaVitoria(tabuleiro) || tabuleiroCheio(tabuleiro)) break;
            ai.mov04(tabuleiro);
            if (verificaVitoria(tabuleiro) || tabuleiroCheio(tabuleiro)) break;
            play_O();
            if (verificaVitoria(tabuleiro) || tabuleiroCheio(tabuleiro)) break;
            ai.mov05(tabuleiro);
        }

        mostraEstadoTabu();
        if (verificaVitoria(tabuleiro)) {
        	System.out.println("========================================================");
            System.out.printf("Jogo terminou com vitória! Vencendo  %s %n",vencedor);
            System.out.println("========================================================");
        } else {
        	System.out.println("========================================================");
            System.out.println("Jogo terminou em empate!");
            System.out.println("========================================================");
        }
        char continua;
    	System.out.println("========================================================");
    	System.out.print("Deseja jogar novamente? S para sim e N para não (S/N): ");
        continua=sc.next().charAt(0);
        System.out.println("========================================================");
        while (continua=='S' || continua=='s') {
			start();
			break;
		}
        System.out.printf("%nSaindo .....");
        }

    private boolean tabuleiroCheio(char[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}