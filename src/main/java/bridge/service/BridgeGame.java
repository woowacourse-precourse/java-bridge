package bridge.service;

import bridge.model.Player;
import bridge.model.Result;
import java.util.List;

public class BridgeGame {
    private List<String> bridge;
    private Player player;

    public void start(List<String> bridge) {
        this.bridge = bridge;
        this.player = new Player();
    }

    public int move(String direction) {
        return player.move(bridge, direction);
    }

    public boolean retry(String text) {
        if (text.equals("R")) {
            player.upRetryCount();
            return true;
        }
        return false;
    }

    public List<Result> getGameResult() {
        return player.makeGameResult();
    }

    public int getRetryCount() {
        return player.getRetry();
    }

    public boolean isSuccess() {
        return player.lastResultIsSuccess();
    }
}
