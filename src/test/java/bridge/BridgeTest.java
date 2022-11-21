package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BridgeTest {
    final static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    final static BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    final static List<String> defaultBridge = List.of("U", "U", "D", "D");
    Bridge bridge;

    @ParameterizedTest
    @MethodSource("generateWrongBridgeValue")
    void 다리_생성_예외_테스트(List<String> movableSides) {
        assertThatThrownBy(() -> new Bridge(movableSides))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 윗칸_이동_가능_확인_테스트() {
        bridge = new Bridge(List.of("U"));
        assertThat(bridge.isMovableSide("U", 0))
                .isTrue();
    }

    @Test
    void 아래칸_이동_가능_확인_테스트() {
        bridge = new Bridge(List.of("U", "D"));
        assertThat(bridge.isMovableSide("D", 1))
                .isTrue();
    }

    @Test
    void 윗칸_이동_불가능_확인_테스트() {
        bridge = new Bridge(List.of("D"));
        assertThat(bridge.isMovableSide("U", 0))
                .isFalse();
    }

    @Test
    void 아래칸_이동_불가능_확인_테스트() {
        bridge = new Bridge(List.of("U"));
        assertThat(bridge.isMovableSide("D", 0))
                .isFalse();
    }

    @Test
    void 마지막_위치에_있는지_확인_테스트() {
        bridge = new Bridge(defaultBridge);
        assertThat(bridge.isLastPosition(defaultBridge.size() - 1))
                .isTrue();
    }

    static Stream<Arguments> generateWrongBridgeValue() {
        return Stream.of(
                Arguments.of(Arrays.asList("")),
                Arguments.of(Arrays.asList(" ")),
                Arguments.of(Arrays.asList("a")),
                Arguments.of(Arrays.asList("1")),
                Arguments.of(Arrays.asList("u")),
                Arguments.of(Arrays.asList("d")),
                Arguments.of(Arrays.asList("UU")),
                Arguments.of(Arrays.asList("DD")),
                Arguments.of(Arrays.asList("U", "D ")),
                Arguments.of(Arrays.asList("U", "D ", "U")),
                Arguments.of(Arrays.asList("U.", "D ", "U"))
        );
    }
}
