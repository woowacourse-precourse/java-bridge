package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeGame bridgeGame = new BridgeGame();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void play() {
        int trialCnt = 1;
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        while(true) {
            String movingCommand = inputView.readMoving();
            List<String> bridgeStatus = bridgeGame.move(movingCommand, bridge);
            outputView.printMap(bridge, bridgeStatus);

            if (bridgeGame.isSuccess(bridge)) {
                outputView.printResult();
                outputView.printSuccess();
                break;
            }

            if (bridgeGame.isFailure()) {
                String gameCommand = inputView.readGameCommand();

                if (gameCommand.equals("Q")) {
                    outputView.printResult();
                    outputView.printFailure();
                    break;
                }

                if (gameCommand.equals("R")) {
                    bridgeGame.retry();
                    trialCnt++;
                }
            }
        }

        outputView.printTrialCnt(trialCnt);
    }
}