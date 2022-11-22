package bridge.domain.bridge;

import bridge.domain.direction.Direction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static bridge.domain.bridge.CrossStatus.*;
import static bridge.domain.direction.Direction.DOWN;
import static bridge.domain.direction.Direction.UP;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.generate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeTest {

    private static Stream<Arguments> provideBridgeAndPathWithStatus() {
        List<Direction> sameDirections1 = List.of(DOWN, UP, DOWN, UP, UP, DOWN, UP);
        List<Direction> sameDirections2 = List.of(DOWN, DOWN, DOWN);
        List<Direction> sameDirections3 = List.of(UP, UP, DOWN, DOWN, UP, UP, DOWN, UP, DOWN, DOWN);

        Bridge bridge = new Bridge(List.of(UP, UP, DOWN, DOWN, UP, UP, DOWN, UP, DOWN, DOWN));
        List<Direction> goingPath1 = List.of(UP);
        List<Direction> goingPath2 = List.of(UP, UP, DOWN, DOWN);
        List<Direction> goingPath3 = List.of(UP, UP, DOWN, DOWN, UP, UP, DOWN, UP, DOWN);

        List<Direction> failPath1 = List.of(DOWN);
        List<Direction> failPath2 = List.of(UP, UP, DOWN, UP);
        List<Direction> failPath3 = List.of(UP, UP, DOWN, DOWN, UP, UP, DOWN, UP, UP);
        List<Direction> failPath4 = List.of(UP, UP, DOWN, DOWN, UP, UP, DOWN, UP, DOWN, UP);

        return Stream.of(
                Arguments.of(new Bridge(sameDirections1), sameDirections1, SUCCESS),
                Arguments.of(new Bridge(sameDirections2), sameDirections2, SUCCESS),
                Arguments.of(new Bridge(sameDirections3), sameDirections3, SUCCESS),

                Arguments.of(bridge, goingPath1, GOING),
                Arguments.of(bridge, goingPath2, GOING),
                Arguments.of(bridge, goingPath3, GOING),

                Arguments.of(bridge, failPath1, FAIL),
                Arguments.of(bridge, failPath2, FAIL),
                Arguments.of(bridge, failPath3, FAIL),
                Arguments.of(bridge, failPath4, FAIL)
        );
    }

    @ParameterizedTest(name = "[{index}] 다리의 길이가 3~20 사이가 아닌 경우(ex={arguments}) 예외를 발생시킨다.")
    @ValueSource(ints = {0, 2, 21})
    void createdBridgeByOutOfRange(final int length) {
        // given
        List<Direction> bridge = generate(() -> 1)
                .limit(length)
                .mapToObj((i) -> UP)
                .collect(toList());

        // when, then
        assertThatThrownBy(() -> new Bridge(bridge))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideBridgeAndPathWithStatus")
    void crossBridge(final Bridge bridge, final List<Direction> path, final CrossStatus status) {
        // when
        CrossStatus result = bridge.cross(path);

        // then
        assertThat(result).isEqualTo(status);
    }
}