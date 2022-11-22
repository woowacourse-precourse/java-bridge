package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DirectionTest {

    @DisplayName("입력받은 문자로 enum 반환")
    @ParameterizedTest
    @CsvSource(value = {"U,UP", "D,DOWN"})
    void directionCommandFromStringTest(String command, Direction direction) {
        Assertions.assertThat(Direction.from(command))
                .isEqualTo(direction);
    }

    @DisplayName("입력 불가능한 커맨드의 예외 테스트")
    @ParameterizedTest
    @CsvSource(value = {"A", "B", "C"})
    void directionCommandFromStringFailTest(String command) {
        Assertions.assertThatThrownBy(() -> Direction.from(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 문자로 enum 반환")
    @ParameterizedTest
    @CsvSource(value = {"1,UP", "0,DOWN"})
    void directionCommandFromIntTest(int directionNumber, Direction direction) {
        Assertions.assertThat(Direction.from(directionNumber))
                .isEqualTo(direction);
    }

    @DisplayName("입력 불가능한 커맨드의 예외 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1", "2"})
    void directionCommandFromFailIntTest(String directionNumber) {
        Assertions.assertThatThrownBy(() -> Direction.from(directionNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }


}