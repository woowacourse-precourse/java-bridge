package bridge;

import message.InputMessage;

public class Application {
    private static int GAME_TRY = 1;

    private static InputMessage inputMessage;
    private static InputView inputView = new InputView();


    public static void main(String[] args) {
        Game game = new Game();
        Bridge bridge = new Bridge(inputView.readBridgeSize());
        while (!game.run(bridge)) {
            GAME_TRY += 1;
        }
        inputMessage.gameOver("성공", GAME_TRY);
    }
}
