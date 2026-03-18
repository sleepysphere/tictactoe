package PrEx.Wone.TicTacToe;

import java.util.Scanner;

public class GameLogic {

    private Table table = new Table();

    private int turns = 1;
    private int currentPlayer;
    private Scanner scanner = new Scanner(System.in);

    public void GameRun(int firstPlayer) {
        System.out.println("THE TIC TAC TOE GAME\n");

        currentPlayer = firstPlayer;

        if (currentPlayer % 2 == 1) {
            System.out.println("You are going first, you are X\n");
        } else if (currentPlayer % 2 == 0) {
            System.out.println("You are going second, you are O\n");
        }

        // Main Game Loop
        while (true) {
            System.out.println("\nTURNS: " + turns + "\n");
            table.printTable();

            playerMove();

            if (checkResults()) {
                scanner.close();
                return;
            }

            currentPlayer++;
            turns++;

        }
    }

    private void playerMove() {
        if (currentPlayer % 2 == 1) { // player goes first
            boolean isValidMove = false;

            while (!isValidMove) {
                System.out.println("Enter your move (1-9):\n");
                int position = scanner.nextInt();
                Move move = new Move(position);

                if (table.playMove(move, 1)) {
                    isValidMove = true;
                }
            }
        } else if (currentPlayer % 2 == 0) { // machine goes first
            MachineMove machineMove = new MachineMove(table);
            table.playMove(machineMove, 2);
        }
    }

    private boolean checkResults() {
        int gameStatus = table.checkWin();

        if (gameStatus == 1) {
            System.out.println("You win!\n");
            table.printTable();
            return true;
        } else if (gameStatus == 2) {
            System.out.println("Machine wins!\n");
            table.printTable();
            return true;
        } else if (gameStatus == 0) {
            if (table.checkDraw()) {
                System.out.println("It's a draw!\n");
                table.printTable();
                return true;
            }
        }

        return false;
    }
}
