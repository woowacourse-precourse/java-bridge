package bridge.view;

import static bridge.model.Cell.BLANK;
import static bridge.model.Cell.CORRECT;
import static bridge.model.Cell.WRONG;

import bridge.model.Bridge;
import bridge.model.Direction;
import bridge.model.Player;
import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String FINAL_RESULT_MESSAGE = "\n최종 게임 결과";
    private static final String GAME_STATUS_MESSAGE = "\n게임 성공 여부: %s";
    private static final String TOTAL_ATTEMPTS_MESSAGE = "총 시도한 횟수: %d";
    private static final String SUCCESS_MESSAGE = "성공";
    private static final String FAIL_MESSAGE = "실패";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge bridge, Player player) {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add(generateDirectionLine(bridge, player, Direction.UP));
        joiner.add(generateDirectionLine(bridge, player, Direction.DOWN));
        System.out.println(joiner);
    }

    private String generateDirectionLine(Bridge bridge, Player player, Direction direction) {
        StringJoiner joiner = new StringJoiner(" ");
        joiner.add("[");
        joiner.add(matchingLine(bridge.getBridge(), player.getDirections(), direction));
        joiner.add("]");
        return joiner.toString();
    }

    private String matchingLine(List<String> bridge, List<String> directions, Direction direction) {
        int size = Math.min(bridge.size(), directions.size());
        StringJoiner joiner = new StringJoiner(" | ");
        for (int i = 0; i < size; i++) {
            joiner.add(matchingCell(bridge.get(i), directions.get(i), direction.getDirection()));
        }
        return joiner.toString();
    }

    private String matchingCell(String bridge, String direction, String target) {
        if (!direction.equals(target)) {
            return BLANK.getType();
        }
        if (direction.equals(bridge)) {
            return CORRECT.getType();
        }
        return WRONG.getType();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Bridge bridge, Player player) {
        System.out.println(FINAL_RESULT_MESSAGE);
        printMap(bridge, player);
        System.out.printf((GAME_STATUS_MESSAGE) + "%n", getSuccessOrFail(bridge, player));
        System.out.printf((TOTAL_ATTEMPTS_MESSAGE) + "%n", player.getAttempt());
    }

    private String getSuccessOrFail(Bridge bridge, Player player) {
        if (bridge.isDone(player)) {
            return SUCCESS_MESSAGE;
        }
        return FAIL_MESSAGE;
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String message) {
        System.out.printf("%s %s%n", ERROR_PREFIX, message);
    }

}
