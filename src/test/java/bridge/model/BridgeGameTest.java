package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private final BridgeMoveLog bridgeMoveLog = new BridgeMoveLog(3);

    private final BridgeGame bridgeGame = new BridgeGame(List.of("U", "U", "U"), bridgeMoveLog);

    @BeforeEach
    public void 로그_초기화() {
        bridgeMoveLog.resetLog();
    }

    @Test
    public void 이동_완료() {
        assertThat(bridgeGame.move(BridgeType.UP_BRIDGE)).isEqualTo(GameStatus.CROSSING);
        assertThat(bridgeGame.move(BridgeType.UP_BRIDGE)).isEqualTo(GameStatus.CROSSING);
        assertThat(bridgeGame.move(BridgeType.UP_BRIDGE)).isEqualTo(GameStatus.SUCCESS);

        for (String log : bridgeMoveLog.getMoveLog().get(BridgeType.UP_BRIDGE)) {
            assertThat(log).isEqualTo("O");
        }

        for (String log : bridgeMoveLog.getMoveLog().get(BridgeType.DOWN_BRIDGE)) {
            assertThat(log).isEqualTo(" ");
        }
    }

    @Test
    public void 이동_실패() {
        assertThat(bridgeGame.move(BridgeType.DOWN_BRIDGE)).isEqualTo(GameStatus.FAIL);
        assertThat(bridgeMoveLog.getMoveLog().get(BridgeType.DOWN_BRIDGE).get(0)).isEqualTo("X");
    }

    @Test
    public void 재시도() {
        assertThat(bridgeGame.getTryCount()).isEqualTo(1);
        bridgeGame.retry();
        assertThat(bridgeGame.getTryCount()).isEqualTo(2);
    }

}