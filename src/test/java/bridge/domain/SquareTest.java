package bridge.domain;

import bridge.domain.bridge.Square;
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
            Assertions.assertThatThrownBy( () -> new Square(move))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 이동할 칸은 U와 D 문자만 입력 가능합니다.");
        }

        @DisplayName("한 개의 입력이 들어오지 않는 경우 예외를 발생시킨다.")
        @ParameterizedTest
        @ValueSource(strings = {"UU", "DD", "UD"})
        void validateSize(String move) {
            Assertions.assertThatThrownBy( () -> new Square(move))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 이동할 칸은 U와 D 중에 하나만 입력 가능합니다.");
        }
    }
}