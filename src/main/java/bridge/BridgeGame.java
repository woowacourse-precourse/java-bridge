package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> upCells;
    private final List<String> downCells;
    private final List<String> bridge;
    private int count;
    private int index;
    private boolean movingStatus;

    public BridgeGame(List<String> bridge) {
        this.upCells = new ArrayList<>();
        this.downCells = new ArrayList<>();
        this.bridge = bridge;
        this.count = 0;
        this.index = 0;
        this.movingStatus = true;
    }

    public List<String> getUpCells() {
        return upCells;
    }

    public List<String> getDownCells() {
        return downCells;
    }

    public int getCount() {
        return count;
    }

    public boolean isMovingStatus() {
        return movingStatus;
    }

    public boolean isEnd() {
        return index == bridge.size();
    }

    public static String valueOfStatus(boolean status) {
        if (status) {
            return "O";
        }
        return "X";
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        movingStatus = moving.equals(bridge.get(index++));
        if (moving.equals(CellType.DOWN.getCell())){
            downCells.add(valueOfStatus(movingStatus));
            upCells.add(" ");
        }
        if (moving.equals(CellType.UP.getCell())){
            upCells.add(valueOfStatus(movingStatus));
            downCells.add(" ");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String input) {
        if (input.equals("R")){
            count++;
            movingStatus = true;
            index = 0;
            upCells.clear();
            downCells.clear();
        }
    }
}
