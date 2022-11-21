package bridge.View;

import static bridge.Constant.InputValue.SELECTION_DOWN;
import static bridge.Constant.InputValue.SELECTION_UP;

import static bridge.Constant.OutputValue.*;

import bridge.Model.BridgeGame;

import bridge.Model.Player;
import java.util.List;



public class OutputView {
    private static final String RESULT_MESSAGE = "최종 게임 결과";
    private static final String BRIDGE_MAP = "[%s]" + System.lineSeparator();
    private static final String IS_SUCCESS = "게임 성공 여부: %s" + System.lineSeparator();
    private static final String RETRY_COUNT = "총 시도한 횟수: %d" + System.lineSeparator();


    private String getIsPassedStair(String bridgeState, String stair) {
        if (bridgeState.equals(stair)) {
            return RIGHT_SELECTION;
        }

        return NOT_SELECTION;
    }

    private String getPassedStair(List<String> bridgeStates, int passedCount, String stair) {
        String result = "";

        for (int bridgeLocation = 0; bridgeLocation < passedCount; bridgeLocation++) {
            String bridgeState = bridgeStates.get(bridgeLocation);

            result += getIsPassedStair(bridgeState, stair);
            result += SEPARATOR;
        }

        return result;
    }

    private void printStair(BridgeGame bridgeGame, int passedCount, String stair) {
        final List<String> bridgeStates = bridgeGame.getBridgeStates();
        final String selectedBridgeState = bridgeStates.get(passedCount);
        boolean isPlayerDead = bridgeGame.isPlayerDead();

        final String result = getPassedStair(bridgeStates, passedCount, stair)
                + getSelectResult(isPlayerDead, selectedBridgeState, stair);

        System.out.printf(BRIDGE_MAP, result);
    }

    private String getIsSuccess(boolean isPlayerDead) {
        if (isPlayerDead) {
            return FAIL;
        }

        return SUCCESS;
    }

    private String getSelectResult(boolean isPlayerDead, String bridgeState, String stair) {
        if (!isPlayerDead && bridgeState.equals(stair)) {
            return RIGHT_SELECTION;
        }

        if (isPlayerDead && !bridgeState.equals(stair)) {
            return WRONG_SELECTION;
        }

        return NOT_SELECTION;
    }

    public void printMap(BridgeGame bridgeGame, int passedCount) {
        printStair(bridgeGame, passedCount, SELECTION_UP);
        printStair(bridgeGame, passedCount, SELECTION_DOWN);
        System.out.println();
    }

    public void printResult(BridgeGame bridgeGame) {
        int maxPassedCount = bridgeGame.getMaxPassedCount();

        System.out.println(RESULT_MESSAGE);

        printMap(bridgeGame, maxPassedCount);

        System.out.printf(IS_SUCCESS, getIsSuccess(bridgeGame.isPlayerDead()));
        System.out.printf(RETRY_COUNT, bridgeGame.getRetryCount());
    }
}
