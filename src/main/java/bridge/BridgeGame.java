package bridge;

import enumCollections.AvailableInput;
import enumCollections.GameStatus;
import enumCollections.Side;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final int INITIALIZED_TRIAL = 1;
    private final Player player = new Player(new ArrayList<>());
    private final Map map = new Map();
    private Bridge bridge;
    private int trial;

    public BridgeGame() {
        this.trial = INITIALIZED_TRIAL;
    }

    private void addTrial() {
        this.trial++;
    }

    public void generateBridge(final int bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public void move(final String sideToMove) {
        player.move(sideToMove);
    }

    public boolean isPlayerInRightSide() {
        return bridge.isMovableSide(
                player.getLastMoving(),
                player.getCurrentPosition()
        );
    }

    public boolean retry(String gameCommand) {
        if (gameCommand.equals(AvailableInput.get(AvailableInput.RESTART_GAME))) {
            player.initializePosition();
            this.map.initialize();
            addTrial();
            return true;
        }
        return false;
    }

    public GameStatus getGameStatus() {
        if (bridge.isLastPosition(player.getCurrentPosition())) {
            return GameStatus.SUCCESS;
        }
        return GameStatus.CONTINUE;
    }

    public String getTrial() {
        return Integer.toString(this.trial);
    }

    public void updateMap() {
        this.map.add(
                Side.get(player.getLastMoving()),
                isPlayerInRightSide()
        );
    }

    public List<List<String>> getMap() {
        return this.map.get();
    }
}
