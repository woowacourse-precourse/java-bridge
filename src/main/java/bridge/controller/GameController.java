package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.*;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private static final String RETRY_COMMAND = "R";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public GameController(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public void execute() {
        BridgeGame bridgeGame = this.initGame();
        BridgeGameStatus status = new BridgeGameStatus(RETRY_COMMAND);
        Result result = new Result();

        this.run(bridgeGame, status, result);
    }

    private void run(BridgeGame bridgeGame, BridgeGameStatus status, Result result) {
        if (!status.isRunning()) {
            return;
        }
        this.playGame(result, bridgeGame);

        if (bridgeGame.retry(result)) {
            this.changeGameStatus(status);
            OutputView.printResult(result);
            this.run(bridgeGame, status, result);
        }
        OutputView.printResult(result);
    }

    private void playGame(Result result, BridgeGame bridgeGame) {
        result.initResult();
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
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

            int bridgeSize = this.readBridgeSize();
            return new Bridge(bridgeMaker.makeBridge(bridgeSize));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return this.generateBridge();
        }
    }

    private int readBridgeSize() {
        OutputView.printInputBridgeSize();
        return InputView.readBridgeSize();
    }

    private MoveDirection readMoving() {
        OutputView.printInputMoveDirection();
        try {
            return InputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return this.readMoving();
        }
    }

    private void changeGameStatus(BridgeGameStatus status) {
        try {
            OutputView.printInputGameCommand();
            status.changeStatus(InputView.readGameCommand());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            changeGameStatus(status);
        }
    }

    private BridgeGame initGame() {
        OutputView.printGameStart();
        return new BridgeGame((this.generateBridge()));
    }
}
