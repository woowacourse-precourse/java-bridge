package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String MOVE_UP = "U";
    private static final String MOVE_DOWN = "D";
    private static final int MAX_HEIGHT = 2;
    private static final String INPUT_COMMAND_ERROR = "[ERROR] U 또는 D만 입력해주세요. 위는 U, 아래는 D를 입력해주세요.";

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
    public boolean move(String command, int currentPosition) {
        validateMoveCommand(command);
        return true;
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

    private static void validateMoveCommand(String input) {
        if (input.matches(MOVE_UP) || input.matches(MOVE_DOWN)) {
            return;
        }
        throw new IllegalArgumentException(INPUT_COMMAND_ERROR);
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
