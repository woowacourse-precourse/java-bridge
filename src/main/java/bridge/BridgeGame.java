package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final List<Direction> histories;
    private int pointer = 0;
    private int tryCount = 1;

    BridgeGame(List<String> bridge) {
        this.bridge = new Bridge(bridge);
        this.histories = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(Direction userDirection) {
        boolean canMoved = bridge.canMoveTo(userDirection, pointer);
        histories.add(userDirection);
        if (canMoved) {
            increasePointer();

            return true;
        }
        return false;
    }


    public void increasePointer() {
        if (!bridge.isAllCrossed(pointer)) {
            pointer++;
        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(Command command) {
        if (command.getType().equals(Command.Retry.getType())) {
            initializePointer();
            tryCount++;
            histories.clear();
            return true;
        }
        return false;
    }

    public void initializePointer() {
        pointer = 0;
    }


    public int getTryCount() {
        return tryCount;
    }
}
