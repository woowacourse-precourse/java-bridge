package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private final String GAME_SUCCESS_OR_FAIL_MESSAGE = "게임 성공 여부: ";
    private final String NUMBER_OF_GAME_ATTEMPTS_MESSAGE = "총 시도한 횟수: ";
    private final String SUCCESS_MESSAGE = "성공";
    private final String FAIL_MESSAGE = "실패";

    private final String LINE_BREAK = "\n";
    private final String PREFIX_SQUARE_BRACKET = "[";
    private final String SUFFIX_SQUARE_BRACKET = "]";
    private final String DIVIDING_VERTICAL_LINE = "|";
    private final String BLANK = " ";

    private final int START_INDEX = 0;
    private final int ONE_INDEX = 1;
    private final int START_LINE = 0;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> currentBridge) {
        int bridgeWidth = currentBridge.get(START_INDEX).length();

        for (int bridgeWidthCount = bridgeWidth - ONE_INDEX ; bridgeWidthCount >= START_INDEX; bridgeWidthCount--) {
            System.out.print(PREFIX_SQUARE_BRACKET + BLANK);
            printCurrentBridgeLine(currentBridge, bridgeWidthCount);
            System.out.println(BLANK + SUFFIX_SQUARE_BRACKET);
        }

        System.out.print(LINE_BREAK);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> currentBridge) {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap(currentBridge);
    }

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE + LINE_BREAK);
    }

    public void printCurrentBridgeLine(List<String> currentBridge, int currentLine) {
        for (int lineCount = START_LINE; lineCount < currentBridge.size(); lineCount++) {
            if (lineCount != START_LINE) {
                System.out.print(BLANK + DIVIDING_VERTICAL_LINE + BLANK);
            }

            System.out.print(currentBridge.get(lineCount).charAt(currentLine));
        }
    }

    public void printGameSuccessOrFail(boolean successOrFail) {
        System.out.print(GAME_SUCCESS_OR_FAIL_MESSAGE);

        if (successOrFail) {
            System.out.println(SUCCESS_MESSAGE);
        }

        if (!successOrFail) {
            System.out.println(FAIL_MESSAGE);
        }
    }

    public void printTotalGameAttemptsCount(int gameAttemptsCount) {
        System.out.print(NUMBER_OF_GAME_ATTEMPTS_MESSAGE + gameAttemptsCount);
    }
}
