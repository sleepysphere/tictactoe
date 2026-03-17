package PrEx.Wone.TicTacToe;

public class InitializeTable {
    int[][] GameTable = new int[3][3];

    public InitializeTable() {
        // intialize the game table with 0s, 1 for player, 2 for machine
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                GameTable[i][j] = 0;
            }
        }
    }
}
