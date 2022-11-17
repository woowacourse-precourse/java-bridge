package bridge.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String START_LINE = "[ ";
    private static final String CONTENTS_LINE_WITH_BLANK = "  | ";
    private static final String CONTENTS_LINE_WITHOUT_BLANK = "%s | ";
    private static final String END_LINE_WITH_BLANK = "  ]";
    private static final String END_LINE_WITHOUT_BLANK = "%s ]\n";
    private static final String RESULT = "최종 게임 결과";
    private static final String GAME_SUCCESS = "게임 성공 여부: 성공";
    private static final String GAME_FAILED = "게임 성공 여부: 실패";
    private static final String TOTAL_ATTEMPTS = "총 시도한 횟수: %d\n";

    public void printGameStart() {
        System.out.println(GAME_START);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Map<String, String> matchingStatus) {
        List<String> userMoved = new ArrayList<>(matchingStatus.keySet());
        List<String> matching = new ArrayList<>(matchingStatus.values());
        printUpperLineOfMap(userMoved, matching);
        printLowerLineOfMap(userMoved, matching);
    }

    private void printUpperLineOfMap(List<String> userMoved, List<String> matching) {
        printStartLine();
        for (int i = 0; i < userMoved.size() - 1; i++) {
            printContentsLine(userMoved.get(i), matching.get(i), UP);
        }
        printEndLine(userMoved.get(userMoved.size() - 1), matching.get(userMoved.size() - 1), UP);
    }

    private void printLowerLineOfMap(List<String> userMoved, List<String> matching) {
        printStartLine();
        for (int i = 0; i < userMoved.size() - 1; i++) {
            printContentsLine(userMoved.get(i), matching.get(i), DOWN);
        }
        printEndLine(userMoved.get(userMoved.size() - 1), matching.get(userMoved.size() - 1), DOWN);
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
    public void printResult(Map<String, String> matchingStatus, boolean isGameSuccess, int totalAttempts) {
        System.out.println(RESULT);
        printMap(matchingStatus);
        printWhetherGameSuccess(isGameSuccess);
        printTotalAttempts(totalAttempts);
    }

    private void printWhetherGameSuccess(boolean isGameSuccess) {
        if (isGameSuccess) {
            System.out.println(GAME_SUCCESS);
            return;
        }
        System.out.println(GAME_FAILED);
    }

    private void printTotalAttempts(int totalAttempts) {
        System.out.printf(TOTAL_ATTEMPTS, totalAttempts);
    }
}
