package bridge;


import bridge.Controller.BridgeGame;
import bridge.Controller.InputController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputController input = new InputController();
        BridgeGame game = new BridgeGame(input.getBridgeSize());
        game.move();
    }
}
