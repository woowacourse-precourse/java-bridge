package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.ui.InputView;
import bridge.ui.OutputView;

import static bridge.constant.Const.*;

public class BridgeGameHost {

    private boolean gameInProgress;
    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeGame bridgeGame;

    public BridgeGameHost() {
        gameInProgress = true;
        outputView = new OutputView();
        inputView = new InputView();
        bridgeGame = new BridgeGame();
    }

    public void progress() {
        outputView.printOpeningPhrase();
        prepare();
        mainPartOfTheGame();
        outputView.printResult();
    }

    private void mainPartOfTheGame() {
        while (gameInProgress) {
            moving();
            isPlayerDead();
            gameSuccess();
        }
    }

    private void prepare() {
        Player.set();
        Bridge.setBridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(decideBridgeSize()));
    }

    private void gameSuccess() {
        if (getResult().equals(SUCCESS)) {
            gameInProgress = false;
        }
    }

    private void isPlayerDead() {
        if (!Player.getAlive()) {
            decideRetryOrQuit();
        }
    }

    private void decideRetryOrQuit() {
        while (true) {
            try {
                parsingGameCommand(getGameCommand());
                break;
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception);
            }
        }
    }

    private String getGameCommand() {
        outputView.printRequestRestart();
        return inputView.readGameCommand();
    }

    private void parsingGameCommand(String gameCommand) {
        if (gameCommand.equals(RETRY)) {
            bridgeGame.retry();
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
                outputView.printError(exception);
            }
        }
    }

    private int getBridgeSize() {
        outputView.printRequestBridgeSize();
        return inputView.readBridgeSize();
    }

    private void moving() {
        while (true) {
            try {
                decideMoving();
                break;
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception);
            }
        }
    }

    private void decideMoving() {
        outputView.printRequestMoving();
        String moving = inputView.readMoving();
        bridgeGame.move(moving);
        outputView.printMap();
    }

    public static String getResult() {
        String answer = FAIL;

        if ((Player.getIndex() + 1) == Bridge.size() && Player.getAlive()) {
            answer = SUCCESS;
        }

        return answer;
    }
}
