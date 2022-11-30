package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.ui.InputView;
import bridge.ui.OutputView;

import static bridge.constant.Const.*;

public class BridgeGameHost {

    private boolean gameInProgress;
    private Player player;
    private Bridge bridge;
    private GameProgress gameProgress;
    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeGame bridgeGame;

    public BridgeGameHost() {
        gameInProgress = true;
        player = new Player();
        outputView = new OutputView();
        inputView = new InputView();
        bridgeGame = new BridgeGame();
    }

    public void progress() {
        outputView.printPhrase(OPENING_PHRASE);
        prepare();
        mainPartOfGame();
        outputView.printResult(gameProgress);
    }

    private void mainPartOfGame() {
        while (gameInProgress) {
            moving();
            isPlayerDead();
            isGameSuccess();
        }
    }

    private void prepare() {
        bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(decideBridgeSize()));
        gameProgress = new GameProgress(player, bridge);
    }

    private void isGameSuccess() {
        gameProgress.decideFailOrSuccess();

        if (gameProgress.getFailOrSuccess().equals(SUCCESS)) {
            gameInProgress = false;
        }
    }

    private void isPlayerDead() {
        if (!player.getAlive()) {
            decideRetryOrQuit();
        }
    }

    private void decideRetryOrQuit() {
        while (true) {
            try {
                parsingGameCommand(getGameCommand());
                break;
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }

    private String getGameCommand() {
        outputView.printPhrase(REQUEST_RESTART);
        return inputView.readGameCommand();
    }

    private void parsingGameCommand(String gameCommand) {
        if (gameCommand.equals(RETRY)) {
            bridgeGame.retry(player);
        }

        if (gameCommand.equals(QUIT)) {
            gameInProgress = false;
        }
    }

    private int decideBridgeSize() {
        while (true) {
            try {
                return getBridgeSize();
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }

    private int getBridgeSize() {
        outputView.printPhrase(REQUEST_BRIDGE_SIZE);
        return inputView.readBridgeSize();
    }

    private void moving() {
        while (true) {
            try {
                decideMoving();
                return;
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }

    private void decideMoving() {
        outputView.printPhrase(REQUEST_MOVING);
        String moving = inputView.readMoving();
        bridgeGame.move(player, bridge, moving);
        outputView.printMap(gameProgress);
    }
}
