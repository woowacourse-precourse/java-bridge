package bridge;

public class BridgeGameRunner {
    private InputView input;
    private OutputView output;
    BridgeGame game;

    /**
     * 생성자
     */
    public BridgeGameRunner() {
        input = new InputView();
        output = new OutputView();
        game = new BridgeGame();
    }

    /**
     * 브릿지 게임의 전체 프로세스를 진행하는 메서드
     */
    public void run() {
        output.printStartMessage();
        game.generateBridge(input.readBridgeSize());
        while (true) {
            repeatMove();
            if (game.isSuccess() || !askRetry()) {
                break;
            }
            game.retry();
        }
        output.printResult(game);
    }

    /**
     * 라운드를 다시 시도할건지 묻는 메서드
     *
     * @return 다시 시도한다면 true 아니라면 false
     */
    private boolean askRetry() {
        if (input.readGameCommand().equals(BridgeGame.CMD_RETRY)) {
            return true;
        }
        return false;
    }

    /**
     * 한 라운드가 끝날때까지 움직임을 반복하는 메서드
     */
    private void repeatMove() {
        while (game.isPlayerAlive() && !game.isSuccess()) {
            game.move(input.readMoving());
            output.printMap(game.getBridge());
        }
    }
}
