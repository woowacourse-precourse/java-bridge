package controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import model.Bridge;
import model.BridgeGame;
import view.InputView;
import view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        outputView.printStartMessage();
        bridgeGame = makeBridgeGame(receiveBridgeSize());
        while (!bridgeGame.gameWin()) {
            if (!move() && !retry()) {
                break;
            }
        }
        outputView.printResult(bridgeGame.getUpperBridge(), bridgeGame.getLowerBridge(),
                bridgeGame.getGameResult(), bridgeGame.getTryCount());
    }

    private BridgeGame makeBridgeGame(int bridgeSize) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        Bridge answerBridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        return new BridgeGame(answerBridge);
    }

    private boolean move() {
        boolean crossable = bridgeGame.move(receiveMovingDirection());
        outputView.printMap(bridgeGame.getUpperBridge(), bridgeGame.getLowerBridge());
        return crossable;
    }

    private boolean retry() {
        return bridgeGame.retry(receiveGameCommand());
    }

    private int receiveBridgeSize() {
        while (true) {
            try {
                outputView.printReceiveSizeMessage();
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String receiveMovingDirection() {
        while (true) {
            try {
                outputView.printReceiveMovingDirectionMessage();
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String receiveGameCommand() {
        while (true) {
            try {
                outputView.printReceiveGameCommandMessage();
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
