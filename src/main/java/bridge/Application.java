package bridge;

public class Application {

    public static void main(String[] args) {
        play();
        // TODO: 프로그램 구현
    }

    private static void play() {
        try {
            new InputView().readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
//        int size = InputController.checkSize(new InputView());
//        BridgeGame game = new BridgeGame(size);
//        game.play();
    }
}
