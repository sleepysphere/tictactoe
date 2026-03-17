package PrEx.Wone.TicTacToe;

public class Move {
    protected int row;
    protected int col;

    public Move(int position) { // position from 1 to 9, left to right, top to bottom
        // 1|2|3
        // 4|5|6
        // 7|8|9
        this.row = (position - 1) / 3;
        this.col = (position - 1) % 3;
        // check if the position is valid, if not, return -1 for both row and col
        if (position < 1 || position > 9) {
            this.row = -1;
            this.col = -1;
        }
    }
}
