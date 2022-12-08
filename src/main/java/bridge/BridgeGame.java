package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.validator.CommandValidator.validateInvalidRetryType;
import static bridge.validator.CommandValidator.validateInvalidType;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> currentTopBridge = new ArrayList<>();
    private final List<String> currentBottomBridge = new ArrayList<>();
    private int tryCount = 0;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(Bridge correctBridge, String command) {
        boolean result = correctBridge.isCorrect(currentTopBridge.size(), command);
        String sign = "X";
        if (result) sign = "O";
        if (command.equals(MoveCommand.TOP.getMoveCommand())) {
            currentTopBridge.add(sign);
            currentBottomBridge.add(" ");
        }
        if (command.equals(MoveCommand.BOTTOM.getMoveCommand())) {
            currentTopBridge.add(" ");
            currentBottomBridge.add(sign);
        }
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        currentTopBridge.clear();
        currentBottomBridge.clear();
    }

    // 반드시 OutputView에서만 사용하자
    public List<String> getCurrentTopBridge() {
        return currentTopBridge;
    }

    public List<String> getCurrentBottomBridge() {
        return currentBottomBridge;
    }

    public int getTryCount() {
        return tryCount;
    }
}
