package bridge.controller;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.model.BridgeGame;

public class BridgeGameController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private BridgeGame bridgeGame;
    public void runGame() {
        outputView.printStart();
        bridgeGame = new BridgeGame(inputView.readBridgeSize());
        while (check()){
          move();
        }
        outputView.printResult(bridgeGame.getUserBridge(), bridgeGame.getGameSuccess(), bridgeGame.getTryCount());
    }

    public void move(){
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.getUserBridge());
    }

    public boolean check(){
        if (bridgeGame.isGameOver()){
            bridgeGame.retry(inputView.readGameCommand());
            return !bridgeGame.isGameOver();
        }
        return !bridgeGame.gameSuccessCheck();
    }
}
