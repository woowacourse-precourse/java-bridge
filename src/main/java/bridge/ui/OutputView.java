package bridge.ui;

import java.util.List;

import static bridge.util.PrintMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
        System.out.print(ENTER);
    }

    public static void printInputBridgeSizeMessage() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
    }

    public static void printChooseSpaceToMoveMessage() {
        System.out.print(ENTER);
        System.out.println(CHOOSE_SPACE_TO_MOVE_MESSAGE);
    }

    public static void printChooseRetryGameMessage() {
        System.out.print(ENTER);
        System.out.println(CHOOSE_RETRY_GAME_MESSAGE);
    }

    public static void printFinalGameResultMessage(boolean isEntered) {
        if (isEntered) System.out.print(ENTER);
        System.out.println(FINAL_GAME_RESULT_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> bridges) {
        System.out.println(bridges.get(0));
        System.out.println(bridges.get(1));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<String> bridges, boolean isEntered, boolean isSuccess) {
        printFinalGameResultMessage(isEntered);
        printMap(bridges);
        printGameSuccess(isSuccess);
    }

    public static void printGameSuccess(boolean isSuccess) {
        System.out.print(ENTER);
        if (isSuccess) System.out.println(GAME_SUCCESS_MESSAGE + SUCCESS_MESSAGE);
        if (!isSuccess) System.out.println(GAME_SUCCESS_MESSAGE + FAIL_MESSAGE);
    }

    public static void printTotalTryCountMessage(int count) {
        System.out.println(TOTAL_TRY_COUNT_MESSAGE + count);
    }
}
