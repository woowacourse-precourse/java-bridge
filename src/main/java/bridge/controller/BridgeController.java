package bridge.controller;

import bridge.domain.*;
import bridge.service.BridgeGame;
import bridge.util.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.domain.BridgeBlock.convertType;
import static bridge.domain.BridgeBlock.valueOf;

public class BridgeController {

    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeController() {
        this.bridgeGame = new BridgeGame();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        outputView.printGameStartMessage();
    }

    public void playBridgeGame(Phase phase, BridgeResult bridgeResult, GameState gameState) {
        Bridge bridge = new Bridge(convertType(makeBridgeByInputSize()));

        while (gameState.isKeepGoing() && bridge.size() > phase.getCurrentPhase()) {
            BridgeBlock inputBlock = valueOf(inputView.readMoving());

            MovingResult movingResult = bridgeGame.move(bridge, inputBlock, phase);
            bridgeResult.addResult(movingResult);
            outputView.printMap(bridgeResult);

            checkRetry(bridgeResult, gameState, movingResult);
        }
        outputView.printResult(bridgeResult, gameState);
    }

    private void checkRetry(BridgeResult bridgeResult, GameState gameState, MovingResult movingResult) {
        if (movingResult.getState().equals("X")) {
            bridgeGame.retry(bridgeResult, gameState, inputView.readGameCommand());
        }
    }

    private List<String> makeBridgeByInputSize() {
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }
}
