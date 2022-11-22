package bridge.domain;

import bridge.exception.InvalidDirectionFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {

    @DisplayName("U 혹은 D가 아닌 값이 들어오면 에러를 발생한다.")
    @Test
    void checkValidateByWrongString() {
        assertThatThrownBy(() -> Direction.validate("A"))
                .isInstanceOf(InvalidDirectionFormatException.class);
    }

    @DisplayName("U 혹은 D가 들어오면 정상 통과한다.")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void checkValidateByCorrectString(String string) {
        Direction.validate(string);
    }

    @DisplayName("알파벳 이니셜이 제대로 나오는지 확인한다.")
    @CsvSource(value = {"UP:U", "DOWN:D"}, delimiter = ':')
    @ParameterizedTest
    void checkDirectionInitialByCorrectValue(Direction direction, String expected) {
        if (direction.getDirectionInitial().equals(expected)) {
            return;
        }

        throw new IllegalArgumentException("[ERROR] 서로 다른 알파벳 이니셜이 나오고 있습니다.");
    }

    @DisplayName("generate를 Direction으로 잘 변환하는지 확인하다.")
    @MethodSource("generateCorrectValue")
    @ParameterizedTest
    void checkGetDirectionByCorrectValue(Integer generate, Direction direction) {
        if (Direction.getDirection(generate).equals(direction)) {
            return;
        }

        throw new IllegalArgumentException("[ERROR] 숫자로 얻은 상수와 예상 상수가 일치하지 않습니다.");
    }

    static Stream<Arguments> generateCorrectValue() {
        return Stream.of(
                Arguments.of(1, Direction.UP),
                Arguments.of(0, Direction.DOWN)
        );
    }
}
