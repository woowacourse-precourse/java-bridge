package bridge.controller;

import bridge.BridgeMaker;
import bridge.domain.BridgeGame;
import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;
    private final OutputView outputView;
    private final InputView inputView;

    public BridgeGameController(BridgeGame bridgeGame, BridgeMaker bridgeMaker, OutputView outputView, InputView inputView) {
        this.bridgeGame = bridgeGame;
        this.bridgeMaker = bridgeMaker;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void play() {
        outputView.printGameStart();
        outputView.printBridgeLengthInput();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        List<String> moveResult = new ArrayList<>();
        while (true) {
            outputView.printMovingSpaceChoice();
            String moveSpace = inputView.readMoving();
            moveResult = bridgeGame.move(bridge, moveSpace);
            outputView.printMap(moveResult);
            if (bridgeGame.isFailGame()) {
                outputView.printRetryOrQuitChoice();
                String gameCommand = inputView.readGameCommand();
                List<String> retry = bridgeGame.retry(gameCommand);
                moveResult = retry;
                if (gameCommand.equals("Q")) {
                    outputView.printResult(moveResult, bridgeGame.isFailFinalGame(bridge),
                            bridgeGame.checkRetryCount());
                    break;
                }
                continue;
            }
            if (!bridgeGame.isFailFinalGame(bridge)) {
                outputView.printResult(moveResult, bridgeGame.isFailFinalGame(bridge),
                        bridgeGame.checkRetryCount());
            }
        }
    }
}
