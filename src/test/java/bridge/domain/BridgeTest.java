package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.*;

import bridge.utils.Constant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeTest {

    @ParameterizedTest
    @MethodSource("generateBridgeData")
    @DisplayName("양쪽 다리를 지나갈 수 없다면 예외가 발생한다.")
    void bridgeTest(List<String> bridge) {
        assertThatThrownBy(() -> new Bridge(bridge))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static Stream<Arguments> generateBridgeData() {
        return Stream.of(
                of(Arrays.asList("U", "U", "Broken Bridge")),
                of(Arrays.asList("U", "Broken Bridge", "D")),
                of(Arrays.asList("Broken Bridge", "D", "Broken Bridge"))
        );
    }
}
