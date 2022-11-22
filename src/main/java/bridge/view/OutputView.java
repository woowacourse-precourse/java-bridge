package bridge.view;

import bridge.domain.vo.BridgeGameResult;

import java.util.List;

import static bridge.domain.BridgeGame.TOTAL_TRY_COUNT;
import static bridge.domain.BridgeGame.isSuccess;
import static bridge.domain.vo.BridgeGameResult.*;
import static bridge.enumeration.Format.*;
import static bridge.enumeration.GameMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
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
        System.out.println(FIRST_BRAKET.getFormat() + upRow + LAST_BRAKET.getFormat());
        System.out.println(FIRST_BRAKET.getFormat() + downRow + LAST_BRAKET.getFormat());
    }

    private static String makeUpRow(BridgeGameResult bridgeGameResult) {
        if (checkUp(bridgeGameResult.getUserMoving()) && bridgeGameResult.getIsMatched()) {
            return makeRowWithFormat(CORRECT.getFormat());
        }
        if (checkUp(bridgeGameResult.getUserMoving()) && !bridgeGameResult.getIsMatched()) {
            return makeRowWithFormat(WRONG.getFormat());
        }
        return makeRowWithFormat(BLANK.getFormat());
    }

    private static String makeDownRow(BridgeGameResult bridgeGameResult) {
        if (checkDown(bridgeGameResult.getUserMoving()) && bridgeGameResult.getIsMatched()) {
            return makeRowWithFormat(CORRECT.getFormat());
        }
        if (checkDown(bridgeGameResult.getUserMoving()) && !bridgeGameResult.getIsMatched()) {
            return makeRowWithFormat(WRONG.getFormat());
        }
        return makeRowWithFormat(BLANK.getFormat());
    }

    private static String makeRowWithFormat(String result) {
        return result + SEPARATOR.getFormat();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<BridgeGameResult> bridgeGameResults, int bridgeSize) {
        printLastGameResultMessage();
        printMap(bridgeGameResults);
        printIsSuccess(bridgeGameResults, bridgeSize);
        printRetryCount();
    }

    private static void printLastGameResultMessage() {
        System.out.println(GAME_FINAL_RESULT.getMessage());
    }

    private static void printIsSuccess(List<BridgeGameResult> bridgeGameResults, int bridgeSize) {
        if (isSuccess(bridgeGameResults, bridgeSize)) {
            System.out.println(GAME_SUCCESS_OR_NOT.getMessage() + GAME_SUCCESS.getMessage());
            return;
        }
        System.out.println(GAME_SUCCESS_OR_NOT.getMessage() + GAME_FAILURE.getMessage());
    }

    private static void printRetryCount() {
        System.out.println(TRY_COUNT.getMessage() + TOTAL_TRY_COUNT);
    }

    public static void printStartMessage() {
        System.out.println(GAME_START.getMessage());
        printEnter();
    }

    public static void printEnter() {
        System.out.println();
    }

    public static void printBridgeSizeRequestMessage() {
        System.out.println(INPUT_BRIDGE_SIZE.getMessage());
    }

    public static void printMovingRequestMessage() {
        System.out.println(INPUT_MOVE.getMessage());
    }

    public static void printGameCommandRequestMessage() {
        System.out.println(INPUT_RETRY_COMMAND.getMessage());
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}