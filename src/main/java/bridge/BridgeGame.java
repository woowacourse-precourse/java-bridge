package bridge;

import enumCollections.GameStatus;
import enumCollections.Side;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private Player player;
    private int trial;

    public BridgeGame() {
        this.player = new Player();
        this.trial = 0;
    }

    public void generateBridge(int bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public boolean move(String sideToMove) {
        boolean movable = bridge.isAvailableToMove(sideToMove, player.getNextPosition());

        if (movable) {
            player.move();
        }
        return movable;
    }

    public GameStatus tryMoveTo(String squareToMove) {
        addTrial();
        if (canMoveTo(squareToMove)) {
            return move();
        }
        return GameStatus.FAILURE;
    }

    private void addTrial() {
        this.trial++;
    }

    private boolean canMoveTo(String squareToMove) {
        return bridge.isAvailableToMove(squareToMove, player.getNextPosition());
    }

    public void retry() {
        player = new Player();
    }

    public int getCurrentPosition() {
        return player.getCurrentPosition();
    }

    public Side getAvailableSquare(int bridgeIndex) {
        return Side.getPosition(bridge.getMovableSide(bridgeIndex));
    }

    public String getTrial() {
        return Integer.toString(this.trial);
    }
}
