package bridge.domain;

import bridge.BridgeNumberGenerator;
import java.util.List;

public class BridgeGame {


    private Bridge bridge;
    private Player player;
    private int trialCount;
    private int stage;

    public BridgeGame(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridge = new Bridge(size, bridgeNumberGenerator);
        this.player = new Player();
        this.trialCount = 1;
        this.stage = 0;
    }

    public void move(String playerChoice) {
        player.updateSelection(playerChoice);
        String answer = bridge.getStep(player.getPosition());
        if (!answer.equals(player.getLastSelection())) {
            player.die();
        }
    }

    public void retry() {
        this.player = new Player();
        this.trialCount++;
        this.stage = 0;
    }

    public boolean isGameEnd() {
        return bridge.get().size() == player.getPosition();
    }

    public boolean isPlayerAlive() {
        return player.isAlive();
    }

    public void nextRound() {
        if (player.isAlive()) {
            player.updatePosition();
            stage = player.getPosition();
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

    public int getStageNumber() {
        if (isGameEnd()) {
            stage = player.getPosition() - 1;
        }
        return stage;
    }
}