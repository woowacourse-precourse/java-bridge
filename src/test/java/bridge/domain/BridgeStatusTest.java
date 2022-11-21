package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeStatusTest {

    @DisplayName("방향 키 + 다리 건널 수 있는지 여부 값으로 BridgeStatus 상수 참조 불가능 시 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("illegalBridgeStatusValues")
    void validateReferabilityBridgeStatus(String moving, String mark) {
        assertThatThrownBy(() -> BridgeStatus.valueOfArrowAndMark(moving, mark))
                .isInstanceOf(IllegalStateException.class);
    }

    private static Stream<Arguments> illegalBridgeStatusValues() {
        return Stream.of(
                Arguments.of("A", " O "),
                Arguments.of("Z", " X "),
                Arguments.of("U", " A "),
                Arguments.of("D", " Z ")
        );
    }

    @DisplayName("방향 키 + 다리 건널 수 있는지 여부 값을 통해 BridgeStatus 상수 참조")
    @ParameterizedTest
    @MethodSource("bridgeStatusValues")
    void referBridgeStatus(String moving, String mark, BridgeStatus bridgeStatus) {
        assertThat(BridgeStatus.valueOfArrowAndMark(moving, mark)).isEqualTo(bridgeStatus);
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