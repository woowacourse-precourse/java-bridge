package bridge;

import java.util.List;

public class Application {

    private static InputView inputView;
    private static OutputView outputView;
    private static BridgeMaker bridgeMaker;
    private static BridgeGame bridgeGame;
    private static int bridgeSize;

    private static boolean crossingBridge() {
        boolean moveResult = true;

        for (int i = 0; i < bridgeSize && moveResult; i++) {
            String moving = inputView.readMoving();
            moveResult = bridgeGame.move(moving);
            outputView.printMap(bridgeGame.getMap());
        }
        return moveResult;
    }

    private static void validateRetryCommand(String cmd) {
        Validator validator = new Validator();
        validator.validateCommand(cmd);
    }

    private static boolean retryGame(String cmd) {
        validateRetryCommand(cmd);
        if (cmd.equals("Q")) {
            return false;
        }
        bridgeGame.retry();
        return gamePlay();
    }

    private static boolean gamePlay() {
        boolean isCrossing = crossingBridge();

        if (isCrossing) {
            return true;
        }
        String cmd = inputView.readGameCommand();
        return retryGame(cmd);
    }

    private static void initBridge() {
        bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(new BridgeStatus(bridge));
    }

    private static void initGame() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        outputView.printStartMsg();
        initBridge();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            initGame();
            boolean gameResult = gamePlay();
            outputView.printResult(bridgeGame, gameResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
