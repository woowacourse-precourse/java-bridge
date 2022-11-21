package bridge.controller;

import java.util.ArrayList;
import java.util.List;

import bridge.domain.BridgeGame;
import bridge.domain.maker.BridgeMaker;
import bridge.domain.maker.BridgeRandomNumberGenerator;
import bridge.dto.TrialResult;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        BridgeGame bridgeGame = makeGame();

        List<TrialResult> trialResults = new ArrayList<>();
        while (!bridgeGame.isFinished()) {
            String moving = inputView.readMoving();
            TrialResult trialResult = bridgeGame.move(moving);
            trialResults.add(trialResult);
            outputView.printMap(trialResults);

            if (!trialResult.wasSuccessful()) {
                String command = inputView.readGameCommand();
                if (command.equals("R")) {
                    bridgeGame.retry();
                    trialResults.clear();
                }
                if (command.equals("Q")) {
                    break;
                }
            }
        }
    }

    private BridgeGame makeGame() {
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return BridgeGame.from(bridge);
    }
}
