package bridge.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BridgeGameMoveInfoTest {
    @Test
    void check_moveInfo_null_test() {
        final BridgeGameMoveInfo moveInfo = new BridgeGameMoveInfo();
        try {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> moveInfo.moveInfo(null, true));
            moveInfo.moveInfo(null, true);
        } catch (final IllegalArgumentException expected) {
            assertThat(expected.getMessage()).isEqualTo("다음 위치에 null 이 들어올 수 없습니다");
        }
    }

}