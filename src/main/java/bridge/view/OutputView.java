package bridge.view;

import bridge.domain.Bridge;
import java.util.List;

public class OutputView {

    private static final String GAME_START = "다리 건너기 게임을 시작합니다.\n\n";
    private static final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요.\n";
    private static final String SELECT_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)\n";
    private static final String RESTART_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n";
    private static final String FINAL_GAME_RESULT_MESSAGE = "최종 게임 결과\n";
    private static final String GAME_SUCCESS_OR_NOT_MESSAGE = "\n게임 성공 여부: %s\n";
    private static final String TOTAL_ATTEMPTS = "총 시도한 횟수: %d\n";

    public static void printGameStart() {
        System.out.printf(GAME_START);
    }

    public static void printInputSize() {
        System.out.printf(BRIDGE_SIZE_INPUT_MESSAGE);
    }

    public static void printSelectMessage() {
        System.out.printf(SELECT_MESSAGE);
    }

    public static void printGameResultMessage() {
        System.out.printf(FINAL_GAME_RESULT_MESSAGE);
    }

    public static void printRestartMessage() {
        System.out.printf(RESTART_MESSAGE);
    }

    public static void printGameSuccessOrNot(String result) {
        System.out.printf(GAME_SUCCESS_OR_NOT_MESSAGE, result);
    }

    public static void printTotalAttempts(int attempts) {
        System.out.printf(TOTAL_ATTEMPTS, attempts);
    }

    private static void printUpperBridge() {
        List<String> upperBridge = Bridge.getUpperBridge();
        for (int block = 0; block < upperBridge.size(); block++) {
            System.out.print(upperBridge.get(block));
            if (block + 1 < upperBridge.size()) {
                System.out.print(" | ");
            }
        }
    }

    private static void printLowerBridge() {
        List<String> lowerBridge = Bridge.getLowerBridge();
        for (int block = 0; block < lowerBridge.size(); block++) {
            System.out.print(lowerBridge.get(block));
            if (block + 1 < lowerBridge.size()) {
                System.out.print(" | ");
            }
        }
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap() {
        System.out.print("[ ");
        printUpperBridge();
        System.out.print(" ]");
        System.out.println();
        System.out.print("[ ");
        printLowerBridge();
        System.out.print(" ]");
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(boolean result, int attempts) {
        printGameResultMessage();
        printMap();
        if (result) {
            printGameSuccessOrNot("성공");
        }
        if (!result) {
            printGameSuccessOrNot("실패");
        }
        printTotalAttempts(attempts);
    }
}
