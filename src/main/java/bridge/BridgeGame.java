package bridge;

import enumCollections.AvailableInput;
import enumCollections.GameStatus;
import enumCollections.Side;

public class BridgeGame {
    private final int INITIALIZED_TRIAL = 1;
    private Bridge bridge;
    private Player player;
    private Map map;
    private int trial;

    public BridgeGame() {
        this.player = new Player();
        this.map = new Map();
        this.trial = INITIALIZED_TRIAL;
    }

    public void generateBridge(int bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public void move(String sideToMove) {
        player.move(sideToMove);
    }

    public boolean isPlayerInRightSide() {
        return bridge.isMovable(
                player.getLastMoving(),
                player.getCurrentPosition()
        );
    }

    public GameStatus retry(String gameCommand) {
        if (gameCommand.equals(AvailableInput.get(AvailableInput.RESTART_GAME))) {
            player.initializePosition();
            map.initialize();
            addTrial();
            return GameStatus.CONTINUE;
        }
        return GameStatus.FAILURE;
    }

    public GameStatus isSuccess() {
        if (bridge.isLastPosition(player.getCurrentPosition())) {
            return GameStatus.SUCCESS;
        }
        return GameStatus.CONTINUE;
    }

    public Side getCurrentAvailableSide() {
        String sideSymbol = bridge.getMovableSide(player.getCurrentPosition());
        return Side.getPosition(sideSymbol);
    }

    public String getTrial() {
        return Integer.toString(this.trial);
    }

    private void addTrial() {
        this.trial++;
    }

    public void updateMap() {
        this.map.add(getCurrentAvailableSide(), isPlayerInRightSide());
    }

    public Map getMap() {
        return this.map;
    }
}
