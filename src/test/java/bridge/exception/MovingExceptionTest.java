package bridge.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MovingExceptionTest {

    @DisplayName("입력이 U나 D가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest(name = "{index} {displayName} moving : {0}")
    @ValueSource(strings = {"u", "d", "가나", "test", "!@#"})
    void movingIsNotUorD(String moving) {
        assertThatThrownBy(() -> MovingException.validate(moving))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
