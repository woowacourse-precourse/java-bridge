package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String QUIT = "Q";
    private static final String RETRY = "R";
    private static final String UPPER_SIDE = "U";
    private static final String LOWER_SIDE = "D";

    private final List<String> bridge;
    private int currentPosition;
    private int retryCount;

    public BridgeGame(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(size);
        currentPosition = 0;
        retryCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moveCommand) {
        validateMoveCommand(moveCommand);
        String availableRow = bridge.get(currentPosition);
        if (moveCommand.equals(availableRow)) {
            currentPosition++;
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retryCommand) {
        if (retryCommand.equals(RETRY)) {
            retryCount++;
            return true;
        }
        if (retryCommand.equals(QUIT)) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    private void validateMoveCommand(String moveCommand) {
        if (moveCommand.equals(UPPER_SIDE) || moveCommand.equals(LOWER_SIDE)) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
