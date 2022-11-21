package bridge;

import javax.swing.text.Position;
import java.text.MessageFormat;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final Result result;
    private int position = 0;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        result = new Result(bridge.size());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input) {
        if (Key.matchUp(input)) {
            result.handleUpBridge(position, isCorrect(input));
            return;
        }
        result.handleDownBridge(position, isCorrect(input));
    }

    boolean isCorrect(String input) {
        return bridge.get(position).getValue().equals(input);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        result.clear();
    }

    public String printGameResult() {
        return MessageFormat.format("\n최종 게임 결과\n{0}\n{1}", this, result);
    }

    @Override
    public String toString() {
        return result.printStatus(position);
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
