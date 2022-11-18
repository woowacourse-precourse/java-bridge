package bridge;

import bridge.domain.BridgeSize;
import bridge.domain.Command;
import bridge.domain.Movement;
import bridge.domain.Moving;
import bridge.service.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

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
        boolean isContinue = true;
        do {
            move(inputView.readMoving());
            if (!movement.canMove()) {
                isContinue = retry();
            }
        } while (!movement.isFinish() && isContinue);
        outputView.printResult(movement);
    }

    private void move(Moving moving) {
        movement.saveMoving(moving.getMoving());
        outputView.printMap(movement);
    }

    public boolean retry() {
        Command command = inputView.readGameCommand();
        if (command.isRetry()) {
            movement.clearMoving();
            return true;
        }
        return false;
    }
}
