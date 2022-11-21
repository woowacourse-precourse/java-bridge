package controller;

import bridge.BridgeRandomNumberGenerator;
import model.bridge.Bridge;
import model.bridge.BridgeMaker;
import model.bridge.BridgeSize;
import model.bridge.MoveMark;
import model.command.GameCommand;
import model.game.BridgeGame;
import view.InputView;
import view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        printGameStart();
        initBridgeGame();
        play();
        printFinalGameResult();
    }

    private void printGameStart() {
        outputView.printGameStart();
    }

    private void initBridgeGame() {
        BridgeSize bridgeSize = getBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize.getSize()));
        bridgeGame = new BridgeGame(bridge);
    }

    private BridgeSize getBridgeSize() {
        try {
            return new BridgeSize(inputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBridgeSize();
        }
    }

    private void play() {
        while (bridgeGame.isContinue()) {
            move();
            printGameResult();
            checkGameResult();
        }
    }

    private void move() {
        MoveMark moveMark = getMoveMark();
        bridgeGame.move(moveMark);
    }

    private MoveMark getMoveMark() {
        try {
            return new MoveMark(inputView.readMoving());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoveMark();
        }
    }

    private void printGameResult() {
        outputView.printMap(bridgeGame.getMaps());
    }

    private void checkGameResult() {
        if (!bridgeGame.isSuccess()) {
            checkRetry();
        }
    }

    private void checkRetry() {
        GameCommand gameCommand = getGameCommand();
        if (gameCommand.isRetry()) {
            bridgeGame.retry();
        }
    }

    private GameCommand getGameCommand() {
        try {
            return new GameCommand(inputView.readGameCommand());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getGameCommand();
        }
    }

    private void printFinalGameResult() {
        outputView.printResult(bridgeGame.getMaps(), bridgeGame.getGameResult(), bridgeGame.getTryCount());
    }
}