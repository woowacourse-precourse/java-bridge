package bridge;

import bridge.constant.SuccessFail;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.constant.GameCommand.*;
import static bridge.constant.SuccessFail.*;

public class Run {
    private int attempts = 1;

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
        Judge judge = new Judge(bridgeGame.getBridge(), bridgeGame.getPlayer());
        SuccessFail isSuccess = judge.isSuccess();

        if (isSuccess == FAIL) {
            askWhatToDo(bridgeGame);
        }
    }

    private void playOneSet(BridgeGame bridgeGame) {
        boolean isFinish;
        do {
            String moving = getMoving();
            bridgeGame.move(moving);
            new OutputView().printMap(bridgeGame.getUpBridge(), bridgeGame.getDownBridge());
            Judge judge = new Judge(bridgeGame.getBridge(), bridgeGame.getPlayer());
            isFinish = judge.isFinish();
        } while (!isFinish);
    }

    private void askWhatToDo(BridgeGame bridgeGame) {
        String gameCommand = getGameCommand();
        if (gameCommand.equals(RETRY.getKey())) {
            attempts++;
            bridgeGame.retry();
            play(bridgeGame);
        }
    }

    private int getBridgeSize() {
        while (true) {
            try {
                return new InputView().readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getMoving() {
        while (true) {
            try {
                return new InputView().readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getGameCommand() {
        while (true) {
            try {
                return new InputView().readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
