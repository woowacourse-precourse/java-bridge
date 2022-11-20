package bridge;

public class BridgeController {
    private OutputView outputView;
    private InputView inputView;
    private BridgeGame bridgeGame;

    public BridgeController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void setGame() {
        outputView.printStartMessage();

        int bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
    }

    public boolean proceedGame() {
        for (int index = 0; index < bridgeGame.getBridgeSize(); index++) {
            String moving = inputView.readMoving();
            if (bridgeGame.move(index, moving)) {
                outputView.printMap(bridgeGame.getResultBridge());
                continue;
            }
            outputView.printMap(bridgeGame.getResultBridge());
            return false;
        }
        return true;
    }

    public boolean setGameResult() {
        boolean gameResult = proceedGame();
        bridgeGame.setGameResult(gameResult);
        return gameResult;
    }

    public boolean isOver() {
        if(inputView.readGameCommand().equals("R")){
            bridgeGame.retry();
            return false;
        }
        return true;
    }

    public void exitGame(){
        outputView.printResult(bridgeGame.getResultBridge(), bridgeGame.getGameCount(), bridgeGame.getGameResult());
    }

    public void repeatGame(){
        do {
            if (this.setGameResult()) {
                break;
            }
        }
        while (!this.isOver());
    }
}
