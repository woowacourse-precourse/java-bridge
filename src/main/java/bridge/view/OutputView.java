package bridge.view;

import static bridge.Row.DOWN;
import static bridge.Row.UP;

import bridge.Row;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String BRIDGE_START = "[ ";
    public static final String BRIDGE_END = " ]";
    public static final String BRIDGE_DELIMITER = " | ";
    public static final String MOVING_O = "O";
    public static final String MOVING_X = "X";
    public static final String MOVING_EMPTY = " ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, int round, boolean result) {
        Map<Row, List<String>> row = new HashMap<>();
        row.put(UP, new ArrayList<>());
        row.put(DOWN, new ArrayList<>());
        for (int i = 0; i < round - 1; i++) {
            cross(row, Row.of(bridge.get(i)), true);
        }
        cross(row, Row.of(bridge.get(round - 1)), result);
        printRow(row.get(UP));
        printRow(row.get(DOWN));
    }

    private void printRow(List<String> row) {
        System.out.println(BRIDGE_START + String.join(BRIDGE_DELIMITER, row) + BRIDGE_END);
    }

    private void cross(Map<Row, List<String>> row, Row moving, boolean isCorrectMoving) {
        Row otherSide = getOtherSide(moving);
        if (isCorrectMoving) {
            row.get(otherSide).add(MOVING_EMPTY);
            row.get(moving).add(MOVING_O);
            return;
        }
        row.get(otherSide).add(MOVING_X);
        row.get(moving).add(MOVING_EMPTY);
    }

    private Row getOtherSide(Row moving) {
        return Row.values()[(moving.ordinal() + 1) % 2];
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
