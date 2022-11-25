package bridge.domain.referee;

import bridge.domain.bridge.Bridge;
import bridge.domain.direction.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    private Referee referee;

    @BeforeEach
    void setUp() {
        List<Direction> directions = Stream.of("U", "D", "U", "D", "U")
                .map(Direction::new)
                .collect(Collectors.toList());
        Bridge bridge = new Bridge(directions);
        referee = Referee.from(bridge);
    }

    @DisplayName("checkDirection 메소드에 다리, 방향, 위치가 입력되었을 때 방향이 맞는지 판단한 Judgement 객체를 반환하는지 확인")
    @ParameterizedTest
    @MethodSource("provideArgumentsForCheckingTest")
    void checkDirection_test(Direction direction, int location, boolean expected) {
        Judgement judgement = referee.checkDirection(direction, location);

        assertThat(judgement.isTrue()).isEqualTo(expected);
    }

    @DisplayName("isEnd 메소드에 위치가 입력되었을 때 다리의 끝이 맞는지 확인한 값을 반환하는지 확인")
    @ParameterizedTest
    @CsvSource({"1, false", "4, false", "5, true", "6, false"})
    void isEnd_test(int location, boolean expectedValue) {
        boolean actualValue = referee.isEnd(location);

        assertThat(actualValue).isEqualTo(expectedValue);
    }

    static Stream<Arguments> provideArgumentsForCheckingTest() {
        return Stream.of(
                Arguments.of(new Direction("U"), 0, true),
                Arguments.of(new Direction("D"), 1, true),
                Arguments.of(new Direction("D"), 2, false),
                Arguments.of(new Direction("D"), 3, true),
                Arguments.of(new Direction("D"), 4, false)
        );
    }
}