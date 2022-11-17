package bridge;

import bridge.domain.*;
import bridge.service.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;
    private Movement movement;

    public BridgeGame(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        BridgeSize bridgeSize = inputView.readBridgeSize();
        movement = new Movement(bridgeMaker.makeBridge(bridgeSize.getSize()));
        repeatGame();
    }

    private void repeatGame() {
        do {
            Moving moving = inputView.readMoving();
            if (!move(moving, movement)) {
                retry();
            }
            outputView.printMap();
        } while(!movement.isFinish());
        outputView.printResult();
    }
    private boolean move(Moving moving, Movement movement) {
        return movement.canMove(moving);
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
