package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MovingTest {

    @DisplayName("1과 0으로 Moving 객체 찾기")
    @ParameterizedTest
    @MethodSource("provideNumbers")
    void findByNumber(int number, Moving expected) {
        Moving actual = Moving.findByNumber(number);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(Named.of("1", 1),
                        Named.of(Moving.UP.name(), Moving.UP)),
                Arguments.of(Named.of("0", 0),
                        Named.of(Moving.DOWN.name(), Moving.DOWN))
        );
    }

}