package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class GameRunner {
    private final static OutputView outputView = new OutputView();
    private final static InputView inputView = new InputView();

    private static BridgeGame bridgeGame;

    private int numberOfTry;

    public GameRunner(List<String> bridge) {
        bridgeGame = new BridgeGame(bridge);
        this.numberOfTry = 1;
    }

    /**
     * 게임을 실행하는 메소드
     */
    public void run() {
        runLoop();
        bridgeGame.printResult(this.numberOfTry);
    }

    private void runLoop() {
        playOneStep();
        while (bridgeGame.isMoveWrong()) {
            guideRetry();
            if(!isRetryCommand(getGameCommand())) return;
            retryOneStep();
        }
        if(!bridgeGame.isEnd()) runLoop();
    }

    private void playOneStep() {
        outputView.guideMovingCommandInput();
        bridgeGame.move();
        bridgeGame.printMap();
    }

    private void retryOneStep() {
        this.numberOfTry++;
        outputView.guideMovingCommandInput();
        bridgeGame.retry();
        bridgeGame.printMap();
    }

    private void guideRetry() { outputView.guideRetry(); }

    private String getGameCommand() { return inputView.readGameCommand(); }

    private boolean isRetryCommand(String gameCommand) { return gameCommand.equals("R"); }
}
