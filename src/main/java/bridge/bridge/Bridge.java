package bridge.bridge;

import bridge.config.BridgeStatus;
import bridge.config.GameResultStatus;

import java.util.ArrayList;
import java.util.List;

import static bridge.config.GameResultStatus.X;

public class Bridge {

    private List<BridgeStatus> bridge;
    private List<GameResultStatus> gameResultStatuses;
    private int size;
    private int position;

    public Bridge(int size) {
        this.bridge = new ArrayList<>(size);
        InitGameResultStatuses();
        this.size = size;
        this.position = 0;
    }

    public List<BridgeStatus> getBridge() {
        return bridge;
    }

    public List<BridgeStatus> setBridge(List<BridgeStatus> bridge) {
        this.bridge = bridge;
        return bridge;
    }

    public void InitGameResultStatuses() {
        for (int i = 0; i < size;i++) {
            this.getGameResultStatuses().add(X);
        }
    }

    public List<GameResultStatus> getGameResultStatuses() {
        return gameResultStatuses;
    }

    public int getPosition() {
        return this.position;
    }

    public void movePosition() {
        if (this.position < this.size) {
            this.position++;
        }
    }


}
