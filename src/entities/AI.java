
package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI {

	
    private int[] ultimoMovimento; 

    public int[] mov01(char[][] tabuleiro) {
        Random rand = new Random();
        int[][] cantos = {{0, 0}, {0, 2}, {2, 0}, {2, 2}};
        int index = rand.nextInt(cantos.length);
        int linha = cantos[index][0];
        int coluna = cantos[index][1];

        if (tabuleiro[linha][coluna] == ' ') {
            tabuleiro[linha][coluna] = 'X';
            ultimoMovimento = new int[]{linha, coluna};
            return ultimoMovimento;
        } else {
            return mov01(tabuleiro);
        }

    }

    public void mov02(char[][] tabuleiro) {
        if (ultimoMovimento == null) {
            return; // Se não houve movimento anterior, não há o que fazer
        }

        int linha = ultimoMovimento[0];
        int coluna = ultimoMovimento[1];

        if (linha == 0 && coluna == 0 && tabuleiro[0][2] == ' ') {
            tabuleiro[0][2] = 'X';
            ultimoMovimento = new int[]{0, 2};
        } else if (linha == 0 && coluna == 2 && tabuleiro[0][0] == ' ') {
            tabuleiro[0][0] = 'X';
            ultimoMovimento = new int[]{0, 0};
        } else if (linha == 2 && coluna == 0 && tabuleiro[2][2] == ' ') {
            tabuleiro[2][2] = 'X';
            ultimoMovimento = new int[]{2, 2};
        } else if (linha == 2 && coluna == 2 && tabuleiro[2][0] == ' ') {
            tabuleiro[0][0] = 'X';
            ultimoMovimento = new int[]{2, 0};
        } else {
        	movParaCantoLivreAleatorio(tabuleiro);
            
        }
    }
    
    	public void movParaCantoLivreAleatorio(char[][] tabuleiro) {
        Random rand = new Random();
        int[][] cantos = {{0, 0}, {0, 2}, {2, 0}, {2, 2}};
        List<int[]> cantosLivres = new ArrayList<>();

        for (int[] canto : cantos) {
            int linha = canto[0];
            int coluna = canto[1];
            if (tabuleiro[linha][coluna] == ' ') {
                cantosLivres.add(canto);
            }
        }

        if (!cantosLivres.isEmpty()) {
            int[] cantoLivre = cantosLivres.get(rand.nextInt(cantosLivres.size()));
            tabuleiro[cantoLivre[0]][cantoLivre[1]] = 'X';
        } else {
            System.out.println("Não há espaço livre no tabuleiro.");
        }
    }

    public void lugaresLivres(char[][] tabuleiro) {
        Random rand = new Random();
        int[][] lugares = {
            {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2}
        };

        List<Integer> posicoesLivres = new ArrayList<>();

        for (int i = 0; i < lugares.length; i++) {
            int linha = lugares[i][0];
            int coluna = lugares[i][1];
            if (tabuleiro[linha][coluna] == ' ') {
                posicoesLivres.add(i);
            }
        }

        if (!posicoesLivres.isEmpty()) {
            int pos = posicoesLivres.get(rand.nextInt(posicoesLivres.size()));
            int linha = lugares[pos][0];
            int coluna = lugares[pos][1];
            tabuleiro[linha][coluna] = 'X';
            ultimoMovimento = new int[]{linha, coluna};
        } else {
            System.out.println("Não há espaço livre no tabuleiro.");
        }
    }
    
    public void mov03(char[][] tabuleiro) {
        // Verifica linhas
        for (int i = 0; i < tabuleiro.length; i++) {
            int quantX = 0;
            int quantO = 0;
            int quantSpace = 0;
            int linha = -1;
            int coluna = -1;

            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == 'X') {
                    quantX++;
                } else if (tabuleiro[i][j] == 'O') {
                    quantO++;
                } else if (tabuleiro[i][j] == ' ') {
                    quantSpace++;
                    linha = i;
                    coluna = j;
                }
            }

            if (quantX == 2 && quantSpace == 1) {
                tabuleiro[linha][coluna] = 'X';
                return; 
            }
            if (quantO == 2 && quantSpace == 1) {
            	tabuleiro[linha][coluna] = 'X';
                return; 
			}
        }

        // Verifica colunas
        for (int j = 0; j < tabuleiro[0].length; j++) {
            int quantX = 0;
            int quantO = 0;
            int quantSpace = 0;
            int linha = -1;
            int coluna = -1;

            for (int i = 0; i < tabuleiro.length; i++) {
                if (tabuleiro[i][j] == 'X') {
                    quantX++;
                } else if (tabuleiro[i][j] == 'O') {
                    quantO++;
                } else if (tabuleiro[i][j] == ' ') {
                    quantSpace++;
                    linha = i;
                    coluna = j;
                }
            }

            if (quantX == 2 && quantSpace == 1) {
                tabuleiro[linha][coluna] = 'X';
                return;
            }
            if (quantO == 2 && quantSpace == 1) {
            	tabuleiro[linha][coluna] = 'X';
                return; 
			}
        }

        // Verifica diagonal principal
        int quantXDiagPrincipal = 0;
        int quantODiagPrincipal = 0;
        int quantSpaceDiagPrincipal = 0;
        int linhaDiagPrincipal = -1;
        int colunaDiagPrincipal = -1;

        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i][i] == 'X') {
                quantXDiagPrincipal++;
            } else if (tabuleiro[i][i] == 'O') {
                quantODiagPrincipal++;
            } else if (tabuleiro[i][i] == ' ') {
                quantSpaceDiagPrincipal++;
                linhaDiagPrincipal = i;
                colunaDiagPrincipal = i;
            }
        }

        if (quantXDiagPrincipal == 2 && quantSpaceDiagPrincipal == 1) {
            tabuleiro[linhaDiagPrincipal][colunaDiagPrincipal] = 'X';
            return;
        } else if (quantODiagPrincipal == 2 && quantSpaceDiagPrincipal == 1) {
            tabuleiro[linhaDiagPrincipal][colunaDiagPrincipal] = 'X';
            return;
        }

        // Verifica diagonal secundária
        int quantXDiagSecundaria = 0;
        int quantODiagSecundaria = 0;
        int quantSpaceDiagSecundaria = 0;
        int linhaDiagSecundaria = -1;
        int colunaDiagSecundaria = -1;

        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i][tabuleiro.length - 1 - i] == 'X') {
                quantXDiagSecundaria++;
            } else if (tabuleiro[i][tabuleiro.length - 1 - i] == 'O') {
                quantODiagSecundaria++;
            } else if (tabuleiro[i][tabuleiro.length - 1 - i] == ' ') {
                quantSpaceDiagSecundaria++;
                linhaDiagSecundaria = i;
                colunaDiagSecundaria = tabuleiro.length - 1 - i;
            }
        }

        if (quantXDiagSecundaria == 2 && quantSpaceDiagSecundaria == 1) {
            tabuleiro[linhaDiagSecundaria][colunaDiagSecundaria] = 'X';
            return;
        } else if (quantODiagSecundaria == 2 && quantSpaceDiagSecundaria == 1) {
            tabuleiro[linhaDiagSecundaria][colunaDiagSecundaria] = 'X';
            return;
        }

        // Canto livre
        int[][] cantosLivros= {{0,0},{0,2},{2,0},{2,2} };
        
        for (int[] cantos : cantosLivros) {
            int linha = cantos[0];
            int coluna = cantos[1];
            if (tabuleiro[linha][coluna]==' ') {
                tabuleiro[linha][coluna]='X';
                return;
            }
        }
    }

    public void mov04(char[][] tabuleiro) {
    	mov03(tabuleiro);
    }
    public void mov05(char[][] tabuleiro) {
    	lugaresLivres(tabuleiro);
    }
    
}