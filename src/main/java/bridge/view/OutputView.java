package bridge.view;

import bridge.domain.GameResult;

import java.util.List;

import static bridge.utils.ViewMessage.*;

public class OutputView {

    public void printMap(GameResult gameResult) {
        System.out.println(OUTPUT_FINAL_RESULT);
        printCurrentBridgeMap(gameResult.getUpSideResult());
        printCurrentBridgeMap(gameResult.getDownSideResult());
        System.out.println();
    }

    public void printCurrentBridgeMap(List<String> bridgeResult) {
        String result = String.join(SEPARATOR_OF_BRIDGE, bridgeResult);
        System.out.println(START_OF_BRIDGE + result + END_OF_BRIDGE);
    }

    public void printResult(boolean isSuccess, int numberOfAttempts) {
        System.out.printf(OUTPUT_GAME_SUCCESS_OR_NOT, isSuccess);
        System.out.printf(OUTPUT_NUMBER_OF_ATTEMPTS, numberOfAttempts);
    }
}
