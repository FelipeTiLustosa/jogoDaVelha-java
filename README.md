# Jogo da Velha Inteligente

Este projeto implementa um jogo da velha onde o jogador humano joga contra um computador com uma lógica de movimentos predefinida. O computador faz movimentos inteligentes, seguindo regras específicas para maximizar suas chances de vencer.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

```bash
/JogoDaVelha
│
├── /src
│   ├── /application
│   │   └── Main.java        # Classe principal que inicia o jogo
│   ├── /entities
│   │   ├── AI.java          # Contém a lógica de inteligência artificial
│   │   └── Game.java        # Gerencia o tabuleiro e andamento do jogo
```
## Regras do Jogo

- **O computador sempre começa e joga como 'X'.**
- **O computador segue estas regras para decidir seus movimentos:**
  - **Movimento 1:** O computador escolhe um canto aleatoriamente.
  - **Movimento 2:** Se o jogador não ocupou o canto oposto, o computador o ocupa. Caso contrário, escolhe outro canto livre.
  - **Movimento 3 em diante:** O computador verifica se pode vencer completando uma linha ou se precisa bloquear o jogador, priorizando esses movimentos. Se não houver necessidade, escolhe um canto livre ou outro espaço.

## Funcionalidades

Abaixo estão listadas as funcionalidades do jogo, organizadas em uma tabela para melhor visualização:

| Funcionalidade                          | Descrição                                                                                     |
|-----------------------------------------|-----------------------------------------------------------------------------------------------|
| **Jogo Humano vs Computador**           | Jogo funcional com o jogador humano enfrentando o computador.                                 |
| **Inteligência Artificial**             | Implementação de uma IA básica com estratégia definida para maximizar as chances de vitória.  |
| **Verificação de Vitória**              | O jogo verifica automaticamente se houve vitória ou empate após cada jogada.                  |
| **Movimentos Inteligentes do Computador** | A IA faz movimentos inteligentes, seguindo regras específicas para ganhar ou bloquear o humano.|

## Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/jogo-da-velha.git
   ```
## Como Executar

Compile e execute o projeto usando sua IDE Java preferida ou o terminal.
## Interfarce do jogo
<p align="center">
  <img src="https://github.com/user-attachments/assets/3096ce6e-2031-41f2-a1bd-e93bb01ce9f5" alt="Captura de tela" style="border-radius: 15px;"/>
</p>

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.

## Licença

Este projeto está licenciado sob a MIT License.

## Autor

Criado por Seu Felipe Lustosa Carvalho.


