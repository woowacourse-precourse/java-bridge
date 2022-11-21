package bridge;

public class Application {

    public static void main(String[] args) {
        InputView input = new InputView();
        int size = input.readBridgeSize();
        Bridge bridge = new Bridge(size);
        String direction = input.readMoving();
        BridgeGame game = new BridgeGame();

        game.move(direction);
    }
}
