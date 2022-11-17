package bridge;

import bridge.constant.Message;
import bridge.controller.Game;

public class Application {

    public static void main(String[] args) {
        System.out.println(Message.GAME_START.getMessage());
        Game game = new Game();
        game.play();
    }
}
