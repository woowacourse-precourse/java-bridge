package bridge.view;

import bridge.model.Bridge;
import bridge.model.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final int INDEX_ZERO = 0;
    private static final String UP_ROW = "U";
    private static final String DOWN_ROW = "D";
    private static final String ROW_START_BRACKET = "[ ";
    private static final String ROW_END_BRACKET = " ]";
    private static final String DELIMITER = " | ";
    private static final String ANSWER_CORRECT = "O";
    private static final String ANSWER_INCORRECT = "X";
    private static final String ANSWER_WHITE_SPACE = " ";
    private static final String PRINT_GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String PRINT_FINAL_GAME_RESULT = "최종 게임 결과";
    private static final String PRINT_RESULT = "게임 성공 여부: %s%s";
    private static final String PRINT_TRY_COUNT = "총 시도한 횟수: %d%s";


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(final Bridge bridge, final BridgeGame bridgeGame) {
        System.out.print(ROW_START_BRACKET);
        printRow(bridge, bridgeGame, UP_ROW);
        System.out.println(ROW_END_BRACKET);

        System.out.print(ROW_START_BRACKET);
        printRow(bridge, bridgeGame, DOWN_ROW);
        System.out.println(ROW_END_BRACKET);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(final String result, final int tryCount) {
        System.out.printf(PRINT_RESULT, result, System.lineSeparator());
        System.out.printf(PRINT_TRY_COUNT, tryCount, System.lineSeparator());
    }

    public void printGameStart() {
        System.out.println(PRINT_GAME_START);
    }

    public void printFinalGameResult() {
        System.out.println();
        System.out.println(PRINT_FINAL_GAME_RESULT);
    }

    private void printRow(final Bridge bridge, final BridgeGame bridgeGame, final String thisRow) {
        for (int i = INDEX_ZERO; i < bridgeGame.getUserAnswerSheetSize(); ++i) {
            printRowDelimiter(i);
            if (!bridgeGame.getUserAnswerByIndex(i).equals(thisRow)) {
                System.out.print(ANSWER_WHITE_SPACE);
                continue;
            }
            System.out.print(printElementResult(bridge, bridgeGame.getUserAnswerByIndex(i), i));
        }
    }

    private String printElementResult(final Bridge bridge, final String userAnswer, final int index) {
        if (bridge.getResult(userAnswer, index)) {
            return ANSWER_CORRECT;
        }
        return ANSWER_INCORRECT;
    }

    private void printRowDelimiter(final int index) {
        if (index != INDEX_ZERO) {
            System.out.print(DELIMITER);
        }
    }
}
