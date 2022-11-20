package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeTest {
    private Bridge upDownUpBridge;

    @BeforeEach
    void setUp() {
        this.upDownUpBridge = Bridge.createByBridgeShapeValue(List.of("U", "D", "U"));
    }

    @DisplayName("위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값으로 다리를 생성하는 테스트")
    @Test
    void createByBridgeShapeValue() {
        Bridge actual = Bridge.createByBridgeShapeValue(List.of("U", "D", "U"));

        assertThat(actual).isEqualTo(new Bridge(List.of(BridgeShape.UP, BridgeShape.DOWN, BridgeShape.UP)));
    }

    @MethodSource
    private static Stream<Arguments> provideForCompare() {
        return Stream.of(
                Arguments.of(List.of(BridgeShape.UP), List.of(true)),
                Arguments.of(List.of(BridgeShape.DOWN), List.of(false)),
                Arguments.of(List.of(BridgeShape.UP, BridgeShape.DOWN), List.of(true, true)),
                Arguments.of(List.of(BridgeShape.UP, BridgeShape.UP), List.of(true, false)),
                Arguments.of(List.of(BridgeShape.DOWN, BridgeShape.UP), List.of(false, false)),
                Arguments.of(List.of(BridgeShape.UP, BridgeShape.DOWN, BridgeShape.UP), List.of(true, true, true)),
                Arguments.of(
                        List.of(BridgeShape.DOWN, BridgeShape.UP, BridgeShape.DOWN), List.of(false, false, false))
        );
    }

    @ParameterizedTest(name = "플레이어가 이동한 칸과 다리를 비교한다.")
    @MethodSource("provideForCompare")
    void compare(List<BridgeShape> playerMoveBridgeShape, List<Boolean> booleans) {
        Bridge playerMoveBridge = new Bridge(playerMoveBridgeShape);

        assertThat(upDownUpBridge.compare(playerMoveBridge)).isEqualTo(new BridgeGameResult(upDownUpBridge, booleans));
    }

    @DisplayName("플레이어가 이동한 칸이 다리보다 많을 경우 예외 처리한다.")
    @Test
    void compareMoveOverBridgeSize() {
        Bridge bridge = Bridge.createByBridgeShapeValue(List.of("U", "D", "U"));
        Bridge attempts = new Bridge(List.of(BridgeShape.UP, BridgeShape.DOWN, BridgeShape.UP, BridgeShape.DOWN));

        assertThatThrownBy(() -> bridge.compare(attempts)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 사이즈 비교 기능 테스트")
    @Nested
    class Size {
        @DisplayName("전달된 사다리와 사이즈가 같은지 반환한다.")
        @Test
        public void sizeEqualBridge() {
            Bridge bridge = Bridge.createByBridgeShapeValue(List.of("U", "D", "U"));

            assertAll(
                    assertThat(bridge.sizeEqual(Bridge.createByBridgeShapeValue(List.of("D", "U", "D"))))::isTrue,
                    assertThat(bridge.sizeEqual(Bridge.createByBridgeShapeValue(List.of("D", "U"))))::isFalse
            );
        }

        @DisplayName("사다리 사이즈와 숫자가 같은지 반환한다.")
        @Test
        public void sizeEqualNumber() {
            Bridge bridge = Bridge.createByBridgeShapeValue(List.of("U", "D", "U"));

            assertAll(
                    assertThat(bridge.sizeEqual(2))::isFalse,
                    assertThat(bridge.sizeEqual(3))::isTrue,
                    assertThat(bridge.sizeEqual(4))::isFalse
            );
        }
    }
}
