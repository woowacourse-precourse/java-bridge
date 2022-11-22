package bridge.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("다리 도메인 로직 테스트")
public class BridgeTest {
    private final Bridge bridge = new Bridge(List.of("U", "U", "D", "D"));

    @DisplayName("다리가 제대로 생성 되는지 확인한다.")
    @Test
    void checkBridgeGeneration() {
        assertThat(bridge).isNotNull();
    }

    @DisplayName("다리 길이가 정확히 반환되는지 검사한다.")
    @ParameterizedTest
    @MethodSource("BridgeData")
    void checkBridgeGetSize(Bridge bridge, int expectedSize) {
        assertThat(bridge.getSize()).isEqualTo(expectedSize);
    }

    @DisplayName("방향이 주어졌을 때 건널 수 있는지 확인하는 기능을 검사한다.")
    @ParameterizedTest
    @MethodSource("DirectionData")
    void checkBridgeGetSize(int position, Direction testDirection) {
        assertThat(bridge.isCrossable(position, testDirection)).isTrue();
    }

    static Stream<Arguments> BridgeData() {
        return Stream.of(
                Arguments.of(new Bridge(List.of("U","U","U")), 3),
                Arguments.of(new Bridge(List.of("U","U","U","D","D","U","D")), 7),
                Arguments.of(new Bridge(List.of("U","U","U","D","D","D","D","D","D","U","D")), 11),
                Arguments.of(new Bridge(List.of("U","D","D","D","U")), 5),
                Arguments.of(new Bridge(List.of("D","U","U","U","U","D","D","D","D","U")), 10)
        );
    }

    static Stream<Arguments> DirectionData() {
        return Stream.of(
                Arguments.of(0, Direction.of("U")),
                Arguments.of(1, Direction.of("U")),
                Arguments.of(2, Direction.of("D")),
                Arguments.of(3, Direction.of("D"))
        );
    }
}
