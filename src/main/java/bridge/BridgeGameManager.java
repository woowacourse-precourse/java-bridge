package bridge;

public class BridgeGameManager {
    private BridgeGame bridgeGame;

    final private OutputView outputView;
    final private InputView inputView;


    public BridgeGameManager() {
        outputView = new OutputView();
        inputView = new InputView();
        bridgeGame = new BridgeGame();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        outputView.printInputMove();
        String input = inputView.readMoving();
        bridgeGame.move(input);
    }

    /**
     * 전체 게임 동작 관리를 위해 사용하는 메서드
     */
    public void startGame() {
        outputView.printStartGame();
        int gameOverResult = -1;
        buildBridge();
        while (bridge.size() != playerBridge.size()) {
            move();
            gameOverResult = checkGameOver();
            if (gameOverResult == 0 || gameOverResult == 1) continue;
            if (!retry()) break;
        }
        gameOver(gameOverResult);
    }
}
