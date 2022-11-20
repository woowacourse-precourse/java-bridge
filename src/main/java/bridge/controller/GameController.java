package bridge.controller;

import bridge.InputView;
import bridge.OutputView;
import bridge.service.BridgeGame;
import bridge.support.BridgeMaker;
import bridge.support.BridgeRandomNumberGenerator;

import java.util.List;

import static bridge.utils.GameStatus.LOSE;
import static bridge.utils.GameStatus.PLAYING;

public class GameController {
    private static final String RESTART_COMMAND = "R";

    private final BridgeGame bridgeGame;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public GameController() {
        outputView.printInit();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = createBridge(bridgeSize);
        this.bridgeGame = new BridgeGame(bridge);
    }

    private List<String> createBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public void play() {
        playMoving();
        if (isFailure()) {
            String gameCommand = inputView.readGameCommand();
            if (RESTART_COMMAND.equals(gameCommand)) {
                bridgeGame.retry();
                play();
                return;
            }
        }

        outputView.printResult(bridgeGame);
    }

    private void playMoving() {
        while (!isEnd()) {
            String moveCommand = inputView.readMoving();
            bridgeGame.move(moveCommand);
            outputView.printMap(bridgeGame);
        }
    }

    private boolean isEnd() {
        return !PLAYING.equals(bridgeGame.getStatus());
    }

    private boolean isFailure() {
        return LOSE.equals(bridgeGame.getStatus());
    }


}
