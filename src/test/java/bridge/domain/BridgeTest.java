package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeTest {

    private Bridge bridge;

    @BeforeEach
    void setUp() {
        bridge = new Bridge();
    }

    @ParameterizedTest
    @MethodSource("generateWrongBridgeData")
    @DisplayName("양쪽 다리를 지나갈 수 없다면 예외가 발생한다.")
    void bridgeMakeTest(List<String> input) {
        assertThatThrownBy(() -> bridge.createBridge(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("generateBridgeData")
    @DisplayName("특정 인덱스의 다리위치가 맞는지 체크하는 기능")
    void bridgeCorrectPositionTest(List<String> input) {
        bridge.createBridge(input);
        for (int i = 0; i < input.size(); i++) {
            assertThat(bridge.isCorrectLastPosition(i, input.get(i))).isTrue();
        }
    }

    @ParameterizedTest
    @MethodSource("generateBridgeData")
    @DisplayName("다리 사이즈를 반환하는지 체크하는 테스트")
    void bridgeSizeTest(List<String> input) {
        bridge.createBridge(input);
        assertThat(bridge.size()).isEqualTo(input.size());
    }

    public static Stream<Arguments> generateBridgeData() {
        return Stream.of(
                of(Arrays.asList("U", "U", "D")),
                of(Arrays.asList("U", "D", "U")),
                of(Arrays.asList("D", "U", "D"))
        );
    }

    public static Stream<Arguments> generateWrongBridgeData() {
        return Stream.of(
                of(Arrays.asList("U", "U", "Broken Bridge")),
                of(Arrays.asList("U", "Broken Bridge", "D")),
                of(Arrays.asList("Broken Bridge", "D", "Broken Bridge"))
        );
    }
}
