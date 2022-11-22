package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.utils.command.GameCommand.COMMAND_RESTART;
import static bridge.utils.status.GameStatus.LOSE;
import static bridge.utils.status.GameStatus.PLAYING;

public class GameController {

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
        move();
        if (isFailure()) {
            if (restart()) {
                return;
            }
        }

        outputView.printResult(bridgeGame);
    }

    private boolean restart() {
        String gameCommand = inputView.readGameCommand();
        if (COMMAND_RESTART.equals(gameCommand)) {
            bridgeGame.retry();
            play();
            return true;
        }
        return false;
    }

    private void move() {
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
