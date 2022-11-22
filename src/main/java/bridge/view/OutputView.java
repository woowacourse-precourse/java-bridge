package bridge.view;

import static bridge.view.Constants.BRIDGE_DELIMITER;
import static bridge.view.Constants.BRIDGE_HEAD;
import static bridge.view.Constants.BRIDGE_TAIL;
import static bridge.view.Constants.OUTPUT_FAIL;
import static bridge.view.Constants.OUTPUT_NONE;
import static bridge.view.Constants.OUTPUT_PASS;
import static bridge.view.Constants.ROUND_RESULT;
import static bridge.view.Constants.ROUND_RESULT_IS_SUCCESS;
import static bridge.view.Constants.ROUND_RESULT_NUMBER_OF_ATTEMPTS;

import bridge.Direction;
import bridge.domain.PlayResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private Map<Direction, List<String>> bridges;

    public OutputView() {
        this.bridges = mapBridges();
    }

    private Map<Direction, List<String>> mapBridges() {
        Map<Direction, List<String>> bridges = new HashMap<>();
        for (Direction direction : Direction.values()) {
            bridges.put(direction, new ArrayList<>());
        }
        return bridges;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(final String direction, final PlayResult playResult) {
        updateBridges(direction, playResult);
        printBridges();
    }

    private void updateBridges(final String shape, final PlayResult playResult) {
        bridges.keySet()
            .stream()
            .filter(direction -> !direction.matchShape(shape))
            .forEach(direction -> updateBridge(direction, OUTPUT_NONE));
        updateBridge(Direction.of(shape), convertResultMessage(playResult));
    }

    private void updateBridge(final Direction direction, final String result) {
        bridges.computeIfAbsent(direction, bridge -> new ArrayList<>())
            .add(result);
    }

    private String convertResultMessage(final PlayResult PlayResult) {
        if (PlayResult.isPass()) {
            return OUTPUT_PASS;
        }
        if (PlayResult.isFail()) {
            return OUTPUT_FAIL;
        }
        return OUTPUT_NONE;
    }

    private void printBridges() {
        Arrays.stream(Direction.values())
            .forEach(this::printBridge);
    }

    private void printBridge(final Direction direction) {
        System.out.print(BRIDGE_HEAD);
        System.out.print(String.join(BRIDGE_DELIMITER, bridges.get(direction)));
        System.out.println(BRIDGE_TAIL);
    }

    public void clearMap() {
        bridges.clear();
        bridges = mapBridges();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(final boolean isClear, final int attempts) {
        System.out.println(ROUND_RESULT);
        printBridges();
        System.out.println(ROUND_RESULT_IS_SUCCESS + formatClearStatus(isClear));
        System.out.println(ROUND_RESULT_NUMBER_OF_ATTEMPTS + attempts);
    }

    private static String formatClearStatus(final boolean isClear) {
        if (isClear) {
            return "성공";
        }
        return "실패";
    }
}