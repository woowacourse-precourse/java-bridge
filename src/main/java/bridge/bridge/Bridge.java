package bridge.bridge;

import bridge.config.BridgeStatus;
import bridge.config.GameResultStatus;
import bridge.config.GameStatus;

import java.util.ArrayList;
import java.util.List;

import static bridge.config.GameResultStatus.X;
import static bridge.config.GameStatus.FAIL;

public class Bridge {

    private List<BridgeStatus> bridge = new ArrayList<>();
    private List<GameResultStatus> gameResultStatuses = new ArrayList<>();
    private int size;
    private int position;

    public Bridge(int size) {
        for (int i = 0; i < size;i++) {
            this.getGameResultStatuses().add(X);
        }
        this.size = size;
        this.position = 0;
    }

    public List<BridgeStatus> getBridge() {
        return bridge;
    }

    public void InitGameResultStatuses() {

    }

    public List<GameResultStatus> getGameResultStatuses() {
        return gameResultStatuses;
    }

    public int getPosition() {
        return this.position;
    }

    public void initPosition() {
        this.position = 0;
    }

    public void movePosition() {
        if (this.position < this.size) {
            this.position++;
        }
    }

    public int getSize() {
        return size;
    }
}
