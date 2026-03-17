package PrEx.Wone.TicTacToe;

import java.util.Scanner;

public class GameLogic {

    public static void GameRun() {
        // System.out.println("\n### Line check init\n");
        int linecheck_loop = 0;
        System.out.println("THE TIC TAC TOE GAME\n");
        System.out.println("Press 1 to go first, 2 to go second\n");
        InitializeTable table = new InitializeTable(); // initialize the game, dont touch InitializeTable.java
        GameStatus status = new GameStatus(); // check the game status
        Scanner scanner = new Scanner(System.in);
        int turns = scanner.nextInt(); // check who goes first, 1 for player, 2 for machine
        // System.out.println("\n### Line check no1\n");
        while (true) {
            if (turns % 2 == 1) {
                System.out.println("You are going first, you are X\n");
                break;
            } else if (turns % 2 == 0) {
                System.out.println("You are going second, you are O\n");
                break;
            } else {
                System.out.println("Invalid choice, please enter 1 or 2\n");
                turns = scanner.nextInt();
            }
        }
        // System.out.println("\n### Line check no2\n");
        while (true) {
            System.out.println("\nTURNS: " + (++linecheck_loop) + "\n");
            // print the game table
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (table.GameTable[i][j] == 0) {
                        System.out.print("- ");
                    } else if (table.GameTable[i][j] == 1) {
                        System.out.print("X ");
                    } else if (table.GameTable[i][j] == 2) {
                        System.out.print("O ");
                    }
                }
                System.out.println();
            }

            if (turns % 2 == 1) { // player goes first
                System.out.println("Enter your move (1-9):\n");
                int position = scanner.nextInt();
                Move move = new Move(position);
                if (table.GameTable[move.row][move.col] == 0) { // check if the move is valid
                    table.GameTable[move.row][move.col] = 1; // player move
                    turns++; // increment turns
                } else {
                    System.out.println("Invalid move, try again\n");
                    continue;
                }
            } else if (turns % 2 == 0) { // machine goes first
                MachineMove machineMove = new MachineMove();
                machineMove.CompMove(table);
                turns++; // increment turns
            }
            int gameStatus = status.winCondition(table.GameTable); // check for win condition
            if (gameStatus == 1) {
                System.out.println("You win!\n");
                // print the game table
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (table.GameTable[i][j] == 0) {
                            System.out.print("- ");
                        } else if (table.GameTable[i][j] == 1) {
                            System.out.print("X ");
                        } else if (table.GameTable[i][j] == 2) {
                            System.out.print("O ");
                        }
                    }
                    System.out.println();
                }
                scanner.close();
                break;
            } else if (gameStatus == 2) {
                System.out.println("Machine wins!\n");
                // print the game table
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (table.GameTable[i][j] == 0) {
                            System.out.print("- ");
                        } else if (table.GameTable[i][j] == 1) {
                            System.out.print("X ");
                        } else if (table.GameTable[i][j] == 2) {
                            System.out.print("O ");
                        }
                    }
                    System.out.println();
                }
                scanner.close();
                break;
            } else if (gameStatus == 0) {
                boolean draw = true;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (table.GameTable[i][j] == 0) { // this loop check if all boxes are filled or not
                            draw = false;
                            break;
                        }
                    }
                }
                if (draw) { // if all are filled and wincon = 0, then its a draw
                    System.out.println("It's a draw!\n");
                    // print the game table
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (table.GameTable[i][j] == 0) {
                                System.out.print("- ");
                            } else if (table.GameTable[i][j] == 1) {
                                System.out.print("X ");
                            } else if (table.GameTable[i][j] == 2) {
                                System.out.print("O ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                }
            }
        }
    }
}
