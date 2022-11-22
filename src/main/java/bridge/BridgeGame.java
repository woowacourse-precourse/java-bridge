package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private List<String> current = new ArrayList<>();
    private int tryCount = -1;
    public void init(int size) throws IllegalArgumentException {
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        try {
            bridge = maker.makeBridge(size);
        }
        catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String step) {
        current.add(step);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(){
        tryCount++;
        current.clear();
    }

    public boolean isOver() {
        for (int i = 0; i < current.size(); i++) {
            if (!bridge.get(i).equals(current.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean isClear() {
        if (bridge.size() != current.size()) {
            return false;
        }
        for (int i = 0; i < bridge.size(); i++) {
            if (!bridge.get(i).equals(current.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int getTryCount() { return tryCount;}
    public List<String> getBridge() { return bridge; }
    public List<String> getCurrent() { return current; }
}
