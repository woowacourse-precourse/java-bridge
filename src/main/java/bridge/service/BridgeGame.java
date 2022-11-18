package bridge.service;

import bridge.constant.Movement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * - Instance 변수 추가 가능
 * - Package 변경 가능
 * - Method 이름 변경 불가능
 * - Method 인자와 반환 타입 변경 가능
 * - 필요 method 추가 가능
 */
public class BridgeGame {

    private final List<String> bridge;
    private final List<Movement> movements;

    private StringBuilder upperMap, lowerMap;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.movements = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String movement) {
        String nextBlock = bridge.get(movements.size());
        addMovementHistory(movement, nextBlock);
        return movements.get(movements.size() - 1).isAvailable();
    }

    private void addMovementHistory(String movement, String nextBlock) {
        if (movement.equals("U") && nextBlock.equals("U")) {
            movements.add(Movement.UP_AND_O);
        } else if (movement.equals("U") && nextBlock.equals("D")) {
            movements.add(Movement.UP_AND_X);
        } else if (movement.equals("D") && nextBlock.equals("D")) {
            movements.add(Movement.DOWN_AND_O);
        } else if (movement.equals("D") && nextBlock.equals("U")) {
            movements.add(Movement.DOWN_AND_X);
        }
    }

    public String createMovementMap() {
        upperMap = buildEmptyMap();
        lowerMap = buildEmptyMap();
        addMoveableStatus();
        return upperMap.append("\n").append(lowerMap).append("\n").toString();
    }

    private StringBuilder buildEmptyMap() {
        int mapSize = movements.size();
        return new StringBuilder("[" + "   |".repeat(mapSize - 1) + "   ]");
    }

    private void addMoveableStatus() {
        IntStream.range(0, movements.size()).forEach(movementSequence -> {
            Movement movement = movements.get(movementSequence);
            if (movement.direction().equals("U")) {
                upperMap.setCharAt(movementSequence * 4 + 2, movement.moveable());
            } else if (movement.direction().equals("D")) {
                lowerMap.setCharAt(movementSequence * 4 + 2, movement.moveable());
            }
        });
    }

    public boolean crossedBridge() {
        return bridge.size() == movements.size() && movements.get(movements.size() - 1).isAvailable();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        movements.clear();
    }
}
