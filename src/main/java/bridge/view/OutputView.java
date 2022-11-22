package bridge.view;

import static bridge.Moving.DOWN;
import static bridge.Moving.UP;
import static bridge.constant.BridgeSymbol.BRIDGE_DELIMITER;
import static bridge.constant.BridgeSymbol.BRIDGE_END;
import static bridge.constant.BridgeSymbol.BRIDGE_START;
import static bridge.constant.BridgeSymbol.MOVING_EMPTY;
import static bridge.constant.BridgeSymbol.MOVING_O;
import static bridge.constant.BridgeSymbol.MOVING_X;

import bridge.Moving;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, int round, boolean result) {
        Map<Moving, List<String>> row = new HashMap<>();
        row.put(UP, new ArrayList<>());
        row.put(DOWN, new ArrayList<>());
        for (int i = 0; i < round - 1; i++) {
            cross(row, Moving.of(bridge.get(i)), true);
        }
        cross(row, Moving.of(bridge.get(round - 1)), result);
        printRow(row.get(UP));
        printRow(row.get(DOWN));
    }

    private void printRow(List<String> row) {
        System.out.println(BRIDGE_START + String.join(BRIDGE_DELIMITER, row) + BRIDGE_END);
    }

    private void cross(Map<Moving, List<String>> row, Moving moving, boolean isCorrectMoving) {
        Moving otherSide = getOtherSide(moving);
        if (isCorrectMoving) {
            row.get(otherSide).add(MOVING_EMPTY);
            row.get(moving).add(MOVING_O);
            return;
        }
        row.get(otherSide).add(MOVING_X);
        row.get(moving).add(MOVING_EMPTY);
    }

    private Moving getOtherSide(Moving moving) {
        return Moving.values()[(moving.ordinal() + 1) % 2];
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
