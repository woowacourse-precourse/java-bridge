package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class BridgeMoveLogTest {

    private final BridgeMoveLog bridgeMoveLog = new BridgeMoveLog(10);

    @BeforeEach
    public void 초기화() {
        bridgeMoveLog.resetLog();
    }

    @EnumSource(GameStatus.class)
    @ParameterizedTest
    public void 로그_작성(GameStatus gameStatus) {
        bridgeMoveLog.writeLog(BridgeType.UP_BRIDGE, gameStatus.getSafe());
        List<String> log = bridgeMoveLog.getMoveLog().get(BridgeType.UP_BRIDGE);
        assertThat(log.size()).isEqualTo(1);
        assertThat(log.get(0)).isEqualTo(gameStatus.getSafe());
    }

    @Test
    public void 초기화_직후() {
        for (List<String> log : bridgeMoveLog.getMoveLog().values()) {
            assertThat(log.size()).isEqualTo(0);
        }
    }
}