package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.BridgeNumberGenerator;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void init_Test() {
        bridgeGame = new BridgeGame(3, new BridgeStaticNumberGenerator());
    }

    @ParameterizedTest(name = "{0}로 이동 -> {1}")
    @CsvSource(value = {"U,'[ O ]\n[   ]'", "D,'[   ]\n[ X ]'"})
    @DisplayName("입력된 방향으로 이동하면 결과를 가진 지도를 반환한다.")
    void move_RunMove_ReturnMessage(Direction direction, String message) {
        assertThat(bridgeGame.move(direction)).isEqualTo(message);
    }

    @Test
    @DisplayName("잘못된 위치에서 재시도하면 예외가 발생한다.")
    void retry_MisuseRetryMethod_ExceptionThrown() {
        assertThatThrownBy(() -> bridgeGame.retry()).isInstanceOf(EmptyStackException.class);
    }

    private class BridgeStaticNumberGenerator implements BridgeNumberGenerator {
        int count = 0;

        @Override
        public int generate() {
            if (count++ % 2 == 0) {
                return 1;
            }
            return 0;
        }
    }
}