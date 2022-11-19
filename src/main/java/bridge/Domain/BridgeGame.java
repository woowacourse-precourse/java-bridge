package bridge.Domain;

import bridge.EnumCollections.BridgeResultType;
import bridge.EnumCollections.BridgeType;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int gameStartCount;
    private Player player;
    private Bridge bridge;
    private GameResult gameResult;
    private GameResultGenerator gameResultGenerator;

    public BridgeGame(Bridge bridge) {
        this.gameStartCount = 1;
        this.player = new Player();
        this.bridge = bridge;
        this.gameResultGenerator = new GameResultGenerator();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String position) {
        BridgeType positionType = BridgeType.getBridgeType(position);
        int distance = player.getPosition();
        player.movePlayer();
        if (bridge.isValidDistance(distance) && bridge.canCrossBridge(distance, position)) {
            this.gameResult = new GameResult(positionType, BridgeResultType.POSSIBLE);
            return;
        }
        this.gameResult = new GameResult(positionType, BridgeResultType.IMPOSSIBLE);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.gameStartCount++;
        gameResultGenerator.initGameResult();
        player.initPosition();
    }

    public int getGameStartCount() {
        return this.gameStartCount;
    }

    public String getBridgeStatusAfterMove() {
        return gameResultGenerator.getBridgeStatus(gameResult);
    }

    public String getBridgeResult() {
        return gameResultGenerator.getGameResultOutput();
    }

    public boolean isBridgeFinished() {
        return player.isPlayerInEndOfBridge(bridge);
    }

    public boolean isMoveSuccess() {
        return gameResult.isGameSuccess();
    }
}
