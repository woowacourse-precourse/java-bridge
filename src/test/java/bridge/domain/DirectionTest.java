package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static bridge.utils.ErrorMessages.ERROR_INVALID_MOVING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {

    @DisplayName("이동할 다리 방향을 객체로 생성한다.")
    @ParameterizedTest
    @MethodSource("generateDataByInput")
    void createDirectionByInputDirection(String input, Direction expect) {
        assertThat(Direction.of(input)).isEqualTo(expect);
    }

    static Stream<Arguments> generateDataByInput() {
        return Stream.of(
            Arguments.of("U", Direction.UP),
            Arguments.of("D", Direction.DOWN)
        );
    }

    @DisplayName("입력받은 다리 방향이 U 또는 D가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"u", "d", "UD", "A", "1"})
    void invalidInputDirection(String input) {
        assertThatThrownBy(() -> Direction.of(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_INVALID_MOVING);
    }

    @DisplayName("랜덤하게 생성한 다리 번호를 객체로 생성한다.")
    @ParameterizedTest
    @MethodSource("generateDataByBridgeRandomNumber")
    void createDirectionByBridgeRandomNumber(int number, Direction expect) {
        assertThat(Direction.of(number)).isEqualTo(expect);
    }

    static Stream<Arguments> generateDataByBridgeRandomNumber() {
        return Stream.of(
            Arguments.of(1, Direction.UP),
            Arguments.of(0, Direction.DOWN)
        );
    }
}
