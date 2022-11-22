package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        outputView.printGreeting();
        BridgeGame bridgeGame = initialize(inputView, outputView);
        do {
            moveUntilGameOverCondition(inputView, outputView, bridgeGame);
        } while (checkRetryCondition(inputView, outputView, bridgeGame));
        outputView.printResult(bridgeGame);
    }

    private static void moveUntilGameOverCondition(InputView inputView, OutputView outputView,
            BridgeGame bridgeGame) {
        while (bridgeGame.getGameStatus().equals(GameStatus.ONGOING)) {
            try {
                move(inputView, outputView, bridgeGame);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void move(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        outputView.printMoveInputMessage();
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.getUserPath(), bridgeGame.getGameStatus());
    }

    private static boolean checkRetryCondition(InputView inputView, OutputView outputView,
            BridgeGame bridgeGame) {
        if (bridgeGame.getGameStatus().equals(GameStatus.LOSE)) {
            if (checkRetryCommand(inputView, outputView)) {
                bridgeGame.retry();
                return true;
            }
        }
        return false;
    }

    private static boolean checkRetryCommand(InputView inputView, OutputView outputView) {
        do {
            try {
                outputView.printRetryInputMessage();
                return inputView.readGameCommand().equals("R");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private static BridgeGame initialize(InputView inputView, OutputView outputView) {
        do {
            try {
                return new BridgeGame(makeBridge(inputView, outputView));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private static List<String> makeBridge(InputView inputView, OutputView outputView) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        outputView.printBridgeSizeInputMessage();
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        outputView.printEmptyLine();
        return bridge;
    }
}
