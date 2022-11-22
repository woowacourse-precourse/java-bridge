package bridge.entity.BridgeGame;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.data.entity.BridgeGame;
import bridge.type.FailMenuCommandType;
import bridge.type.InGameCommandType;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("다리 건너기 게임에서 종료/재시작할 땐")
public class BridgeGameRetryTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        bridgeGame = new BridgeGame(Arrays.asList("DUU".split("")));
    }

    @DisplayName("죽은 상태로 재시작 하는 건 성공해야 한다.")
    @Test
    void retryWhileDeadTest() {
        bridgeGame.move(InGameCommandType.MOVE_UP);
        bridgeGame.retry(FailMenuCommandType.RETRY);
    }

    @DisplayName("죽은 상태로 중도포기 하는 건 성공해야 한다.")
    @Test
    void quitWhileDeadTest() {
        bridgeGame.move(InGameCommandType.MOVE_UP);
        bridgeGame.retry(FailMenuCommandType.QUIT);
    }

    @DisplayName("산 상태로 재시작 하는 건 실패해야 한다.")
    @Test
    void retryWhileAliveTest() {
        bridgeGame.move(InGameCommandType.MOVE_DOWN);
        assertThatThrownBy(() -> bridgeGame.retry(FailMenuCommandType.RETRY))
                .isInstanceOf(IllegalStateException.class)
        ;
    }

    @DisplayName("산 상태로 중도포기 하는 건 실패해야 한다.")
    @Test
    void quitWhileAliveTest() {
        assertThatThrownBy(() -> bridgeGame.retry(FailMenuCommandType.QUIT))
                .isInstanceOf(IllegalStateException.class)
        ;
    }
}
