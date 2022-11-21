package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView Input = new InputView();
        Input.readBridgeSize();
        Input.readMoving();
        Input.readGameCommand();
    }
}
