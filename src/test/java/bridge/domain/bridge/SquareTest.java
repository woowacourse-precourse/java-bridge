package bridge.domain.bridge;

import bridge.exception.BridgeError;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SquareTest {

    @DisplayName("이동 칸 예외 테스트")
    @Nested
    class Exception {

        @DisplayName("숫자, 특수문자, U와 D 제외 문자, 소문자가 들어오는 경우 예외를 발생시킨다.")
        @ParameterizedTest
        @ValueSource(strings = {"1", "1$", "U D", "C", " ", "u", "d"})
        void validateChar(String move) {
            Assertions.assertThatThrownBy(() -> Square.of(move))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(BridgeError.MOVE_FORM.message());
        }

        @DisplayName("한 개의 입력이 들어오지 않는 경우 예외를 발생시킨다.")
        @ParameterizedTest
        @ValueSource(strings = {"UU", "DD", "UD"})
        void validateSize(String move) {
            Assertions.assertThatThrownBy(() -> Square.of(move))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(BridgeError.MOVE_SIZE.message());
        }
    }
}