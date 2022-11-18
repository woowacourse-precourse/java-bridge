package bridge.domain;

import bridge.BridgeNumberGenerator;
import java.util.List;

public class BridgeGame {


    private Bridge bridge;
    private Player player;
    private int trialCount;

    public BridgeGame(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridge = new Bridge(size, bridgeNumberGenerator);
        this.player = new Player();
        this.trialCount = 1;
    }

    public void move(String playerChoice) {
        player.updateSelection(playerChoice);
        String answer = bridge.getStep(player.getPosition());
        if (!answer.equals(player.getLastSelection())) {
            player.dead();
        }
    }

    public void retry() {
        this.player = new Player();
        this.trialCount++;
    }

    public boolean isGameEnd() {
        return bridge.get().size() == player.getPosition();
    }

    public boolean isPlayerAlive() {
        return player.isAlive();
    }

    public void updatePlayer() {
        if (player.isAlive()) {
            player.updatePosition();
        }
    }

    public int getTrialCount() {
        return this.trialCount;
    }

    public Player getPlayer() {
        return this.player;
    }

    public List<String> getBridge() {
        return this.bridge.get();
    }
}
