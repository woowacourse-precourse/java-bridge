package bridge;

import bridge.constant.SuccessFail;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.constant.SuccessFail.FAIL;

public class Run {
    int attempts = 1;

    public Run() {
        int bridgeSize = new InputView().readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);

        play(bridgeGame);
    }

    public Run(BridgeGame bridgeGame) {
        play(bridgeGame);
    }

    private void play(BridgeGame bridgeGame) {
        playOneSet(bridgeGame);
        SuccessFail isSuccess = bridgeGame.isSuccess(bridgeGame.bridge, bridgeGame.player);

        if (isSuccess == FAIL) {
            String gameCommand = new InputView().readGameCommand();
            if (gameCommand.equals("R")) {
                attempts++;
                bridgeGame.retry();
                play(bridgeGame);
            }
        }

        new OutputView().printResult(bridgeGame.bridge, bridgeGame.player, attempts);
    }

    private void playOneSet(BridgeGame bridgeGame) {
        boolean isFinish;
        do {
            String moving = new InputView().readMoving();
            bridgeGame.move(moving);
            new OutputView().printMap(bridgeGame.bridge, bridgeGame.player);
            isFinish = bridgeGame.isFinish();
        } while(!isFinish);
    }
}
