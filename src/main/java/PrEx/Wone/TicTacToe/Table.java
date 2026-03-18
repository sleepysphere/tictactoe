package PrEx.Wone.TicTacToe;

public class Table {

    private int[][] gameTable = new int[3][3];

    // Constructor
    public Table() {
        // intialize the game table with 0s
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameTable[i][j] = 0;
            }
        }
    }

    public boolean playMove(Move move, int value) {
        if (isValidMove(move)) { // check if the move is valid
            gameTable[move.getRow()][move.getCol()] = value; // player move
            return true;
        } else {
            System.out.println("Invalid move, try again\n");
            return false;
        }
    }

    public boolean isValidMove(Move move) {
        if (move.getRow() < 0 || move.getRow() > 2 || move.getCol() < 0 || move.getCol() > 2) {
            return false;
        }

        if (gameTable[move.getRow()][move.getCol()] == 0) {
            return true;
        }
        return false;
    }

    public int checkWin() {
        // this is the rows
        for (int i = 0; i < 3; i++) {
            if (gameTable[i][0] == gameTable[i][1] && gameTable[i][1] == gameTable[i][2] && gameTable[i][0] != 0) {
                return gameTable[i][0];
            }
        }

        // this is the columns
        for (int j = 0; j < 3; j++) {
            if (gameTable[0][j] == gameTable[1][j] && gameTable[1][j] == gameTable[2][j] && gameTable[0][j] != 0) {
                return gameTable[0][j];
            }
        }

        // downward diagonal
        if (gameTable[0][0] == gameTable[1][1] && gameTable[1][1] == gameTable[2][2] && gameTable[0][0] != 0) {
            return gameTable[0][0];
        }

        // upward diagonal
        if (gameTable[0][2] == gameTable[1][1] && gameTable[1][1] == gameTable[2][0] && gameTable[0][2] != 0) {
            return gameTable[0][2];
        }

        return 0;
    }

    public boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public void printTable() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable[i][j] == 0) {
                    System.out.print("- ");
                } else if (gameTable[i][j] == 1) {
                    System.out.print("X ");
                } else if (gameTable[i][j] == 2) {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    public boolean isEmpty(int i, int j) {
        return gameTable[i][j] == 0;
    }

}
