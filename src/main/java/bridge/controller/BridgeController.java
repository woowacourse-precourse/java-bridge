package bridge.controller;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeBlock;
import bridge.domain.bridge.Phase;
import bridge.domain.result.BridgeResult;
import bridge.domain.result.GameState;
import bridge.domain.result.MovingResult;
import bridge.service.BridgeGame;
import bridge.system.util.BridgeMaker;
import bridge.system.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

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
        Bridge bridge = new Bridge(BridgeBlock.convertTypeList(makeBridgeByInputSize()));

        while (gameState.isKeepGoing() && bridge.size() > phase.getCurrentPhase()) {
            MovingResult moveResult = bridgeGame.move(bridge, getInputBlock(), phase);
            bridgeResult.addResult(moveResult);
            outputView.printMap(bridgeResult);
            checkRetry(bridgeResult, gameState, moveResult);
        }
        outputView.printResult(bridgeResult, gameState);
    }

    private List<String> makeBridgeByInputSize() {
        int bridgeSize = inputView.readBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private void checkRetry(BridgeResult bridgeResult, GameState gameState, MovingResult moveResult) {
        if (moveResult.getState().equals("X")) {
            bridgeGame.retry(bridgeResult, gameState, inputView.readGameCommand());
        }
    }

    private BridgeBlock getInputBlock() {
        return inputView.readMoving();
    }
}
