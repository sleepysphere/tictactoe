package PrEx.Wone.TicTacToe;

public class MachineMove extends Move {

    // move on it turns, picks the first empty square it sees
    public MachineMove(Table table) {
        super(-1, -1);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table.isEmpty(i, j)) {
                    row = i;
                    col = j;
                    return;
                }
            }
        }
    }
}
