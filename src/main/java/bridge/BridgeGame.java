package bridge;

import java.util.List;

public class BridgeGame {
    private final List<String> bridge;
    public int playerLocation = -1;
    private int trial = 1;


    public BridgeGame(List<String> bridge) {;
        this.bridge = bridge;
    }

    public void move(String playerMoving) {
        if (bridge.get(playerLocation + 1).equals(playerMoving)) {
            this.playerLocation++;
        }
    }

    public void retry(String gameCommand) {
        if (gameCommand.equals("R")) {
            trial++;
        }
    }

    public Boolean checkMoveIsAvailable (String playerMoving) {
        if (bridge.get(playerLocation+1).equals(playerMoving)) {
            return true;
        }
        if (!bridge.get(playerLocation+1).equals(playerMoving)) {
            return false;
        }
        return null;
    }

    public Boolean checkPlayerWantsRetrial (String gameCommand) {
        if (gameCommand.equals("R")) {
            return true;
        }
        if (gameCommand.equals("Q")) {
            return false;
        }
        return null;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public int getPlayerLocation() {
        return this.playerLocation;
    }

    public int getTrial() {
        return this.trial;
    }
}
