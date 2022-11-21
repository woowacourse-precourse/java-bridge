package bridge;

import bridge.Enum.Direction;
import bridge.Model.WrappingType.ChoiceDirection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class ChoiceDirectionTest {
    @Nested
    @DisplayName("유효값 테스트")
    class validDataTest {
        @ParameterizedTest
        @ValueSource(strings = {"U", "D"})
        @DisplayName("유효")
        void valid(String choice) {
            ChoiceDirection userChoice = new ChoiceDirection(choice);
            assertThat(userChoice).isInstanceOf(ChoiceDirection.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"U12", "D3", "2", "안녕하세요"})
        @DisplayName("예외")
        void notValid(String choice) {
            assertThatThrownBy(() -> {
                new ChoiceDirection(choice);
            }).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("compare 메소드 테스트(Input : String)")
    @ParameterizedTest
    @CsvSource(value = {"U:U:true", "U:D:false", "D:D:true", "D:U:false"}, delimiter = ':')
    void compareTest(String choice, String directionString, boolean result) {
        ChoiceDirection choiceDirection = new ChoiceDirection(choice);
        boolean actual = choiceDirection.compare(directionString);
        assertThat(actual).isEqualTo(result);
    }

    @DisplayName("compare 메소드 테스트(Input : Direction)")
    @ParameterizedTest
    @MethodSource("generateData")
    void compareTest(String choice, Direction direction, boolean result) {
        ChoiceDirection choiceDirection = new ChoiceDirection(choice);
        boolean actual = choiceDirection.compare(direction);
        assertThat(actual).isEqualTo(result);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("U", Direction.UP, true),
                Arguments.of("U", Direction.DOWN, false),
                Arguments.of("D", Direction.UP, false),
                Arguments.of("D", Direction.DOWN, true)
        );
    }

}
