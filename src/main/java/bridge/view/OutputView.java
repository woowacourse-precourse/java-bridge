package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameResult;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String SELECT_MOVEMENT_DIRECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_RESTART_OR_QUIT_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String GAME_RESULT = "최종 게임 결과";
    private static final String SUCCESS_OR_FAILURE = "게임 성공 여부: ";
    private static final String TOTAL_NUMBER_OF_TRY = "총 시도한 횟수: ";

    public static void printGameStartMessage() {
        System.out.println(GAME_START);
        System.out.printf(NEW_LINE);
    }

    public static void printInputBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
    }

    public static void printSelectMovementDirection() {
        System.out.println(SELECT_MOVEMENT_DIRECTION);
    }

    public static void printInputRestartOrQuitCommand() {
        System.out.println(INPUT_RESTART_OR_QUIT_COMMAND);
    }

    public static void printMap(BridgeGameResult moveResult) {
        System.out.println(moveResult.getUpperBridge());
        System.out.println(moveResult.getLowerBridge());
    }

    public static void printResult(BridgeGame bridgeGame) {
        System.out.printf(NEW_LINE);
        System.out.println(GAME_RESULT);
        printMap(bridgeGame.getBridgeGameResult());

        System.out.printf(NEW_LINE);
        System.out.println(SUCCESS_OR_FAILURE + bridgeGame.getSuccessOrFailure());
        System.out.printf(TOTAL_NUMBER_OF_TRY + bridgeGame.getNumberOfTry());
    }
}
