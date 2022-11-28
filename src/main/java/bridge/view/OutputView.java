package bridge.view;

import bridge.domain.GameResult;

import java.util.List;

import static bridge.utils.ViewMessage.*;

public class OutputView {

    public void printGameStartMessage() {
        System.out.println(GAME_START);
    }

    public void printMap(GameResult gameResult) {
        printCurrentBridgeMap(gameResult.getUpSideResult());
        printCurrentBridgeMap(gameResult.getDownSideResult());
    }

    private void printCurrentBridgeMap(List<String> bridgeResult) {
        String result = String.join(SEPARATOR_OF_BRIDGE, bridgeResult);
        System.out.println(START_OF_BRIDGE + result + END_OF_BRIDGE);
    }

    public void printResult(GameResult gameResult, boolean isSuccess, int numberOfAttempts) {
        System.out.println(OUTPUT_FINAL_RESULT);
        printMap(gameResult);
        printGameSuccessOrNot(isSuccess);
        System.out.printf(OUTPUT_NUMBER_OF_ATTEMPTS, numberOfAttempts);
    }

    private void printGameSuccessOrNot(boolean isSuccess) {
        if (isSuccess) {
            System.out.println(OUTPUT_GAME_SUCCESS);
            return;
        }
        System.out.println(OUTPUT_GAME_FAIL);
    }
}
