package aplication;

import entities.Game;

public class main {

	public static void main(String[] args) {
		/*Considere um jogo da velha no qual um humano deverá comecaJogo contra um computador (papel inteligente).
		Diante disso leia as regras definidas pelo papel inteligente apresentadas a seguir:
		Eu sou um pedaço de papel altamente inteligente.
		Vamos comecaJogo jogo da velha.

		Eu sou X e começo.

		Movimento 1: Vá em um canto.

		Movimento 2:
		SE o outro jogador não foi lá
		ENTÃO vá no canto oposto ao movimento 1.
		SENÃO vá em um canto livre.

		Movimento 3:
		SE houver 2 Xs e um espaço em uma linha
		ENTÃO vá nesse espaço.
		SENÃO, SE houver 2 Os e um espaço em uma linha
		ENTÃO vá nesse espaço.
		SENÃO vá em um canto livre.

		Movimento 4:
		SE houver 2 Xs e um espaço em uma linha
		ENTÃO vá nesse espaço.
		SENÃO, SE houver 2 Os e um espaço em uma linha
		ENTÃO vá nesse espaço.
		SENÃO vá em um canto livre.

		Movimento 5: Vá no espaço livre. */
		new Game();

	}

}
