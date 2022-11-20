package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller(new OutputView(), new InputView());
        controller.startGame(new BridgeGame());
    }
}
