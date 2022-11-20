package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.BridgeRandomNumberGenerator;
import bridge.error.Validator;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Controller {
    private BridgeMaker bridgeMaker;
    private int numberOfAttempts;
    private List<Integer> movingSuccess;
    private boolean presentResult;
    public boolean restart = true;

    public void run() {
        initialize();
        gameStageStart(bridgeMaker.makeBridge(getBridgeSize()));
        OutputView.printResult(movingSuccess, numberOfAttempts);
    }

    private void initialize() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        this.numberOfAttempts = 0;
        OutputView.printStartMessage();
    }

    private int getBridgeSize() {
        try {
            OutputView.printMessageForBridgeSize();
            return Validator.validateLengthOfBridge(InputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getBridgeSize();
        }
    }

    private void gameStageStart(List<String> bridge) {
        while (this.restart) {
            numberOfAttempts++;
            movingStart(bridge);
            if (this.movingSuccess.size() == bridge.size() && this.presentResult) {
                break;
            }
        }
    }

    public void movingStart(List<String> bridge) {
        this.movingSuccess = new ArrayList<>();
        for (int indexOfBridge = 0; indexOfBridge < bridge.size(); indexOfBridge++) {
            this.movingSuccess.add(BridgeGame.move(bridge, indexOfBridge, getMoving()));
            this.presentResult = OutputView.printMap(this.movingSuccess);
            if (BridgeGame.retry(presentResult)) {
                this.restart = checkRestart(getGameCommand());
                break;
            }
        }
    }

    private String getMoving() {
        try {
            OutputView.printMessageForMoving();
            return Validator.validateMoving(InputView.readMoving());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getMoving();
        }
    }

    public static String getGameCommand() {
        try {
            OutputView.printMessageForTermination();
            return Validator.validateGameCommand(InputView.readGameCommand());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getGameCommand();
        }
    }

    private boolean checkRestart(String restart) {
        return Objects.equals(restart, "R");
    }
}
