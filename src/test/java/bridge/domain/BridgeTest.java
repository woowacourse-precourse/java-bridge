package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeTest {

    private static final int BRIDGE_MIN_LENGTH = 3;
    private static final int BRIDGE_MAX_LENGTH = 20;

    @ParameterizedTest(name = "Bridge는 size가 2이하 21이상이면 예외가 발생한다.")
    @MethodSource
    void bridgeSizeTest(List<String> direction) {
        assertThatThrownBy(() -> new Bridge(direction))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> bridgeSizeTest() {
        List<String> underMinLength = IntStream.range(0, BRIDGE_MIN_LENGTH - 1)
                .mapToObj(i -> "U")
                .collect(Collectors.toList());
        List<String> overMaxLength = IntStream.range(0, BRIDGE_MAX_LENGTH + 1)
                .mapToObj(i -> "U")
                .collect(Collectors.toList());
        return Stream.of(
                Arguments.of(underMinLength),
                Arguments.of(overMaxLength)
        );
    }

}