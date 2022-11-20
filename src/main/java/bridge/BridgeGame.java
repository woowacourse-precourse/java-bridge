package bridge;

import enumCollections.GameStatus;

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

    private GameStatus move() {
        player.move();
        if (bridge.getLastIndex() == player.getNextPosition()) {
            return GameStatus.SUCCESS;
        }
        return GameStatus.CONTINUE;
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
        return bridge.isNextAvailable(squareToMove, player.getNextPosition());
    }

    public void retry() {
        player = new Player();
    }
}
