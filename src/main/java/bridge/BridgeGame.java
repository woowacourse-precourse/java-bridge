package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final int UP_INDEX = 0;
    private static final int DOWN_INDEX = 1;
    private static final String MOVE_UP = "U";
    private static final int MAX_HEIGHT = 2;

    private final int size;
    private final List<String> bridge;
    private List<List<String>> bridgeMap;
    private int numberOfTries;
    private boolean isSuccess = true;

    public BridgeGame(int size, List<String> bridge) {
        this.size = size;
        this.bridge = bridge;
        this.bridgeMap = makeBridgeMap(size);
        this.numberOfTries = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param command 이동 명령의 종류 ("U": 위, "D": 아래)
     * @param currentPosition 이동할 칸의 위치
     * @return 이동 가능 여부에 따라 가능하다면 true, 불가능하다면 false 반환
     */
    public boolean move(String command, int currentPosition) {
        int index = getIndex(command);
        if (command.equals(bridge.get(currentPosition))) {
            bridgeMap.get(index).set(currentPosition, " O ");
            return true;
        }
        bridgeMap.get(index).set(currentPosition, " X ");
        this.isSuccess = false;
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
        this.numberOfTries += 1;
        this.bridgeMap = makeBridgeMap(this.size);
        this.isSuccess = true;
    }

    /**
     * 최초의 다리 상태를 만들 때 사용하는 메서드
     * @param size 다리 길이
     * @return 공백으로 채워져있는 다리 상태 반환
     */
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

    /**
     * 이동 명령에 따라 bridgeMap에서 올바른 인덱스를 구할 때 사용하는 메서드
     * @param command 이동 명령의 종류 ("U": 위, "D": 아래)
     * @return 이동 명령(위, 아래)에 따라 bridgeMap에서의 인덱스를 반환
     */
    private int getIndex(String command) {
        if (command.equals(MOVE_UP)) {
            return UP_INDEX;
        }
        return DOWN_INDEX;
    }

    public List<List<String>> getBridgeMap() {
        return bridgeMap;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
