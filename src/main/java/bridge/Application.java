package bridge;

import bridge.controller.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        outputView.printStart();
        bridgeGame.setBridge(readBridgeSize());
        do {
            bridgeGame.reset();
            playGame();
        } while (isFinishProgram());

        outputView.printResult(bridgeGame.getGameStatus(), bridgeGame.printMap());
    }

    private static void playGame() {
        do {
            bridgeGame.move(readMoveCommand());
            outputView.printMap(bridgeGame.printMap());
        } while (!bridgeGame.isFinish());
    }

    private static boolean isFinishProgram() {
        if (bridgeGame.isResult()) {
            return false;
        }
        return bridgeGame.retry(readRetryCommand());
    }

    private static String readRetryCommand() {
        outputView.printInputMessageRetryCommand();
        return inputView.readGameCommand();
    }

    private static String readMoveCommand() {
        outputView.printInputMessageMoveCommand();
        return inputView.readMoving();
    }

    private static int readBridgeSize() {
        outputView.printInputMessageBridgeLength();
        return inputView.readBridgeSize();
    }
}