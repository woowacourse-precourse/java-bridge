package bridge;

import java.util.List;
import java.util.Map;

public class Player {

    private int currentPosition = -1;
    public boolean success = false;
    private int gameCount = 0;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public List<String> makeBridge(){
        int bridgeSize = getSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return bridge;
    }

    private int getSize(){
        return inputView.readBridgeSize();
    }

    public int getNextIdx() {
        currentPosition++;
        return currentPosition;
    }

    public String getNextSpot(){
        return inputView.readMoving();
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public boolean retry() {
        String command = inputView.readGameCommand();
        return command.equals("R");
    }

    public void currentPositionReset(){
        currentPosition = -1;
    }

    public boolean isSuccess() {
        return success;
    }

    public void increaseGameCount(){
        gameCount++;
    }

    public void printTotalScore(Map<String, String> lastMap) {
        outputView.printResult(lastMap, success, gameCount);
    }
}
