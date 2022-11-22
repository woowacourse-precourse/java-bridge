package bridge;

/*
 * 게임을 진행하는 클래스
 */

public class Game {

    private InputView inputView = new InputView();
    private BridgeGame bridgeGame;

    public void run() {
        initGame();
        playGame();
        endGame();
    }

    public void initGame() {
        int size = 0;
        while (size == 0) {
            OutputView.gameStart();
            size = inputView.readBridgeSize();
            this.bridgeGame = new BridgeGame(size);
        }
    }

    public void playGame() {
        while (true) {
            String move = getMove();
            String result = bridgeGame.move(move);
            if (retryGame(bridgeGame.isGameOver(result)) == false) {
                break;
            }
            if (bridgeGame.isSuccess()) {
                break;
            }
        }
    }

    public void endGame() {
        bridgeGame.getResult();
    }

    public boolean retryGame(boolean isGameOver) {
        if (isGameOver == true) {
            String command = inputView.readGameCommand();
            if (bridgeGame.retry(command)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public String getMove()
    {
        String moving = "";
        while(true)
        {
            moving = inputView.readMoving();
            if(moving != "")
            {
                return moving;
            }
        }
    }

}
