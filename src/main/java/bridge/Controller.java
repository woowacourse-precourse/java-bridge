package bridge;

public class Controller {

    BridgeGame game;
    BridgeMaker maker;
    InputView input;
    OutputView output;
    int userStatus;

    private final int RUNNING = 0;
    private final int WRONG = 1;
    private final int CORRECT = 2;

    Controller() {
        userStatus = RUNNING;
        game = new BridgeGame();
        input = new InputView();
        output = new OutputView();
        maker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    void init() {
        initialSet();
    }

    void initialSet() {
        String size = input.readBridgeSize();

    }



    void throwError(boolean condition, String message) {

    }
}
