package bridge;

import java.util.List;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;
    private BridgeNumberGenerator bridgeNumberGenerator;
    private InputView inputView;
    private OutputView outputView;
    private STATUS status;
    private int totalTries;

    public BridgeGameController() {
    }

    public void init() {
        this.status = STATUS.RUNNING;
        this.bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(this.bridgeNumberGenerator);
        this.inputView = new InputView();
        this.outputView = new OutputView();
        run();
        outputView.printResult(bridgeGame.getUps(), bridgeGame.getDowns(), status.getSuccess(), totalTries);
    }

    public void run() {
        this.totalTries = 0;
        setBridgeGame();
        while(status == STATUS.RUNNING) {
            totalTries++;
            while (status == STATUS.RUNNING)
                moves();
            checkContinue();
        }
    }

    public void setBridgeGame() {
        outputView.printGreeting();
        int size = inputView.readBridgeSize();
        this.bridgeGame = new BridgeGame(this.bridgeMaker, size);
    }

    public void moves() {
        System.out.println();
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.getUps(), bridgeGame.getDowns());
        status = bridgeGame.getStatus();
    }
    public void checkContinue() {
        if (status == STATUS.END_WITH_SUCCESS) {
            return;
        }
        boolean keepRunning = inputView.readGameCommand();
        if (keepRunning) {
            status = STATUS.RUNNING;
            bridgeGame.retry();
        }
    }
}
