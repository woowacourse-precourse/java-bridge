package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static bridge.Application.ERROR_PREFIX;
import static bridge.DIRECTION.DOWN;
import static bridge.DIRECTION.UP;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<DIRECTION> bridge = new ArrayList<>();
    private int tryCount = 0;
    private int currentIdx = 0;

    public List<DIRECTION> getBridge() {
        return bridge;
    }

    public int getTryCount() {
        return tryCount;
    }

    public int getCurrentIdx() {
        return currentIdx;
    }

    /**
     * U, D로 이루어진 문자열 리스트를 ENUM 리스트로 바꾸어 저장하는 메서드
     */
    public BridgeGame(List<String> bridge) {
        this.bridge.addAll(bridge.stream().map(DIRECTION::toEnum).collect(Collectors.toList()));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moveInput) {
        DIRECTION direction = DIRECTION.toEnum(moveInput);
        if (bridge.get(currentIdx).equals(direction)) {
            currentIdx++;
            return true;
        }
        return false;
    }

    public boolean isComplete() {
        return bridge.size() == currentIdx;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
