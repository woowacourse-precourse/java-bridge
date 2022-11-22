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
        new OutputView().printResult(bridgeGame, attempts);
    }

    private void play(BridgeGame bridgeGame) {
        playOneSet(bridgeGame);
        SuccessFail isSuccess = bridgeGame.isSuccess();

        if (isSuccess == FAIL) {
            String gameCommand = getGameCommand();
            if (gameCommand.equals("R")) {
                attempts++;
                bridgeGame.retry();
                play(bridgeGame);
            }
        }
    }

    private void playOneSet(BridgeGame bridgeGame) {
        boolean isFinish;
        do {
            String moving = getMoving();
            bridgeGame.move(moving);
            new OutputView().printMap(bridgeGame.upBridge, bridgeGame.downBridge);
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
