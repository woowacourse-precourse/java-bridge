package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.constant.BridgeConstants;
import bridge.constant.ExceptionConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final List<String> path = new ArrayList<>();
    private int attemptTimes = 1;

    public BridgeGame(int size) {
        isCorrectRange(size);
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
    }

    private void isCorrectRange(int size) {
        if (size < BridgeConstants.MINIMUM_LENGTH || BridgeConstants.MAXIMUM_LENGTH < size) {
            throw new IllegalArgumentException(ExceptionConstants.INCORRECT_RANGE.getMessage());
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        isCorrectMoving(moving);
        path.add(moving);
    }

    private void isCorrectMoving(String moving) {
        if (!List.of(BridgeConstants.DOWN, BridgeConstants.UP).contains(moving)) {
            throw new IllegalArgumentException(ExceptionConstants.INCORRECT_MOVING.getMessage());
        }
    }

    public List<List<String>> makeMap() {
        List<List<String>> map = new ArrayList<>();
        map.add(makeRow(BridgeConstants.UP));
        map.add(makeRow(BridgeConstants.DOWN));
        return map;
    }

    private List<String> makeRow(String position) {
        return IntStream.range(0, path.size())
                .mapToObj(index -> makeSymbol(index, position))
                .collect(Collectors.toList());
    }

    private String makeSymbol(int index, String position) {
        if (path.get(index).equals(position)) {
            if (path.get(index).equals(bridge.get(index))) {
                return BridgeConstants.SUCCESS;
            }
            return BridgeConstants.FAILURE;
        }
        return BridgeConstants.SPACE;
    }

    public String calculateResult() {
        if (path.size() == bridge.size() && isAlive()) {
            return BridgeConstants.WIN;
        }
        return BridgeConstants.LOSE;
    }

    public boolean isAlive() {
        int pathLastIndex = path.size() - 1;
        return path.get(pathLastIndex).equals(bridge.get(pathLastIndex));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        path.clear();
        attemptTimes++;
    }

    public int getAttemptTimes() {
        return attemptTimes;
    }
}
