package game;

import bridge.BridgeDraw;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class BridgeGameController {

    private static final InputView inputView = new InputView();

    private static final OutputView outputView = new OutputView();

    private BridgeGame bridgeGame;

    private final BridgeDraw bridgeDraw = new BridgeDraw();

    public void restart() {
        bridgeGame.retry();
        dealMoveEnter();
    }

    public void dealCorrectEnter(String userInput) {
        bridgeDraw.saveSuccessMoving(userInput);
        outputView.printMap(bridgeDraw.getUpMap(), bridgeDraw.getDownMap());
        if (bridgeGame.isLastIndex()) {
            outputView.printSuccessResult(bridgeGame.getCountRestart(), bridgeDraw.getUpMap(), bridgeDraw.getDownMap());
            return;
        }
        bridgeGame.move();
        dealMoveEnter();
    }

    public void dealWrongEnter(String userInput) {
        bridgeDraw.saveFailMoving(userInput);
        outputView.printMap(bridgeDraw.getUpMap(), bridgeDraw.getDownMap());
        bridgeDraw.reset();
    }

    public void enterRestartState() {
        String restartState = inputView.readGameCommand();
        dealRestartEnter(restartState);
    }

    public void dealRestartEnter(String restartState) {
        if (restartState.equals("R")) {
            restart();
            return;
        }
        outputView.printResult(bridgeGame.getCountRestart(), bridgeDraw.getUpMap(), bridgeDraw.getDownMap());
    }

    public void dealMoveEnter() {
        String userInput = inputView.readMoving();
        if (userInput.equals(bridgeGame.getBridgeCursorValue())) {
            dealCorrectEnter(userInput);
            return;
        }
        dealWrongEnter(userInput);
        enterRestartState();
    }

    public void startGame() {
        int size = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(size);
        dealMoveEnter();
    }
}
