package bridge;

import java.util.List;

import static bridge.Const.*;

public class BridgeGameHost {

    private List<String> bridge;
    private int playerIndex;
    private int numberOfRetry;
    private boolean playerAlive;
    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeGame bridgeGame;

    public BridgeGameHost() {
        numberOfRetry = 1;
        playerIndex = -1;
        playerAlive = true;
        outputView = new OutputView();
        inputView = new InputView();
        bridgeGame = new BridgeGame();
    }

    public void gameStart() {
        outputView.printOpeningPhrase();

        int bridgeSize = 0;

        while (true) {
            try {
                outputView.printRequestBridgeSize();
                bridgeSize = inputView.readBridgeSize();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        setBridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize));

        while (true) {
            while (true) {
                try {
                    outputView.printRequestMoving();
                    String moving = inputView.readMoving();
                    bridgeGame.move(this, moving);
                    outputView.printMap(this);
                    break;
                } catch (IllegalArgumentException exception) {
                    System.out.println(exception.getMessage());
                }
            }

            if (!playerAlive) {
                String gameCommand = "";

                while (true) {
                    try {
                        outputView.printRequestRestart();
                        gameCommand = inputView.readGameCommand();
                        break;
                    } catch (IllegalArgumentException exception) {
                        System.out.println(exception.getMessage());
                    }
                }

                if (gameCommand.equals(RETRY)) {
                    bridgeGame.retry(this);
                }

                if (gameCommand.equals(QUIT)) {
                    break;
                }
            }

            if (getResult().equals(SUCCESS)) {
                outputView.printResult(this);
                break;
            }
        }

        outputView.printResult(this);
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
