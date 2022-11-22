package bridge;

public class Application {

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        int size = InputController.checkSize(new InputView());
        BridgeGame game = new BridgeGame(size);
        game.play();
    }
}
