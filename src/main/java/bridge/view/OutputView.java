package bridge.view;

import java.util.Queue;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final static String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final static String REQUEST_BRIDGE_SIZE_MESSAGE = "\n다리의 길이를 입력해주세요.";
    private final static String REQUEST_MOVING_DIRECTION_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final static String REQUEST_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final static String FINAL_GAME_RESULT = "최종 게임 결과";
    private final static String SUCCESS_OR_FAIL = "게임 성공 여부: %s";
    private final static String ATTEMPT_COUNT = "\n총 시도한 횟수: %s";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(String map) {
        System.out.println(map);
        printNewLine();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(String map, Queue<String> gameStatics) {
        System.out.println(FINAL_GAME_RESULT);
        printMap(map);
        printGameStatics(gameStatics);
    }

    private static void printGameStatics(Queue<String> gameStatics) {
        System.out.printf(SUCCESS_OR_FAIL, gameStatics.poll());
        System.out.printf(ATTEMPT_COUNT, gameStatics.poll());
    }

    public static void startGame() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void askBridgeSize() {
        System.out.println(REQUEST_BRIDGE_SIZE_MESSAGE);
    }

    public static void askMovingDirection() {
        System.out.println(REQUEST_MOVING_DIRECTION_MESSAGE);
    }

    public static void askExitOrRestart() {
        System.out.println(REQUEST_GAME_COMMAND);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
