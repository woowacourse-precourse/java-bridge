package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandTest {

    @DisplayName("GameCommand 를 문자열로 생성하는 테스트")
    @Nested
    class GameCommandOf {
        @ParameterizedTest(name = "올바른 값이 아닌 경우 예외 처리한다.")
        @NullAndEmptySource
        @ValueSource(strings = {" ", "r", "q", "RQ", "QR", "RETRY", "QUIT", "ABC"})
        void gameCommandOfNoSuchValue(String command) {
            assertThatThrownBy(() -> GameCommand.of(command)).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("GameCommand 문자로 BridgeShape 를 생성한다.")
        @Test
        void gameCommandOf() {
            assertAll(
                    () -> assertThat(GameCommand.of("R")).isEqualTo(GameCommand.RETRY),
                    () -> assertThat(GameCommand.of("Q")).isEqualTo(GameCommand.QUIT)
            );
        }
    }

    @DisplayName("GameCommand 가 Retry 인지 boolean 값을 반환한다.")
    @Test
    void isRetry() {
        assertAll(
                () -> assertThat(GameCommand.of("R").isRetry()).isTrue(),
                () -> assertThat(GameCommand.RETRY.isRetry()).isTrue(),
                () -> assertThat(GameCommand.of("Q").isRetry()).isFalse(),
                () -> assertThat(GameCommand.QUIT.isRetry()).isFalse()
        );
    }
}
