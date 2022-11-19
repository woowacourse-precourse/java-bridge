package bridge.controller;

import bridge.service.BridgeGame;
import bridge.service.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    public BridgeController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        BridgeGame game = initGame();

        while (!game.isComplete()) {
            boolean moveSuccess = move(game);

            if(moveSuccess) {
                continue;
            }
        }
    }

    public BridgeGame initGame() {
        outputView.printGameStartMsg();

        outputView.printInputBridgeSizeMsg();
        int bridgeSize = inputView.readBridgeSize(BridgeMaker.BRIDGE_MIN_SIZE, BridgeMaker.BRIDGE_MAX_SIZE);

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return new BridgeGame(bridge);
    }

    public boolean move(BridgeGame game) {
        outputView.printInputMoveCellMsg();
        String movement = inputView.readMoving();

        return game.move(movement);
    }

    public boolean retry(BridgeGame game) {
        return false;
    }
}
