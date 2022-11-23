package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MovingCommandTest {

    @DisplayName("U, D 이외의 값을 입력한 경우 예외 발생")
    @ParameterizedTest
    @CsvSource({
            "UP", "DOWN", "LEFT", "RIGHT", "L", "R"
    })
    void throwExceptionWhenInputIsNotUorD(String input) {
        assertThatThrownBy(() -> MovingCommand.nameOf(input)).isInstanceOf(IllegalArgumentException.class);
    }
}