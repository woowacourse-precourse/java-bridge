package view;

import bridge.BridgeState;
import constants.Message;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMap(BridgeState bridgeState) {
        System.out.println(bridgeState);
    }

    public void printResult(BridgeState bridgeState, int gameTryCount, boolean successOrNot) {
        System.out.println(Message.FINAL_GAME_RESULT_GUIDE_MESSAGE);

        System.out.println(bridgeState);

        String gameResultMessage = Message.FAIL;
        if (successOrNot) {
            gameResultMessage = Message.SUCCESS;
        }
        System.out.println(String.format(Message.FINAL_GAME_SUCCESS_OR_NOT_MESSAGE, gameResultMessage));
        System.out.println(String.format(Message.FINAL_GAME_TRY_COUNT_MESSAGE, gameTryCount));
    }

    public void printBridgeSizeInputMessage() {
        System.out.println(Message.GAME_START_MESSAGE);
        System.out.println(Message.BRIDGE_SIZE_INPUT_MESSAGE);
    }

    public void printMovingInputMessage() {
        System.out.println(Message.BRIDGE_MOVING_INPUT_MESSAGE);
    }

    public void printAskToRestart() {
        System.out.println(Message.ASK_TO_RESTART_MESSAGE);
    }

    public static void printException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
