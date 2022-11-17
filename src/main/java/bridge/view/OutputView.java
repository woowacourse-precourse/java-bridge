package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String START_LINE = "[ ";
    private static final String CONTENTS_LINE_WITH_BLANK = "  |";
    private static final String CONTENTS_LINE_WITHOUT_BLANK = "%s |";
    private static final String END_LINE_WITH_BLANK = "  ]";
    private static final String END_LINE_WITHOUT_BLANK = "%s ]\n";

    public void printGameStart() {
        System.out.println(GAME_START);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> userMoved, List<String> matchingStatus) {
        printUpperLineOfMap(userMoved, matchingStatus);
        printLowerLineOfMap(userMoved, matchingStatus);
    }

    private void printUpperLineOfMap(List<String> userMoved, List<String> matchingStatus) {
        printStartLine();
        for (int i = 0; i < userMoved.size() - 1; i++) {
            printContentsLine(userMoved.get(i), matchingStatus.get(i), UP);
        }
        printEndLine(userMoved.get(userMoved.size() - 1), matchingStatus.get(userMoved.size() - 1), UP);
    }

    private void printLowerLineOfMap(List<String> userMoved, List<String> matchingStatus) {
        printStartLine();
        for (int i = 0; i < userMoved.size() - 1; i++) {
            printContentsLine(userMoved.get(i), matchingStatus.get(i), DOWN);
        }
        printEndLine(userMoved.get(userMoved.size() - 1), matchingStatus.get(userMoved.size() - 1), DOWN);
    }

    private void printStartLine() {
        System.out.print(START_LINE);
    }

    private void printContentsLine(String moving, String matching, String typeOfLine) {
        if (moving.equals(typeOfLine)) {
            System.out.printf(CONTENTS_LINE_WITHOUT_BLANK, matching);
            return;
        }
        System.out.print(CONTENTS_LINE_WITH_BLANK);
    }

    private void printEndLine(String moving, String matching, String typeOfLine) {
        if (moving.equals(typeOfLine)) {
            System.out.printf(END_LINE_WITHOUT_BLANK, matching);
            return;
        }
        System.out.println(END_LINE_WITH_BLANK);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
