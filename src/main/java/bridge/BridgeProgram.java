package bridge;

public class BridgeProgram {

    private OutputView outputView;
    private InputView inputView;

    private BridgeGame bridgeGame;

    public void start() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.bridgeGame = new BridgeGame();
        bridgeGame.init();
        outputView.printGameStart();
        outputView.printReadBridgeLength();
        bridgeGame.setBridgeSize(inputView.readBridgeSize());
    }

    /**
     * 게임을 진행하는 핵심 루프
     */
    public void loop() {
        while (!bridgeGame.isFinished()) {
            outputView.printReadNextBridgeStep();
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame);
            if (bridgeGame.aborted()) {
                outputView.printRestart();
                bridgeGame.retry(inputView.readGameCommand());
            }
        }
    }

    /**
     * 게임을 마무리 짓고 결과를 출력하는 루프
     */
    public void finish() {
        outputView.printTotalMap(bridgeGame);
        outputView.printResult(bridgeGame.succeed(), bridgeGame.getTries());
    }
}
