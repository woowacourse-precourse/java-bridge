package bridge;

import java.util.List;

public class Player {

    private int currentPosition = -1;
    public boolean success = false;

    private final InputView inputView = new InputView();

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

    public void init(){
        currentPosition = -1;
    }

    public boolean isSuccess() {
        return success;
    }
}
