package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeNumberGenerator;
import bridge.model.TryNumber;
import bridge.model.BridgeGame;
import bridge.model.BridgeSize;
import bridge.model.GameCommand;
import bridge.model.Moving;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        outputView.printGameStartMessage();
        BridgeSize bridgeSize = readBridgeSize();
        Integer size = bridgeSize.getBrideSize();
        BridgeMaker bridgeMaker = bridgeMaker();
        List<String> bridge = bridgeMaker.makeBridge(size);
        TryNumber tryNumber = new TryNumber();
        BridgeGame bridgeGame = new BridgeGame();
        startWalk(bridgeGame, bridge, tryNumber);
    }

    private BridgeMaker bridgeMaker() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        return new BridgeMaker(bridgeNumberGenerator);
    }

    private boolean gameCommand() {
        String command = inputView.readGameCommand();
        GameCommand gameCommand = new GameCommand(command);
        return gameCommand.isRetry();
    }

    private BridgeSize readBridgeSize() {
        while (true) {
            try {
                Integer size = inputView.readBridgeSize();
                return new BridgeSize(size);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private void walk(BridgeGame bridgeGame, List<String> bridge) {
        for (String bridgeStatus : bridge) {
            if (isMovePossible(bridgeGame, bridgeStatus)) {
                continue;
            }
            return;
        }
        bridgeGame.gameSuccess();
    }

    private void startWalk(BridgeGame bridgeGame, List<String> bridge, TryNumber tryNumber) {
        while (!bridgeGame.isSuccess()) {
            walk(bridgeGame, bridge);
            if (!isRetry(bridgeGame)) {
                break;
            }
            bridgeGame.retry(tryNumber);
        }
        finalGameResult(bridgeGame, tryNumber);
    }

    private void finalGameResult(BridgeGame bridgeGame, TryNumber tryNumber) {
        outputView.printFinalGameResult();
        printMap(bridgeGame);
        boolean gameSuccessOrNot = bridgeGame.isSuccess();
        Integer tryNumberCount = tryNumber.getTryNumber();
        outputView.printResult(tryNumberCount, gameSuccessOrNot);
    }

    private void printMap(BridgeGame bridgeGame) {
        List<String> lowBridge = bridgeGame.getLowBridge();
        List<String> highBridge = bridgeGame.getHighBridge();
        outputView.printMap(lowBridge, highBridge);
    }

    private boolean isMovePossible(BridgeGame bridgeGame, String bridgeStatus) {
        String moving = moving();
        boolean movePossible = bridgeGame.move(moving, bridgeStatus);
        printMap(bridgeGame);
        return movePossible;
    }

    private String moving() {
        while (true) {
            try {
                String moving = inputView.readMoving();
                return new Moving(moving).getMoving();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private boolean isRetry(BridgeGame bridgeGame) {
        while (!bridgeGame.isSuccess()) {
            try {
                return gameCommand();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
        return false;
    }
}