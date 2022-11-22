package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeMovement;
import bridge.domain.GameCommand;
import bridge.domain.GameStatus;
import bridge.domain.Player;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private final Player player;
    private Bridge bridge;
    private int numberOfAttempts;

    public BridgeGame(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
        player = new Player();
        numberOfAttempts = 1;
    }

    public void createBridge(int bridgeSize) {
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public String crossResult() {
        return player.toString();
    }

    public GameStatus move(BridgeMovement playerMove) {
        boolean playerCrossable = bridge.isCrossable(playerMove, player.getPlayerPosition());
        player.crossBridge(playerMove, playerCrossable);
        boolean isReachedBridge = bridge.isReachedTheEnd(player.getPlayerPosition());
        return GameStatus.findByStatus(playerCrossable, isReachedBridge);
    }

    public GameStatus retry(GameCommand command) {
        if (command == GameCommand.RETRY) {
            player.reset();
            numberOfAttempts += 1;
            return GameStatus.PLAYING;
        }
        return GameStatus.FAILED;
    }

}
