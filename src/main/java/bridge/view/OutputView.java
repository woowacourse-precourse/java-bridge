package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameResult;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
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

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeGameResult moveResult) {
        System.out.println(moveResult.getUpperBridge());
        System.out.println(moveResult.getLowerBridge());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame) {
        System.out.printf(NEW_LINE);
        System.out.println(GAME_RESULT);
        printMap(bridgeGame.getBridgeGameResult());

        System.out.printf(NEW_LINE);
        System.out.println(SUCCESS_OR_FAILURE + bridgeGame.getSuccessOrFailure());
        System.out.printf(TOTAL_NUMBER_OF_TRY + bridgeGame.getNumberOfTry());
    }
}
