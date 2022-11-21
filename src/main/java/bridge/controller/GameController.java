package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.*;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private static final String RETRY_COMMAND = "R";

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public GameController(InputView inputView, OutputView outputView, BridgeNumberGenerator bridgeNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public void execute() {
        BridgeGame bridgeGame = this.initGame();
        BridgeGameStatus status = new BridgeGameStatus(RETRY_COMMAND);
        Result result = new Result();

        this.run(bridgeGame, status, result);
    }

    private void run(BridgeGame bridgeGame, BridgeGameStatus status, Result result) {
        while (status.isRunning()) {
            result.initResult();
            this.playGame(result, bridgeGame);
            if (bridgeGame.retry(result)) {
                this.changeGameStatus(status);
                outputView.printResult(result);
                continue;
            }
            outputView.printResult(result);
            break;
        }
    }

    private void playGame(Result result, BridgeGame bridgeGame) {
        Bridge bridge = bridgeGame.getBridge();
        result.increaseTryCount();

        for (int i = 0; i < bridge.getBridgeSize(); i++) {
            bridgeGame.move(result, this.readMoving(), i);

            if (result.hasWrong()) {
                return;
            }
        }
    }

    private Bridge generateBridge() {
        try {
            int bridgeSize = this.readBridgeSize();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

            return new Bridge(bridgeMaker.makeBridge(bridgeSize));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return this.generateBridge();
        }
    }

    private int readBridgeSize() {
        outputView.printInputBridgeSize();
        return inputView.readBridgeSize();
    }

    private MoveDirection readMoving() {
        outputView.printInputMoveDirection();
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return this.readMoving();
        }
    }

    private void changeGameStatus(BridgeGameStatus status) {
        try {
            outputView.printInputGameCommand();
            status.changeStatus(inputView.readGameCommand());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            changeGameStatus(status);
        }
    }

    private BridgeGame initGame() {
        outputView.printGameStart();
        return new BridgeGame((this.generateBridge()));
    }
}
