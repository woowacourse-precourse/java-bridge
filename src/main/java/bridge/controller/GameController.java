package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Result;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    private static final String RETRY = "R";

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printStart();

        try {
            game();
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception);
        } catch (IllegalStateException exception) {
            outputView.printException(exception);
        }
    }

    private void game() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(getBridgeSize());
        Result result = new Result(bridge);
        BridgeGame bridgeGame = new BridgeGame(result);

        process(result, bridgeGame);
    }

    public void process(Result result, BridgeGame bridgeGame) {
        do {
            rounds(result, bridgeGame);
            if (!result.hasFail()) {
                outputView.printResult(result, bridgeGame.getCount());
                break;
            }

            bridgeGame.retry();
        }while (isRetry(getCommand()));
    }

    private void rounds(Result result, BridgeGame bridgeGame) {
        do {
            round(result, bridgeGame);
            if (result.hasFail()) {
                return;
            }
        } while (!result.isSameLength());
    }

    private void round(Result result, BridgeGame bridgeGame) {
        String place = getPlace();
        bridgeGame.move(place);
        outputView.printMap(result);
    }

    private String getPlace() {
        return inputView.readMoving().getPlace();
    }

    private boolean isRetry(String command) {
        return command.equals(RETRY);
    }

    private String getCommand() {
        return inputView.readGameCommand().getCommand();
    }

    private int getBridgeSize() {
        return inputView.readBridgeSize().getBridgeSize();
    }
}
