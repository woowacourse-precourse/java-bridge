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
            String moving = inputView.readMoving();
            if (!move(moving, movement)) {
                retry();
            }
            outputView.printMap();
        } while(!movement.isFinish());
        outputView.printResult();
    }
    private boolean move(String moving, Movement movement) {
        return movement.canMove(moving);
    }

    public void retry() {
        Command command = inputView.readGameCommand();
        if (command.isRetry()) {
            movement.clearMoving();
            startGame();
        }
        outputView.printResult();
    }
}
