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
     * 다리를 생성하는 메서드
     */
    public void buildBridge() {
        outputView.printInputBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.buildBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public void move() {
        outputView.printInputMove();
        String input = inputView.readMoving();
        bridgeGame.move(input);
        outputView.printMap(bridgeGame.getPlayerBridge());
    }

    /**
     *
     */
    public boolean checkGameOver() {
        return bridgeGame.checkGameOver();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return true - 재시작
     * false-  게임 종료
     */
    public boolean retry() {
        outputView.printInputRetry();
        String input = inputView.readGameCommand();
        return bridgeGame.retry(input);
    }

    /**
     * 게임에서 승리했는지 체크하는 메소드
     *
     * @return true - 승리
     * false - 패배
     */
    public boolean checkGameWin() {
        return bridgeGame.checkGameWin();
    }

    /**
     * 게임 종료시 처리하는 메서드
     */
    public void gameOver(boolean gameWin) {
        outputView.printResult(bridgeGame.getPlayerBridge(), bridgeGame.getTryCount(), gameWin);
    }

    /**
     * 전체 게임 동작 관리를 위해 사용하는 메서드
     */
    public void startGame() {
        outputView.printStartGame();
        buildBridge();
        boolean gameWin = false;
        while (!gameWin) {
            move();
            if (!checkGameOver()) {
                gameWin = checkGameWin();
                continue;
            }
            if (!retry()) break;
        }
        gameOver(gameWin);
    }
}
