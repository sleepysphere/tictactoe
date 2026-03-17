package PrEx.Wone.TicTacToe;

public class MachineMove {
    // move on it turns, picks the first empty square it sees
    public int CompMove(InitializeTable table) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table.GameTable[i][j] == 0) {
                    table.GameTable[i][j] = 2;
                    return 2;
                }
            }
        }
        return 0;
    }
}
