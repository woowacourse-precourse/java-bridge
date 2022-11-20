package bridge.controller;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeBlock;
import bridge.domain.bridge.Phase;
import bridge.domain.result.BridgeResult;
import bridge.domain.result.GameState;
import bridge.domain.result.MovingResult;
import bridge.service.BridgeGame;
import bridge.util.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.domain.bridge.BridgeBlock.convertType;
import static bridge.domain.bridge.BridgeBlock.valueOf;

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
            MovingResult moveResult = bridgeGame.move(bridge, getInputBlock(), phase);
            bridgeResult.addResult(moveResult);
            outputView.printMap(bridgeResult);
            checkRetry(bridgeResult, gameState, moveResult);
        }
        outputView.printResult(bridgeResult, gameState);
    }

    private BridgeBlock getInputBlock() {
        return valueOf(inputView.readMoving());
    }

    private void checkRetry(BridgeResult bridgeResult, GameState gameState, MovingResult moveResult) {
        if (moveResult.getState().equals("X")) {
            bridgeGame.retry(bridgeResult, gameState, inputView.readGameCommand());
        }
    }

    private List<String> makeBridgeByInputSize() {
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }
}
