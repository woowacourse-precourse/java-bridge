package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    private BridgeGame bridgeGame = new BridgeGame();
    private UserBridge userBridge = new UserBridge();
    private static Direction[] directions = {Direction.D, Direction.D, Direction.U, Direction.U};
    private static Direction[] now = {Direction.D, Direction.U, Direction.U, Direction.D};

    @Test
    void 이동_테스트() {
        Direction[] directions = {Direction.D, Direction.D, Direction.U, Direction.U};
        Direction[] now = {Direction.D, Direction.U, Direction.U, Direction.D};
        UserBridge result = new UserBridge();

        for (int i = 0; i < 4; i++) {
            moveResult(result, i);
            bridgeGame.move(userBridge, directions[i], now[i]);
        }

        assertThat(userBridge).isEqualTo(result);
    }

    @Test
    void 재시작_테스트() {
        BridgeGameManager bridgeGameManager = new BridgeGameManager();
        int count = bridgeGameManager.getCount();
        bridgeGame.retry(bridgeGameManager, userBridge, "R");

        assertThat(userBridge.getUpBridge().isEmpty()).isTrue();
        assertThat(userBridge.getDownBridge().isEmpty()).isTrue();
        assertThat(bridgeGameManager.getCount()).isEqualTo(count+1);
    }

    private static void moveResult(UserBridge result, int i) {
        if (now[i].equals(Direction.D)) {
            result.moveDownBridge(directions[i]);
        }
        if (now[i].equals(Direction.U)) {
            result.moveUpBridge(directions[i]);
        }
        result.addBlank(now[i]);
    }
}
