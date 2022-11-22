package bridge.view;

import bridge.domain.BridgeGameResult;

public class OutputView {

    public void printStartMessage() {
        printMessage(Messages.PRINT_GAME_START);
    }

    public void printGameResult(BridgeGameResult bridgeGameResult) {
        printMessage(Messages.PRINT_FINAL_RESULT);
        printMap(bridgeGameResult);
        printResult(bridgeGameResult);
        printNumberOfAttempts(bridgeGameResult);
    }

    public void printMap(BridgeGameResult map) {
        System.out.println(map);
    }

    private void printResult(BridgeGameResult bridgeGameResult) {
        if (bridgeGameResult.isMissMatch()) {
            printMessage(Messages.PRINT_FAILURE);
        }
        if (!bridgeGameResult.isMissMatch()) {
            printMessage(Messages.PRINT_SUCCESS);
        }
    }

    private void printNumberOfAttempts(BridgeGameResult bridgeGameResult) {
        printFormat(Messages.PRINT_NUMBER_OF_ATTEMPTS, bridgeGameResult.getNumberOfRetries());
    }

    public void printMessage(Messages message) {
        System.out.println(message.getMessage());
    }

    public void printFormat(Messages message, int count) {
        System.out.printf(message.getMessage(), count);
    }

    public void printBreak() {
        System.out.println();
    }
}
