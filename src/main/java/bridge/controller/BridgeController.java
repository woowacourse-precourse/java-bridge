package bridge.controller;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeBlock;
import bridge.domain.bridge.BridgeSize;
import bridge.domain.bridge.Phase;
import bridge.domain.result.BridgeResult;
import bridge.domain.result.GameResult;
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

    public void playBridgeGame(Phase phase, BridgeResult bridgeResult, GameResult gameResult) {
        Bridge bridge = new Bridge(BridgeBlock.convertTypeList(makeBridgeByInputSize()));

        while (gameResult.isKeepGoing() && bridge.size() > phase.getCurrentPhase()) {
            MovingResult moveResult = bridgeGame.move(bridge, getInputBlock(), phase);
            bridgeResult.addResult(moveResult);
            outputView.printMap(bridgeResult);
            checkRetry(bridgeResult, gameResult, moveResult);
        }
        outputView.printResult(bridgeResult, gameResult);
    }

    private List<String> makeBridgeByInputSize() {
        BridgeSize bridgeSize = inputView.readBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize.getBridgeSize());
    }

    private void checkRetry(BridgeResult bridgeResult, GameResult gameResult, MovingResult moveResult) {
        if (moveResult.getState().equals("X")) {
            bridgeGame.retry(bridgeResult, gameResult, inputView.readGameCommand());
        }
    }

    private BridgeBlock getInputBlock() {
        return inputView.readMoving();
    }
}
