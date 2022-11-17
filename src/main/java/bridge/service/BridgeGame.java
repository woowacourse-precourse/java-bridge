package bridge.service;

import bridge.constant.Movement;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * - Instance 변수 추가 가능
 * - Package 변경 가능
 * - Method 이름 변경 불가능
 * - Method 인자와 반환 타입 변경 가능
 * - 필요 method 추가 가능
 */
public class BridgeGame {

    private List<String> bridge;
    private List<Movement> movements;

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
        String partOfBridge = bridge.get(movements.size());
        if (movement.equals("U") && partOfBridge.equals("U")) {
            movements.add(Movement.UP_AND_O);
        } else if (movement.equals("U") && partOfBridge.equals("D")) {
            movements.add(Movement.UP_AND_X);
        } else if (movement.equals("D") && partOfBridge.equals("D")) {
            movements.add(Movement.DOWN_AND_O);
        } else if (movement.equals("D") && partOfBridge.equals("U")) {
            movements.add(Movement.DOWN_AND_X);
        }
        return movements.get(movements.size() - 1).isAvailable();
    }

    public String createMovementStatus() {
        StringBuilder upperStatus = new StringBuilder("[");
        StringBuilder lowerStatus = new StringBuilder("[");
        for (Movement movement : movements) {
            upperStatus.append(distinguishStatus(movement, Movement.UP_AND_O, Movement.UP_AND_X));
            lowerStatus.append(distinguishStatus(movement, Movement.DOWN_AND_O, Movement.DOWN_AND_X));
        }
        upperStatus.replace(upperStatus.length() - 1, upperStatus.length(), "]\n");
        lowerStatus.replace(lowerStatus.length() - 1, lowerStatus.length(), "]\n");
        return upperStatus.append(lowerStatus).toString();
    }

    private String distinguishStatus(Movement movement, Movement movementO, Movement movementX) {
        if (movement == movementO) {
            return " O |";
        } else if (movement == movementX) {
            return " X |";
        }
        return "   |";
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
