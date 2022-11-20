package bridge.controller;

import bridge.domain.*;
import bridge.service.BridgeGame;
import bridge.util.BridgeMaker;
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

    public BridgeController(InputView inputView, OutputView outputView, BridgeGame bridgeGame, BridgeMaker bridgeMaker) {
        this.bridgeGame = bridgeGame;
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void playBridgeGame() {
        outputView.printGameStartMessage();
        Bridge bridge = new Bridge(convertType(makeBridgeByInputSize()));
        Phase phase = new Phase();
        BridgeResult bridgeResult = new BridgeResult();
        GameState gameState = new GameState(1, true);

        while (gameState.isKeepGoing() && bridge.size() > phase.getCurrentPhase()) {
            BridgeBlock inputBlock = valueOf(inputView.readMoving());

            MovingResult movingResult = bridgeGame.move(bridge, inputBlock, phase);
            bridgeResult.addResult(movingResult);
            outputView.printMap(bridgeResult);
            if (movingResult.getState().equals("X")) {
                String gameCommand = inputView.readGameCommand();
                if (gameCommand.equals("Q")) {
                    gameState.gameOver();
                }
                if (gameCommand.equals("R")) {
                    gameState.plusTryCnt();
                    bridgeResult.clearMap();
                }
            }
        }
        outputView.printResult(bridgeResult, gameState);
    }
    private List<String> makeBridgeByInputSize() {
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }
}
