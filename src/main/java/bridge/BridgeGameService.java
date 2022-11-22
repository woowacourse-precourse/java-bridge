package bridge;

public class BridgeGameService {
    OutputView outputView;
    InputView inputView;
    BridgeGame bridgeGame;

    public BridgeGameService(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() throws IllegalArgumentException {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.outputView.printStart();
        int bridgeSize = makeBridge();
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize));
        this.bridgeGame = bridgeGame;
        while (runBridgeMove()) ;
        outputView.printResult(bridgeGame);
    }

    public int makeBridge() {
        this.outputView.printBridgeMake();
        return this.inputView.readBridgeSize();
    }

    public boolean runBridgeMove() throws IllegalArgumentException {
        this.outputView.printMove();
        String nextMove = this.inputView.readMoving();
        int moveResult = this.bridgeGame.move(nextMove);
        this.outputView.printMap(this.bridgeGame);
        if (moveResult == -1) {
            return runBridgeRetry();
        }
        return moveResult != 1;
    }

    public boolean runBridgeRetry() throws IllegalArgumentException {
        this.outputView.printRetry();
        String gameComand = this.inputView.readGameCommand();
        if (gameComand.equals("Q")) {
            return false;
        }
        bridgeGame.retry();
        return true;
    }

}




