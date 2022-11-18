package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final int MAX_HEIGHT = 2;
    int size;
    List<String> bridge;
    List<List<String>> bridgeMap;
    int numberOfTries;
    boolean isSuccess;

    public BridgeGame(int size, List<String> bridge) {
        this.size = size;
        this.bridge = bridge;
        this.bridgeMap = makeBridgeMap(size);
        this.numberOfTries = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    private List<List<String>> makeBridgeMap(int size) {
        bridgeMap = new ArrayList<>();
        for (int height = 0; height < MAX_HEIGHT; height++) {
            List<String> row = new ArrayList<>();
            for (int width = 0; width < size; width++) {
                row.add("   ");
            }
            bridgeMap.add(row);
        }
        return bridgeMap;
    }

    public int getSize() {
        return size;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<List<String>> getBridgeMap() {
        return bridgeMap;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }
}
