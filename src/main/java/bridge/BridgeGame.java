package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> Bridge;
    private int trial;
    private int locate;

    public BridgeGame(List<String> Bridge) {
        this.Bridge = Bridge;
        this.trial = 1;
        this.locate = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String Moving) {
        boolean result = this.Bridge.get(this.locate).equals(Moving);
        this.locate += 1;
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String GameCommand) {
        if (GameCommand.equals("R")) {
            this.trial += 1;
            this.locate = 0;
            return true;
        }
        return false;
    }

    public boolean check() {
        return this.locate == this.Bridge.size();
    }

    public List<String> getBridge() {
        return this.Bridge;
    }

    public int getLocate() {
        return this.locate;
    }

    public int getTrial() {
        return this.trial;
    }
}
