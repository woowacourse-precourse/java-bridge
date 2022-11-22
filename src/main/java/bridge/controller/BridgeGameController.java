package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.error.InputError;
import bridge.model.BridgeGame;
import bridge.model.Command;
import bridge.model.Direction;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    public final int MIN_SIZE = 3;
    public final int MAX_SIZE = 20;
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }


    public void run() {
        begin();
        initGame();
        play();
        end();
    }

    private void begin() {
        outputView.printBegin();
    }

    private void initGame() {
        try {
            outputView.askSize();
            int size = inputView.readBridgeSize();
            validateSize(size);
            List<String> bridge = bridgeMaker.makeBridge(size);
            bridgeGame.setBridge(bridge);
        } catch (IllegalArgumentException iae) {
            outputView.printError(iae);
            initGame();
        }
    }

    private void validateSize(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(InputError.INVALID_SIZE.getMessage());
        }
    }

    private void play() {
        while (!bridgeGame.isEnd()) {
            move();
            if (bridgeGame.isFail()) {
                askRetry();
            }
        }
    }

    private void askRetry() {
        try {
            outputView.askRetry();
            Command command = inputView.readGameCommand();
            command.exec(bridgeGame);
        } catch (IllegalArgumentException iae) {
            outputView.printError(iae);
            askRetry();
        }
    }


    private void move() {
        try {
            outputView.askDirection();
            Direction direction = inputView.readMoving();
            bridgeGame.move(direction);
            outputView.printMap(bridgeGame.getHistory());
        } catch (IllegalArgumentException iae) {
            outputView.printError(iae);
            move();
        }
    }

    private void end() {
        outputView.printResult(bridgeGame);
    }
}
