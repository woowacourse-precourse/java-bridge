package bridge.domain;

import bridge.enums.InputKey;
import bridge.enums.ViewMessage;

import java.text.MessageFormat;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private Result result;
    private Position position;
    private int count = 0;


    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        result = new Result(bridge.size());
        position = new Position(bridge.size());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String key) {
        count++;
        String upOrDown = bridge.get(position.getNext());
        if (InputKey.isUp(key)) {
            result.handleUpBridge(upOrDown, position);
            return;
        }
        result.handleDownBridge(upOrDown, position);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        result.clear();
        position.clear();
        count = 0;
    }

    public boolean isNotDone() {
        return !position.isDone();
    }

    public boolean canGoForward() {
        return position.isLessThanBridgeLength() && position.isNotInitializedValue();
    }

    public String printGameResult() {
        return MessageFormat.format(ViewMessage.OUTPUT_PRINT_FINAL_MAP.getValue(), this, result);
    }

    @Override
    public String toString() {
        return result.printStatus(count);
    }
}
