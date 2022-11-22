package bridge;

import java.util.List;


public class BridgeGame {

    public enum GameStatus {
        WIN("WIN"),
        SAFE("SAFE"),
        R("RETRY");
        private String status;
        private GameStatus(String status) {
            this.status = status;
        }
    }

    
    public String move(List<String> bridge, String moving, int gameNumber) {
        if (isSafePlate(moving, bridge.get(gameNumber))) {
            if (isGameWin(bridge.size(), gameNumber)) {
                return GameStatus.WIN.status;
            }
            return GameStatus.SAFE.status;
        }
        return retry();
    }


   
    public String retry() {
        return GameStatus.R.status;
    }

    private boolean isSafePlate(String moving, String bridge) {
        if (moving.equals(bridge)) {
            return true;
        }
        return false;
    }

    private boolean isGameWin(int bridgeSize, int gameNumber) {
        if ((bridgeSize - 1) == gameNumber) {
            return true;
        }
        return false;
    }
}
