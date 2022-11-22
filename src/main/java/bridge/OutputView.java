package bridge;

import static bridge.utils.Constant.*;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeResult;
import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String DELIMITER = " | ";
    private static final String PRE_FIX = "[ ";
    private static final String SUF_FIX = " ]";
    private static final String SUCCESS_MOVE = "O";
    private static final String FAIL_MOVE = "X";
    private static final String OTHER_SIDE_MOVE = " ";
    private static final String PRINT_FINAL_RESULT = "최종 게임 결과";
    private static final String PRINT_IS_SUCCESS = "게임 성공 여부: ";
    private static final String PRINT_SUCCESS = "성공";
    private static final String PRINT_FAIL = "실패";
    private static final String PRINT_GAME_COUNT = "총 시도한 횟수: ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<BridgeResult> bridgeResults) {
        printUpMap(bridgeResults);
        printDownMap(bridgeResults);
    }

    public static void printUpMap(List<BridgeResult> bridgeResults) {
        StringJoiner upResultView = new StringJoiner(DELIMITER, PRE_FIX, SUF_FIX);

        for (int i = ZERO; i < bridgeResults.size(); i++) {
            upResultView.add(drawUpMap(bridgeResults.get(i)));
        }

        String upMap = upResultView.toString();
        System.out.println(upMap);
    }

    public static void printDownMap(List<BridgeResult> bridgeResults) {
        StringJoiner downResultView = new StringJoiner(DELIMITER, PRE_FIX, SUF_FIX);

        for (int i = ZERO; i < bridgeResults.size(); i++) {
            downResultView.add(drawDownMap(bridgeResults.get(i)));
        }

        String downMap = downResultView.toString();
        System.out.println(downMap);
    }

    private static String drawUpMap(BridgeResult bridgeResult) {
        if (bridgeResult.isUpMove() && bridgeResult.isSuccessMove()) {
            return SUCCESS_MOVE;
        }
        if (bridgeResult.isUpMove() && !bridgeResult.isSuccessMove()) {
            return FAIL_MOVE;
        }
        return OTHER_SIDE_MOVE;
    }

    private static String drawDownMap(BridgeResult bridgeResult) {
        if (!bridgeResult.isUpMove() && bridgeResult.isSuccessMove()) {
            return SUCCESS_MOVE;
        }
        if (!bridgeResult.isUpMove() && !bridgeResult.isSuccessMove()) {
            return FAIL_MOVE;
        }
        return OTHER_SIDE_MOVE;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame, List<BridgeResult> bridgeResults) {
        printSentence(PRINT_FINAL_RESULT);
        printUpMap(bridgeResults);
        printDownMap(bridgeResults);
        printSentence(PRINT_IS_SUCCESS + getPrintIsSuccess(bridgeGame));
        printSentence(PRINT_GAME_COUNT + bridgeGame.getGameCount());
    }

    public static String getPrintIsSuccess(BridgeGame bridgeGame) {
        if (bridgeGame.notExit()) {
            return PRINT_SUCCESS;
        }
        return PRINT_FAIL;
    }

    public static void printSentence(String s) {
        System.out.println(s);
    }
}
