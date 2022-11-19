package bridge;

public class GamePlayer {

    private BridgeGameManager bridgeGameManager;

    public void playGame() {
        try {
            bridgeGameManager = new BridgeGameManager();
            bridgeGameManager.setUpGame();
            do {
                bridgeGameManager.move();
            } while (bridgeGameManager.isGameEnd());
        } catch (IllegalArgumentException illegalArgumentException) {
            bridgeGameManager.exceptionalGameEnd(illegalArgumentException.getMessage());
            return;
        }
        bridgeGameManager.printResult();
    }

}

