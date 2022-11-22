package bridge.view;

import bridge.constant.GameConstants;

public class OutputView {
    private static OutputView outputview = new OutputView();

    private OutputView() {
    }

    public static OutputView getOutputView() {
        if (outputview == null) {
            outputview = new OutputView();
        }
        return outputview;
    }

    public void printBridgeGameStart() {
        System.out.println(GameConstants.startGameMessage);
    }

    public void printMap(StringBuffer currentResult) {
        System.out.println(currentResult);
    }

    public void printResult(StringBuffer finalResult) {
        System.out.println(finalResult);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
