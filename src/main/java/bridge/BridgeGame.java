package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<DIRECTION> bridge = new ArrayList<>();
    private int tryCount = 1;
    private int currentIdx = 0;
    private DIRECTION guess;

    public List<DIRECTION> getBridge() {
        return bridge;
    }

    public DIRECTION getGuess() {
        return guess;
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
        guess = DIRECTION.toEnum(moveInput);
        if (bridge.get(currentIdx).equals(guess)) {
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
        currentIdx = 0;
        tryCount++;
        guess = null;
    }
}
