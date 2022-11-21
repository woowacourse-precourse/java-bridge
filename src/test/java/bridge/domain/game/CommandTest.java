package bridge.domain.game;

import bridge.exception.BridgeError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandTest {

    @DisplayName("명령어 예외 테스트")
    @Nested
    class Exception {

        @DisplayName("숫자, 특수문자, R와 Q 제외 문자, 소문자가 들어오는 경우 예외를 발생시킨다.")
        @ParameterizedTest
        @ValueSource(strings = {"1", "1$", "U D", "C", " ", "r", "q"})
        void validateChar(String command) {
            assertThatThrownBy( () -> new Command(command))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(BridgeError.COMMAND_FORM.message());
        }

        @DisplayName("명령어가 두 개 이상인 경우 예외를 발생시킨다.")
        @ParameterizedTest
        @ValueSource(strings = {"RR", "RQ", "QQ", "RQQ"})
        void validateSize(String command) {
            assertThatThrownBy( () -> new Command(command))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(BridgeError.COMMAND_SIZE.message());
        }
    }
}