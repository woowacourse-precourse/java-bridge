package bridge.domain.bridge;

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
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeTest {

    private Bridge bridge;

    @BeforeEach
    void setUp() {
        List<Direction> directions = Stream.of("U", "D", "U", "D", "U")
                .map(Direction::new)
                .collect(Collectors.toList());
        bridge = new Bridge(directions);
    }

    @DisplayName("hasElementOf 메소드에 방향과 위치가 입력되었을 때 해당 위치에 방향이 맞는지 여부를 반환하는지 확인")
    @ParameterizedTest
    @MethodSource("provideArgumentsForHasElementTest")
    void hasElementOf_test(Direction direction, int location, boolean expected) {
        boolean actual = bridge.hasElementOf(direction, location);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("hasElementOf 메소드에 다리의 길이를 벗어난 위치가 입력되었을 때 오류를 발생시키는지 확인")
    @ParameterizedTest
    @MethodSource("provideArgumentsForHasElementErrorTest")
    void hasElementOf_error_test(Direction direction, int location) {
        assertThatThrownBy(() -> bridge.hasElementOf(direction, location))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("[ERROR] 다리의 길이를 벗어난 위치 값이 입력되었습니다.");
    }

    @DisplayName("isEnd 메소드에 위치를 입력하였을 때 bridge의 사이즈와 같은지 비교해서 반환하는지 확인")
    @ParameterizedTest
    @CsvSource({"3, false", "4, false", "5, true", "6, false"})
    void isEnd_test(int location, boolean expected) {
        boolean actual = bridge.isEnd(location);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> provideArgumentsForHasElementTest() {
        return Stream.of(
                Arguments.of(new Direction("U"), 0, true),
                Arguments.of(new Direction("D"), 1, true),
                Arguments.of(new Direction("D"), 2, false),
                Arguments.of(new Direction("D"), 3, true),
                Arguments.of(new Direction("D"), 4, false)
        );
    }

    static Stream<Arguments> provideArgumentsForHasElementErrorTest() {
        return Stream.of(
                Arguments.of(new Direction("U"), -1),
                Arguments.of(new Direction("D"), 5)
        );
    }
}