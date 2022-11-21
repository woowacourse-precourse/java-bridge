package bridge.views;

import bridge.identifiers.Direction;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static String MSG_WELCOME = "다리 건너기 게임을 시작합니다.";
    private static String FORMAT_MAP = "[ {0} ]";
    private static String FORMAT_MAP_DELIMITER = " | ";
    private static String MSG_CORRECT_DIRECTION = "O";
    private static String MSG_WRONG_DIRECTION = "X";
    private static String MSG_SEPARATOR = "";

    public void printWelcome() {
        System.out.println(MSG_WELCOME);
        printSeparator();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<Direction> playerPath, boolean isGameOver) {
        List<String> directions = playerPath.stream()
                .map((element) -> MSG_CORRECT_DIRECTION)
                .collect(Collectors.toList());
        if (isGameOver) {
            directions.set(directions.size() - 1, MSG_WRONG_DIRECTION);
        }
        String message = directions.stream()
                .collect(Collectors.joining(FORMAT_MAP_DELIMITER));
        System.out.println(MessageFormat.format(FORMAT_MAP, message));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    private void printSeparator() {
        System.out.println(MSG_SEPARATOR);
    }
}
