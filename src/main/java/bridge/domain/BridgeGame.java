package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.domain.map.BridgeMap;
import java.util.List;

public class BridgeGame {

    private static final String YES = "R";

    private final Bridge bridge;
    private Player player;
    private int trialCount;
    private BridgeMap bridgeMap;

    public BridgeGame(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridge = new Bridge(size, bridgeNumberGenerator);
        this.player = new Player();
        this.trialCount = 1;
        this.bridgeMap = new BridgeMap();
    }

    public void move(String selection) {
        player.updateSelection(selection);
        makeMap(selection, isCorrect());
        updatePlayerPosition(isCorrect());
    }

    private void makeMap(String selection, boolean result) {
        bridgeMap.addResult(selection, result);
    }

    private boolean isCorrect() {
        String answer = bridge.getStep(player.getPosition());
        return player.matches(answer);
    }

    private void updatePlayerPosition(boolean correct) {
        if (correct) {
            player.updatePosition();
        }
        if (!correct) {
            player.die();
        }
    }

    public boolean isGameEnd() {
        if (!isPlayerAlive() || isFinalStage()) {
            return true;
        }
        return false;
    }

    public BridgeMap getMap() {
        return bridgeMap;
    }

    public void retry(String playerChoice) {
        if (playerChoice.equals(YES)) {
            this.player = new Player();
            this.trialCount++;
            bridgeMap.init();
        }
    }

    public boolean isFinalStage() {
        return bridge.isFinal(player.getPosition());
    }

    public boolean isPlayerAlive() {
        return player.isAlive();
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