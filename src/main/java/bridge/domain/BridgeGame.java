package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.GameCommand;
import java.util.List;

public class BridgeGame {
    private List<String> bridge;
    private int trials;
    private int currentPosition;
    private int bridgeSize;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    public BridgeGame(int bridgeSize) {
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
        this.trials = 1;
        this.bridgeSize = bridgeSize;
        this.currentPosition = 0;
    }

    public boolean move(String moving) {
        return bridge.get(currentPosition++).equals(moving);
    }

    public boolean retry(String gameCommand) {
        if (gameCommand.equals(GameCommand.R.toString())) {
            trials++;
            currentPosition = 0;
            return true;
        }
        return false;
    }

    public boolean isPlaying() {
        return (currentPosition < bridgeSize);
    }

    public String getMap() {
        return null;
    }

    public int getTrials() {
        return trials;
    }
}
