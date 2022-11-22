package bridge;

public class BridgeMachine {
    private int totalTry = 1;
    private int index = 0;
    private boolean success = false;


    private Bridge validateBridge() {
        Bridge bridge;
        OutputView.inputBridgeSize();
        String bridgeSize = InputView.readBridgeSize();
        bridge = new Bridge(bridgeSize);
        return bridge;
    }

    private void printAfterGame(Bridge bridge) {
        OutputView.printLastBridgeResult();
        OutputView.printMap(bridge.getBridgeMap(), index);
        printGameResult();
        OutputView.printTotalTry(totalTry);
    }

    private void printGameResult() {
        if (success == GameResult.FAILED.getTrueOrFalse()) {
            OutputView.printResult(GameResult.FAILED);
        }
        if (success == GameResult.PASSED.getTrueOrFalse()) {
            OutputView.printResult(GameResult.PASSED);
        }
    }
}
