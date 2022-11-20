package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeStatusTest {

    @DisplayName("방향 키 + 다리 건널 수 있는지 여부 값을 통해 BridgeStatus 상수 참조")
    @ParameterizedTest
    @MethodSource("bridgeStatusValues")
    void referBridgeStatus(String arrow, String mark, BridgeStatus bridgeStatus) {
        assertThat(BridgeStatus.valueOfArrowAndMark(arrow, mark)).isEqualTo(bridgeStatus);
    }

    private static Stream<Arguments> bridgeStatusValues() {
        return Stream.of(
            Arguments.of("U", " O ", "UP_O"),
            Arguments.of("U", " X ", "UP_X"),
            Arguments.of("D", " O ", "DOWN_O"),
            Arguments.of("D", " X ", "DOWN_X")
        );
    }
}