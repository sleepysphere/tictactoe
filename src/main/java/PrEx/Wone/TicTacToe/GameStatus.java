package PrEx.Wone.TicTacToe;

public class GameStatus {
    // check the table for a win condition, return 0 if no win, 1 if player wins, 2
    // if machine wins
    protected int status = 0;

    public int winCondition(int GameTable[][]) {
        for (int i = 0; i < 3; i++) { // this is the rows
            if (GameTable[i][0] == GameTable[i][1] && GameTable[i][1] == GameTable[i][2] && GameTable[i][0] != 0) {
                status = GameTable[i][0];
            }
        }
        for (int j = 0; j < 3; j++) { // this is the columns
            if (GameTable[0][j] == GameTable[1][j] && GameTable[1][j] == GameTable[2][j] && GameTable[0][j] != 0) {
                status = GameTable[0][j];
            }
        }
        if (GameTable[0][0] == GameTable[1][1] && GameTable[1][1] == GameTable[2][2] && GameTable[0][0] != 0) {
            status = GameTable[0][0]; // downward diagonal
        }
        if (GameTable[0][2] == GameTable[1][1] && GameTable[1][1] == GameTable[2][0] && GameTable[0][2] != 0) {
            status = GameTable[0][2]; // upward diagonal
        }
        return status;
    }
}
