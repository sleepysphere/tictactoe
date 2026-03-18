package PrEx.Wone.TicTacToe;

public class App {
    public static void main(String[] args) {
        GameLogic game = new GameLogic();

        game.GameRun(Integer.parseInt(args[0]));
    }
}
