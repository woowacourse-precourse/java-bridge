package bridge.views;

import bridge.identifiers.Direction;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private static String MSG_NONE_DIRECTION = " ";
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
        int pathLength = playerPath.size();

        Map<Direction, List<String>> messageParts = makeMessagePartsByDirection(pathLength);

        for (int index = 0; index < pathLength; ++index) {
            modifyPathMessageParts(playerPath.get(index), isGameOver, pathLength, messageParts, index);
        }
        System.out.println(applyMapFormat(messageParts.get(Direction.UP)));
        System.out.println(applyMapFormat(messageParts.get(Direction.DOWN)));
    }

    private Map<Direction, List<String>> makeMessagePartsByDirection(int pathLength){
        Map<Direction, List<String>> messageParts = new HashMap<>();
        messageParts.put(Direction.UP, makeNoneDirections(pathLength));
        messageParts.put(Direction.DOWN, makeNoneDirections(pathLength));
        return messageParts;
    }


    private void modifyPathMessageParts(Direction direction, boolean isGameOver, int pathLength, Map<Direction, List<String>> messageParts, int index) {
        if (pathLength - 1 == index) {
            if (isGameOver) {
                messageParts.get(direction).set(index, MSG_WRONG_DIRECTION);
                return;
            }
        }
        messageParts.get(direction).set(index, MSG_CORRECT_DIRECTION);
    }

    private String applyMapFormat(List<String> messageParts){
        return MessageFormat.format(
                FORMAT_MAP,
                messageParts.stream().collect(Collectors.joining(FORMAT_MAP_DELIMITER))
                );
    }


    private List<String> makeNoneDirections(int size) {
        List<String> directions = new ArrayList<>(size);
        for (int index = 0; index < size; ++index) {
            directions.add(MSG_NONE_DIRECTION);
        }
        return directions;
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
