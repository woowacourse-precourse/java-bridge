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

    public void generateBridge(final int bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public void move(final String sideToMove) {
        this.player.move(sideToMove);
        updateMap();
    }

    public boolean isPlayerInMovableSide() {
        return this.bridge.isMovableSide(
                this.player.getLastMoving(),
                this.player.getCurrentPosition()
        );
    }

    public boolean retry(final String gameCommand) {
        if (gameCommand.equals(AvailableInput.RETRY_COMMAND.getUserInput())) {
            initialize_game();
            addTrial();
            return true;
        }
        return false;
    }

    public GameStatus getGameStatus() {
        if (this.bridge.isLastPosition(this.player.getCurrentPosition())) {
            return GameStatus.SUCCESS;
        }
        return GameStatus.CONTINUE;
    }

    public String getTrial() {
        return Integer.toString(this.trial);
    }

    public List<List<String>> getMap() {
        return this.map.get();
    }

    private void initialize_game() {
        this.player.initializePosition();
        this.map.initialize();
    }

    private void updateMap() {
        this.map.add(
                Side.get(player.getLastMoving()),
                isPlayerInMovableSide()
        );
    }

    private void addTrial() {
        this.trial++;
    }
}