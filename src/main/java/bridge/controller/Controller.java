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
    private int numberOfAttempts = 0;
    private List<Integer> movingSuccess;
    private boolean presentResult;
    private boolean restart = true;

    public void run() {
        BridgeMaker bridgeMaker = initialize();
        gameStageStart(bridgeMaker.makeBridge(Getter.getBridgeSize()));
        OutputView.printResult(this.movingSuccess, this.numberOfAttempts);
    }

    private BridgeMaker initialize() {
        OutputView.printStartMessage();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        return bridgeMaker;
    }

    private void gameStageStart(List<String> bridge) {
        while (this.restart) {
            this.numberOfAttempts++;
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
            if (BridgeGame.retry(this.presentResult)) {
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
