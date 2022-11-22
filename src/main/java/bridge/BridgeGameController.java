package bridge;

public class BridgeGameController {
    private BridgeGame bridgeGame;

    public void run() {
        setGame();
        processGame();
    }

    private void setGame() {
        int size = Integer.parseInt(InputView.readBridgeSize());
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(size));
    }

    public void processGame() {
        for (int index = 0; index < bridgeGame.getBridgeSize(); index++) {
            if (!bridgeGame.move(index, InputView.readMoving()))
                break;
            OutputView.printMap(bridgeGame.getBridge(), bridgeGame.getResultBridge());
        }
        if (bridgeGame.getBridgeSize() != bridgeGame.getResultBridgeSize())
            retry();

    }
    private void retry() {
        if(InputView.readGameCommand().equals("R")) {
            bridgeGame.retry();
            processGame();
        }
    }
}