package bridge;

import java.util.List;

public class BridgeGameInfo {
    private List<String> bridge;
    private int player;
    private int trial;

    BridgeGameInfo(int size){
        this.bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        this.player = -1;
        this.trial = 0;
    }

    public int getPlayer() {
        return player;
    }

    public int getTrial() {
        return trial;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public void setTrial(int trial) {
        this.trial = trial;
    }
}
