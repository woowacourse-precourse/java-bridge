package bridge.view.output;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeState;

import static bridge.domain.Constants.*;

public class OutputView {

    private static final String NOTIFY_GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String NOTIFY_INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String NOTIFY_INPUT_ARROW = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String NOTIFY_INPUT_RETRY_OR_NOT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String MAP_RESULT = "최종 게임 결과";
    private static final String GAME_RESULT = "게임 성공 여부: %s%n";
    private static final String TOTAL_GAME_ATTEMPTS = "총 시도한 횟수: %d";

    public void printGameStartNotification() {
        System.out.println(NOTIFY_GAME_START + "\n");
    }

    public void printInputBridgeSizeNotification() {
        System.out.println(NOTIFY_INPUT_BRIDGE_SIZE);
    }

    public void printInputArrow() {
        System.out.println(NOTIFY_INPUT_ARROW);
    }

    public void printInputRetryOrNot() {
        System.out.println(NOTIFY_INPUT_RETRY_OR_NOT);
    }

    public void printMap(BridgeState bridgeState) {
        System.out.println(OPEN_SQUARE_BRACKETS + bridgeState.getUpBridgeState() + CLOSE_SQUARE_BRACKETS);
        System.out.println(OPEN_SQUARE_BRACKETS + bridgeState.getDownBridgeState() + CLOSE_SQUARE_BRACKETS);
        System.out.println();
    }

    public void printResult(BridgeState bridgeState) {
        System.out.println(MAP_RESULT);
        printMap(bridgeState);
    }

    public void printGameResult(BridgeGame bridgeGame) {
        if (bridgeGame.isWon()) {
            System.out.printf(GAME_RESULT, GAME_RESULT_SUCCESS);
            return;
        }
        System.out.printf(GAME_RESULT, GAME_RESULT_FAILURE);
    }

    public void printTotalGameAttempts(BridgeGame bridgeGame) {
        System.out.printf(TOTAL_GAME_ATTEMPTS, bridgeGame.getTotalGameAttempts());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
