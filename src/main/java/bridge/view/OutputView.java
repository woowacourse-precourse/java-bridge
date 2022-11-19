package bridge.view;

import bridge.model.Bridge;
import bridge.model.Direction;
import bridge.model.Player;
import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String ERROR_PREFIX = "[ERROR]";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge bridge, Player player) {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add(generateDirectionLineResult(bridge, player, Direction.UP));
        joiner.add(generateDirectionLineResult(bridge, player, Direction.DOWN));
        System.out.println(joiner);
    }

    private String generateDirectionLineResult(Bridge bridge, Player player, Direction direction) {
        StringJoiner joiner = new StringJoiner(" ");
        joiner.add("[");
        joiner.add(matchingMap(bridge.getBridge(), player.getDirections(), direction));
        joiner.add("]");
        return joiner.toString();
    }

    public String matchingMap(List<String> bridge, List<String> directions, Direction direction) {
        int size = Math.min(bridge.size(), directions.size());
        StringJoiner joiner = new StringJoiner(" | ");
        for (int i = 0; i < size; i++) {
            joiner.add(generateResult(bridge.get(i), directions.get(i), direction.getDirection()));
        }
        return joiner.toString();
    }

    private String generateResult(String bridge, String direction, String target) {
        if (!direction.equals(target)) {
            return " ";
        }
        if (direction.equals(bridge)) {
            return "O";
        }
        return "X";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String message) {
        System.out.printf("%s %s%n", ERROR_PREFIX, message);
    }
}
