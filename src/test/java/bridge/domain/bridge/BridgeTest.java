package bridge.domain.bridge;

import bridge.domain.direction.Direction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.generate;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeTest {

    @ParameterizedTest(name = "[{index}] 다리의 길이가 3~20 사이가 아닌 경우(ex={arguments}) 예외를 발생시킨다.")
    @ValueSource(ints = {0, 2, 21})
    void createdBridgeByOutOfRange(final int length) {
        // given
        List<Direction> bridge = generate(() -> 1)
                .limit(length)
                .mapToObj((i) -> Direction.UP)
                .collect(toList());

        // when, then
        assertThatThrownBy(() -> new Bridge(bridge))
                .isInstanceOf(IllegalArgumentException.class);
    }
}