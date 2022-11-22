package bridge;

public class BridgeMachine {
    private int totalTry = 1;
    private int index = 0;
    private boolean success = false;


    private String getUserCommand() {
        while (true) {
            try {
                OutputView.inputUserMoveCommand();
                return InputView.readMoving();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private boolean checkLastIndex(Bridge bridge) {
        if (index == bridge.getBridgeSize()) {
            success = true;
            index--;
            return true;
        }
        return false;
    }

    private Bridge getBridge() {
        while (true) {
            try {
                return validateBridge();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

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
