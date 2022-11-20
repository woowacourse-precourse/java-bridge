package bridge;

import bridge.constant.Message;
import bridge.controller.BridgeGame;

public class Application {

    public static void main(String[] args) {
        System.out.println(Message.GAME_START.getMessage());
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.play();
    }
}
