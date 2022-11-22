package bridge.domain;

import bridge.type.Bridge;
import bridge.type.TextType;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridges;
    private List<Bridge> results;
    private int tryCount;
    private int pos;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String move) {
        if (bridges.get(pos).equals(move)) {
            makeResult(true,bridges.get(pos));
            pos++;
            return true;
        }

        makeResult(false,bridges.get(pos));
        tryCount++;
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public BridgeGame(List<String> bridges) {
        this.bridges = bridges;
    }

    private void makeResult(boolean correctMove, String bridge) {

        if (correctMove && bridge.equals(TextType.UP)) results.add(Bridge.UP_CORRECT);
        else if (!correctMove && bridge.equals(TextType.UP)) results.add(Bridge.UP_WRONG);
        else if (correctMove && bridge.equals(TextType.DOWN)) results.add(Bridge.DOWN_CORRECT);
        else if (!correctMove && bridge.equals(TextType.DOWN)) results.add(Bridge.DOWN_WRONG);
    }
}
