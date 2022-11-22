package bridge.controlloer;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.Command;
import bridge.domain.Result;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;
    private InputView inputView;
    private OutputView outputView;
    private final List<String> bridge;
    private int attempts;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();

        outputView.printStart();
        final int bridgeSize = readBridgeSize();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
        this.bridgeGame = new BridgeGame();
        this.attempts = 1;
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
            } catch (IllegalArgumentException exception) {
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
        while (Result.SUCCESS.equals(result)) {
            result = bridgeGame.move(bridge, readMoving());
            if (!result.equals(Result.ARRIVED)) {
                outputView.printMap(bridgeGame.getBridgeResult(), result);
            }
            if (result.equals(Result.FAIL)) {
                result = retryOrEnd();
            }
        }
        end(result);
    }

    private Result retryOrEnd() {
        if (chooseRetryOrEnd().equals(Result.SUCCESS)) {
            bridgeGame.retry();
            attempts++;
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

    private void end(Result result) {
        outputView.printResult(bridgeGame.getBridgeResult(), attempts, result);
    }
}
