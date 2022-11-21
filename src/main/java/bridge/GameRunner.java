package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 실행하는 클래스
 */
public class GameRunner {

    enum StepType { NORMAL, RETRY }

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
        tryOneStep();
        while (bridgeGame.isMoveWrong()) {
            guideRetry();
            String gameCommand = getGameCommand();
            if(!isRetryCommand(gameCommand)) return;
            this.numberOfTry++;
            retryOneStep();
        }
        if(!bridgeGame.isEnd()) runLoop();
    }

    private void tryOneStep() { tryOneStep(StepType.NORMAL); }

    private void retryOneStep() { tryOneStep(StepType.RETRY); }

    private void tryOneStep(StepType stepType) {
        outputView.guideMovingCommandInput();
        if(stepType == StepType.NORMAL) bridgeGame.move();
        if(stepType == StepType.RETRY) bridgeGame.retry();
        bridgeGame.printMap();
    }

    private void guideRetry() { outputView.guideGameCommandInput(); }

    private String getGameCommand() { return inputView.readGameCommand(); }

    private boolean isRetryCommand(String gameCommand) { return gameCommand.equals("R"); }
}
