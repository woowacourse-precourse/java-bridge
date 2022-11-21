package bridge.domain.bridgebuilder;

import bridge.domain.oxbridgebuilder.OXBridge;
import bridge.domain.resources.Bridge;
import bridge.domain.resources.UpOrDown;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameTest {

    Bridge bridge;
    OXBridge oxBridge;
    UpOrDown upOrDown;

    @BeforeEach
    void setInstances() {
        oxBridge = OXBridge.from(new ArrayList<>(), new ArrayList<>());
    }

    @DisplayName("Bridge가 잘 만들어지는지 size로 확인하는 테스트")
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
    @ParameterizedTest
    void buildAnswerBridgeTest(Integer bridgeSize) {
        Assertions.assertThat(BridgeGame.buildAnswerBridge(bridgeSize).size()).isEqualTo(bridgeSize);
    }

    @DisplayName("input으로 R이 들어오면 true, Q가 들어오면 false 반환하는지 테스트")
    @MethodSource("retryTestArgumentProvider")
    @ParameterizedTest
    void retryTest(String inputRQ, boolean result) {
        Assertions.assertThat(BridgeGame.retry(inputRQ)).isEqualTo(result);
    }

    @DisplayName("비교가 잘 되어 알맞은 boolean을 반환하는지 테스트")
    @MethodSource("moveTestArgumentProvider")
    @ParameterizedTest
    void moveTest(int bridgeSize, String inputUD) {
        bridge = Bridge.of(bridgeSize);
        upOrDown = UpOrDown.of(inputUD);
        oxBridge.addUD(upOrDown, true);
        Assertions.assertThat(BridgeGame.move(bridge, oxBridge, upOrDown)).isInstanceOf(Boolean.class);
    }

    private static Stream<Arguments> retryTestArgumentProvider() {

        return Stream.of(
            Arguments.of("R", true),
            Arguments.of("Q", false)
        );
    }

    private static Stream<Arguments> moveTestArgumentProvider() {

        return Stream.of(
            Arguments.of(3, "U"),
            Arguments.of(4, "U"),
            Arguments.of(5, "U"),
            Arguments.of(10, "U"),
            Arguments.of(15, "U"),
            Arguments.of(20, "U")
        );
    }
}