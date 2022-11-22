package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeRecord;
import bridge.domain.Command;
import bridge.domain.Result;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final BridgeGame bridgeGame;
    private BridgeRecord bridgeRecord;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();

        outputView.printStart();
        Bridge.setBridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(readBridgeSize()));
        this.bridgeGame = new BridgeGame();
    }

    private int readBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private Command readMoving() {
        while (true) {
            try {
                return inputView.readMoving();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private Command readGameCommand() {
        while (true) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public void play() {
        Result result = Result.SUCCESS;
        int attempts;
        for (attempts = 0; Result.SUCCESS.equals(result); attempts++) {
            this.bridgeRecord = new BridgeRecord();
            result = playOneGame();
            if (result.equals(Result.FAIL)) {
                result = retryOrEnd();
            }
        }
        end(result, attempts);
    }

    private Result playOneGame() {
        Result resultOfEachGame = Result.SUCCESS;
        for (int indexOfBridge = 0; resultOfEachGame.equals(Result.SUCCESS); indexOfBridge++) {
            Command command = readMoving();
            resultOfEachGame = bridgeGame.move(indexOfBridge, command);
            bridgeRecord.update(command);
            outputView.printMap(bridgeRecord.getBridgeRecord(), resultOfEachGame);
        }
        return resultOfEachGame;
    }

    private Result retryOrEnd() {
        if (chooseRetryOrEnd().equals(Result.SUCCESS)) {
            this.bridgeRecord = bridgeGame.retry();
            return Result.SUCCESS;
        }
        return Result.FAIL;
    }

    private Result chooseRetryOrEnd() {
        final Command command = readGameCommand();
        if (command.equals(Command.RETRY)) {
            return Result.SUCCESS;
        }
        return Result.FAIL;
    }

    private void end(Result result, int attempts) {
        outputView.printResult(bridgeRecord.getBridgeRecord(), attempts, result);
    }
}
