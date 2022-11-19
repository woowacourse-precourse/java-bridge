package bridge;

import java.util.List;
import java.util.Stack;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static final String DELIMITER = " | ";
    public static final String UP = "U";
    public static final String DOWN = "D";
    public static final String PREFIX = "[ ";
    public static final String SUFFIX = " ]";
    public static final String SPACE = " ";
    public static final String SUCCESS = "O";
    public static final String FAIL = "X";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        List<String> bridge = bridgeGame.getBridge();
        int position = bridgeGame.getPosition();

        Stack<String> topRow = getRow(bridge, position, UP);
        Stack<String> bottomRow = getRow(bridge, position, DOWN);
        checkGameOver(bridgeGame, topRow, bottomRow);

        printRowWithPrefixAndSuffix(joinByDelimiter(topRow));
        printRowWithPrefixAndSuffix(joinByDelimiter(bottomRow));
    }

    private static void checkGameOver(BridgeGame bridgeGame, Stack<String> topRow, Stack<String> bottomRow) {
        if (bridgeGame.isGameOver()) {
            changeLastResult(topRow);
            changeLastResult(bottomRow);
        }
    }

    private Stack<String> getRow(List<String> bridge, int position, String selectedDirection) {
        Stack<String> row = new Stack<>();
        for (int i = 0; i < position; i++) {
            row.add(match(bridge.get(i), selectedDirection));
        }
        return row;
    }

    private String match(String movableDirection, String selectedDirection) {
        if (movableDirection.equals(selectedDirection)) {
            return SUCCESS;
        }
        return SPACE;
    }

    private static void changeLastResult(Stack<String> row) {
        String lastResult = row.pop();
        if (lastResult.equals(SUCCESS)) {
            row.add(SPACE);
        }
        if (lastResult.equals(SPACE)) {
            row.add(FAIL);
        }
    }

    private static String joinByDelimiter(Stack<String> row) {
        return String.join(DELIMITER, row);
    }

    private static void printRowWithPrefixAndSuffix(String row) {
        System.out.println(PREFIX + row + SUFFIX);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
