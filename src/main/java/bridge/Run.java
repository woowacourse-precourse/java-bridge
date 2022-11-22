package bridge;

import bridge.constant.SuccessFail;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.constant.SuccessFail.FAIL;

public class Run {
    int attempts = 1;

    public Run() {
        int bridgeSize = getBridgeSize();
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
            String gameCommand = getGameCommand();
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
            String moving = getMoving();
            bridgeGame.move(moving);
            new OutputView().printMap(bridgeGame.bridge, bridgeGame.player);
            isFinish = bridgeGame.isFinish();
        } while(!isFinish);
    }

    private int getBridgeSize() {
        while(true) {
            try {
                return new InputView().readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getMoving() {
        while(true) {
            try {
                return new InputView().readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getGameCommand() {
        while(true) {
            try {
                return new InputView().readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
