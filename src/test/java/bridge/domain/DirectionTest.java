package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.exception.ErrorMessage;
import bridge.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DirectionTest {

    @DisplayName("사용자에게 이동할 칸 입력")
    @ValueSource(strings = { "D", "U" })
    @ParameterizedTest
    void testInputDirection(String direction) {
        Direction d = Direction.getPosition(direction);
        assertThat(d.getPosition()).isEqualTo(direction);
    }

    @DisplayName("D, U 외의 다른 값 입력 시 예외 발생")
    @ValueSource(strings = { "A", "B", "0", "1" })
    @ParameterizedTest
    void testInputWrongDirection(String wrongDirection) {
        assertThatThrownBy(() -> Direction.getPosition(wrongDirection))
            .isInstanceOf(InvalidInputException.class)
            .hasMessageContaining(ErrorMessage.UP_DOWN);
    }

}
