package bridge.view;

import bridge.domain.BridgeGameResult;
import bridge.domain.enumeration.MovingType;

import java.util.List;
import java.util.Objects;

import static bridge.domain.BridgeGame.RETRY_COUNT;
import static bridge.domain.enumeration.Message.*;
import static bridge.domain.enumeration.MovingType.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String CORRECT = " O ";
    private static final String WRONG = " X ";
    private static final String EMPTY = "   ";
    private static final String SEPARATOR = "|";
    private static final String FIRST_BRACKET = "[";
    private static final String LAST_BRACKET = "]";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<BridgeGameResult> bridgeGameResults) {
        StringBuilder upRow = new StringBuilder();
        StringBuilder downRow = new StringBuilder();
        for (int i = 0; i < bridgeGameResults.size(); i++) {
            upRow.append(makeUpRow(bridgeGameResults.get(i)));
            downRow.append(makeDownRow(bridgeGameResults.get(i)));
        }
        printRows(upRow, downRow);
        printEnter();
    }

    private static void printRows(StringBuilder upRow, StringBuilder downRow) {
        upRow.deleteCharAt(upRow.length() - 1);
        downRow.deleteCharAt(downRow.length() - 1);
        System.out.println(FIRST_BRACKET + upRow + LAST_BRACKET);
        System.out.println(FIRST_BRACKET + downRow + LAST_BRACKET);
    }

    private static String makeUpRow(BridgeGameResult bridgeGameResult) {
        if (checkUp(bridgeGameResult.getUserMoving()) && bridgeGameResult.getIsMatched()) {
            return makeRowWithFormat(CORRECT);
        }
        if (checkUp(bridgeGameResult.getUserMoving()) && !bridgeGameResult.getIsMatched()) {
            return makeRowWithFormat(WRONG);
        }
        return makeRowWithFormat(EMPTY);
    }

    private static boolean checkUp(String userMoving) {
        return Objects.equals(userMoving, UP.getMovingType());
    }

    private static String makeDownRow(BridgeGameResult bridgeGameResult) {
        if (checkDown(bridgeGameResult.getUserMoving()) && bridgeGameResult.getIsMatched()) {
            return makeRowWithFormat(CORRECT);
        }
        if (checkDown(bridgeGameResult.getUserMoving()) && !bridgeGameResult.getIsMatched()) {
            return makeRowWithFormat(WRONG);
        }
        return makeRowWithFormat(EMPTY);
    }

    private static boolean checkDown(String userMoving) {
        return Objects.equals(userMoving, DOWN.getMovingType());
    }

    private static String makeRowWithFormat(String result) {
        return result + SEPARATOR;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<BridgeGameResult> bridgeGameResults, int bridgeSize) {
        printLastGameResultMessage();
        printMap(bridgeGameResults);
        printIsSuccess(bridgeGameResults.size(), bridgeSize);
        printRetryCount();
    }

    private static void printLastGameResultMessage() {
        System.out.println(LAST_GAME_RESULT_MESSAGE.getMessage());
    }

    private static void printIsSuccess(int bridgeGameResultSize, int bridgeSize) {
        if (bridgeGameResultSize == bridgeSize) {
            System.out.println(WHETHER_SUCCESS.getMessage() + SUCCESS.getMessage());
            return;
        }
        System.out.println(WHETHER_SUCCESS.getMessage() + FAIL.getMessage());
    }

    private static void printRetryCount() {
        System.out.println(TOTAL_RETRY_COUNT_IS.getMessage() + RETRY_COUNT);
    }

    public static void printStartMessage() {
        System.out.println(START_MESSAGE.getMessage());
        printEnter();
    }

    public static void printEnter() {
        System.out.println();
    }

    public static void printBridgeSizeRequestMessage() {
        System.out.println(BRIDGE_SIZE_REQUEST_MESSAGE.getMessage());
    }

    public static void printMovingRequestMessage() {
        System.out.println(MOVING_REQUEST_MESSAGE.getMessage());
    }

    public static void printGameCommandRequestMessage() {
        System.out.println(GAME_COMMAND_REQUEST_MESSAGE.getMessage());
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
