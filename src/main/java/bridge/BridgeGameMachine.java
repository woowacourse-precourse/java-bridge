package bridge;

import bridge.UI.input.InputView;
import bridge.UI.output.MapDrawer;
import bridge.UI.output.OutputView;
import bridge.enums.Announcement;
import bridge.enums.Direction;
import bridge.enums.GameCommand;

public class BridgeGameMachine {
    private final InputView inputView;
    private final OutputView outputView;
    private final MapDrawer mapDrawer;
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;
    public BridgeGameMachine() {
        this.mapDrawer = new MapDrawer();
        this.outputView = new OutputView(this.mapDrawer);
        this.inputView = new InputView(this.outputView);
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void setUpGame() {
        int bridgeSize = inputView.readBridgeSize();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        bridgeGame = new BridgeGame(bridge, mapDrawer);
    }

    public void gameStart() {
        outputView.printMessage(Announcement.GAME_START.getMessage());
        while (bridgeGame.isRunning()) {
            play();
            if (bridgeGame.isCleared()) {
                break;
            }
            askRetryOrQuit();
        }
    }

    private void play() {
        do {
            Direction direction = inputView.readMoving();
            bridgeGame.move(direction);
            outputView.printMap(bridgeGame);
        } while (bridgeGame.canMoving());
    }

    private void askRetryOrQuit() {
        GameCommand command = inputView.readGameCommand();
        if (command.isRetry()) {
            bridgeGame.retry();
            return;
        }
        bridgeGame.quit();
    }

    public void gameFinish() {
        if (bridgeGame.isCleared() || !bridgeGame.isRunning()) {
            outputView.printResult(bridgeGame);
        }
    }
}
