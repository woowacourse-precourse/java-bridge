package bridge;

import bridge.domain.*;
import bridge.service.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private Movement movement;

    public BridgeGame(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public void startGame() {
        BridgeSize bridgeSize = InputView.readBridgeSize();
        movement = new Movement(new Bridge(bridgeMaker.makeBridge(bridgeSize.getSize())));
        repeatGame();
    }

    private void repeatGame() {
        boolean isContinue = true;
        do {
            move(InputView.readMoving());
            if (!movement.canMove()) {
                isContinue = retry();
            }
        } while (!movement.isFinish() && isContinue);
        OutputView.printResult(movement);
    }

    private void move(Moving moving) {
        movement.saveMoving(moving.getMoving());
        OutputView.printMap(movement);
    }

    public boolean retry() {
        Command command = InputView.readGameCommand();
        if (command.isRetry()) {
            movement.clearMoving();
            return true;
        }
        return false;
    }
}
