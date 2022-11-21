package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.Getter;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Controller {
    private BridgeMaker bridgeMaker;
    private int numberOfAttempts;
    private List<Integer> movingSuccess;
    private boolean presentResult;
    private boolean restart = true;

    public void run() {
        initialize();
        gameStageStart(bridgeMaker.makeBridge(Getter.getBridgeSize()));
        OutputView.printResult(movingSuccess, numberOfAttempts);
    }

    private void initialize() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        this.numberOfAttempts = 0;
        OutputView.printStartMessage();
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
            moveOneSpace(bridge, indexOfBridge);
            if (BridgeGame.retry(presentResult)) {
                this.restart = checkRestart(Getter.getGameCommand());
                break;
            }
        }
    }

    private void moveOneSpace(List<String> bridge, int indexOfBridge) {
        this.movingSuccess.add(BridgeGame.move(bridge, indexOfBridge, Getter.getMoving()));
        this.presentResult = OutputView.printMap(this.movingSuccess);
    }

    private boolean checkRestart(String restart) {
        return Objects.equals(restart, "R");
    }
}
