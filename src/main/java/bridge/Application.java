package bridge;

import message.InputMessage;

public class Application {
    private static int GAME_TRY = 1;

    private static InputMessage inputMessage;

    public static void main(String[] args) {
        Game game = new Game();
        try {
            while (game.run()) {
                GAME_TRY += 1;
            }
            inputMessage.gameOver("성공", GAME_TRY);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception);
        }
    }
}
