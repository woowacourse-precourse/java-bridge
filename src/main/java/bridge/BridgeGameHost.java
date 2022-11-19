package bridge;

import java.util.List;

import static bridge.Const.*;

public class BridgeGameHost {

    private List<String> bridge;
    private int playerIndex;
    private int numberOfRetry;
    private boolean playerAlive;
    private boolean gameInProgress;
    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeGame bridgeGame;

    public BridgeGameHost() {
        numberOfRetry = 1;
        playerIndex = -1;
        playerAlive = true;
        gameInProgress = true;
        outputView = new OutputView();
        inputView = new InputView();
        bridgeGame = new BridgeGame();
    }

    public void gameStart() {
        outputView.printOpeningPhrase();
        setBridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(decideBridgeSize()));
        while (gameInProgress) {
            moving();
            isPlayerDead();
            gameSuccess();
        }
        outputView.printResult(this);
    }

    private void gameSuccess() {
        if (getResult().equals(SUCCESS)) {
            outputView.printResult(this);
            gameInProgress = false;
        }
    }

    private void isPlayerDead() {
        String gameCommand = "";

        if (!playerAlive) {
            decideRetryOrQuit(gameCommand);
        }
    }

    private void decideRetryOrQuit(String gameCommand) {
        while (true) {
            try {
                gameCommand = getGameCommand();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        parsingGameCommand(gameCommand);
    }

    private String getGameCommand() {
        outputView.printRequestRestart();
        return inputView.readGameCommand();
    }

    private void parsingGameCommand(String gameCommand) {
        if (gameCommand.equals(RETRY)) {
            bridgeGame.retry(this);
        }

        if (gameCommand.equals(QUIT)) {
            gameInProgress = false;
        }
    }

    private int decideBridgeSize() {
        int bridgeSize = 0;
        while (true) {
            try {
                bridgeSize = printAndGetBridgeSize();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return bridgeSize;
    }

    private int printAndGetBridgeSize() {
        outputView.printRequestBridgeSize();
        return inputView.readBridgeSize();
    }

    private void moving() {
        while (true) {
            try {
                printAndDecideMoving();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void printAndDecideMoving() {
        outputView.printRequestMoving();
        String moving = inputView.readMoving();
        bridgeGame.move(this, moving);
        outputView.printMap(this);
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public String stepOfIndexInBridge(int index) {
        return bridge.get(index);
    }

    public String getResult() {
        String answer = FAIL;

        if ((playerIndex + 1) == bridge.size() && playerAlive) {
            answer = SUCCESS;
        }

        return answer;
    }

    public boolean getPlayerAlive() {
        return playerAlive;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public int getRetry() {
        return numberOfRetry;
    }

    public void movePlayer() {
        this.playerIndex++;
    }

    public void playerDie() {
        this.playerAlive = false;
    }

    public void retry() {
        this.playerIndex = -1;
        this.playerAlive = true;
        this.numberOfRetry++;
    }
}
