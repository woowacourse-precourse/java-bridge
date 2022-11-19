package bridge;

import java.util.List;

public class Application {

    static OutputView outputView = new OutputView();
    static InputView inputView = new InputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame(inputView, outputView);
        bridgeGame.start();
    }

    private static void move(int bridgeSize) {
        for (int i = 0; i < bridgeSize; ++i) {
            String moveDirection = getMoveDirectionInput();
        }
    }

    private static String getMoveDirectionInput() {
        String moveDirection;
        while (true) {
            try {
                moveDirection = inputView.readMoving();
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
        return moveDirection;
    }
}
