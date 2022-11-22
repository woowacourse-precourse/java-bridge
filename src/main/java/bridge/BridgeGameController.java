package bridge;
import java.util.List;
public class BridgeGameController {
    InputView  inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bridgeGame;
    private int tryCount = 0;
    public void startService() {
        outputView.printGameStart();
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        gameProcess(bridge);
    }
    public void gameProcess(List<String> bridge) {
        boolean gameContinueStatus = true;
        while (gameContinueStatus) {
            gameContinueStatus = checkIfContinue(bridge);
        }
    }
    public boolean checkIfContinue (List<String> bridge) {
        bridgeGame = new BridgeGame(bridge);
        if (!tryMoves(0, bridge)) {
            return gameEndSelect();
        }
        return false;
    }
    private boolean gameEndSelect() {
        if (!bridgeGame.retry(inputView.readGameCommand())) {
            outputView.printResult(this, bridgeGame,false);
            return false;
        }
        return true;
    }
    public boolean tryMoves(int moveValue, List<String> bridge) {
        tryCount++;
        return moveProcess(moveValue, bridge);
    }
    private boolean moveProcess(int moveValue, List<String> bridge) {
        while (moveValue < bridge.size()) {
            String moves = inputView.readMoving();
            outputView.printMap(bridgeGame.move(moveValue++,moves));
            if(!bridgeGame.getAvailableToMove()) {
                return false;
            }
        }
        outputView.printResult(this,bridgeGame,true);
        return true;
    }
    public int getTryCount() {
        return tryCount;
    }
}
