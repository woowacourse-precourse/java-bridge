package bridge;

import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String BLANK = " ";
    private static final String O = "O";
    private static final String X = "X";
    private static final String DELIMITER = "|";
    private static final String START_BRACKET = "[";
    private static final String END_BRACKET = "]";

    private static final String START_NOTICE = "다리 건너기 게임을 시작합니다.";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> result) {

        StringBuilder a = new StringBuilder("[");
        StringBuilder b = new StringBuilder("[");
        String c = result.get(result.size() - 1);
        String d = result.get(result.size() - 2);
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i) == "U") {
                a.append(" O |");
                b.append("   |");
            }
            if (result.get(i) == "D") {
                a.append("   |");
                b.append(" O |");
            }
        }
        if (c == "X" && d == "U") {
            a.replace(a.length() - 3, a.length() - 2, "X");
        }
        if (c == "X" && d == "D") {
            b.replace(b.length() - 3, b.length() - 2, "X");
        }
        a.replace(a.length() - 1, a.length(), "]");
        b.replace(b.length() - 1, b.length(), "]");
        System.out.println(a);
        System.out.println(b);
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printStartNotice() {
        System.out.println(START_NOTICE);
    }
}
