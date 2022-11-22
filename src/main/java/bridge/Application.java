package bridge;


import bridge.Controller.BridgeGame;
import bridge.Controller.ViewController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ViewController input = new ViewController();
        int bridgeSize = input.getBridgeSize();
        BridgeGame game = new BridgeGame(bridgeSize);
        game.move();
    }
}
