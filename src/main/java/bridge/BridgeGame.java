package bridge;

import enumCollections.AvailableInput;
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

    public void move(String sideToMove) {
        player.move(sideToMove);
    }

    public boolean isPlayerInRightSide() {
        return bridge.isAvailableToMove(player.getLastMoving(), player.getCurrentPosition());
    }

    private void addTrial() {
        this.trial++;
    }

    public GameStatus retry(String gameCommand) {
        if (gameCommand.equals(AvailableInput.RESTART_GAME)) {
            player.initializePosition();
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

    public String getTrial() {
        return Integer.toString(this.trial);
    }

    public Side getCurrentAvailableSide() {
        String sideSymbol = bridge.getMovableSide(player.getCurrentPosition());
        return Side.getPosition(sideSymbol);
    }
}
