package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeTest {

    @Test
    void isRightMovingWithBridge() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        assertThat(bridge.isRightMoving(0, "U")).isEqualTo(true);
        assertThat(bridge.isRightMoving(1, "U")).isEqualTo(false);
    }

    @ParameterizedTest
    @MethodSource("bridges")
    void isBridgeGetSize(List<String> bridge, int size) {
        assertThat(new Bridge(bridge).getSize()).isEqualTo(size);
    }

    static Stream<Arguments> bridges() {
        return Stream.of(
                arguments(List.of("U", "D", "D"), 3),
                arguments(List.of("U", "D", "D", "D"), 4),
                arguments(List.of("U", "D", "D", "D", "D"), 5)
        );
    }

}
