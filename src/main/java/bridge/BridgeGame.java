package bridge;

import bridge.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputController inputController;
    private List<String> board;
    private int count;

    public BridgeGame(BridgeNumberGenerator numberGenerator) {
        this.inputController = new InputController(
                new InputView(),
                new OutputView(),
                new BridgeMaker(numberGenerator)
        );
        count = 1;
        initialize();
    }

    private void initialize() {
        board = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() throws IllegalArgumentException {
        String direction = inputController.getMovingDirection();
        board.add(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() throws IllegalArgumentException {
        String retryOrQuit = inputController.getGameCommand();
        if (retryOrQuit.equals(Constant.RETRY)) {
            count++;
            initialize();
            return true;
        }
        return false;
    }
}
