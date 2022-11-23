package bridge.Domain;

import bridge.EnumCollections.BridgeResultType;
import bridge.EnumCollections.BridgeType;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int gameStartCount;
    private Player player;
    private GameResult gameResult;
    private GameResultGenerator gameResultGenerator;

    public BridgeGame(Player player , GameResultGenerator gameResultGenerator) {
        this.gameStartCount = 1;
        this.player = player;
        this.gameResultGenerator = gameResultGenerator;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String position) {
        player.movePlayer();
        if (player.isPlayerMoveSuccess(position)) {
            this.gameResult = new GameResult(BridgeType.getBridgeType(position), BridgeResultType.POSSIBLE);
            return;
        }
        this.gameResult = new GameResult(BridgeType.getBridgeType(position), BridgeResultType.IMPOSSIBLE);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.gameStartCount++;
        gameResultGenerator.initGameResult();
        player.initDistance();
    }

    public int getGameStartCount() {
        return this.gameStartCount;
    }

    public String getBridgeStatusAfterMove() {
        return gameResultGenerator.getBridgeStatus(gameResult);
    }

    public boolean isMoveSuccess() {
        return gameResult.isMoveSuccess();
    }
}
