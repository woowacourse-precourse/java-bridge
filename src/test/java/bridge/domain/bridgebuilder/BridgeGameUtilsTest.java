package bridge.domain.bridgebuilder;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeGameUtilsTest {

    List<String> bridgeUD;

    @BeforeEach
    void setBridgeGameUtils() {
        bridgeUD = List.of("U", "D", "U");
    }

    @DisplayName("bridgeUD에 담긴 모든 내용물에 접근하여 비교가 잘 되는지 테스트(true만 반환)")
    @MethodSource("rightArgumentProvider")
    @ParameterizedTest
    void isEqualsRightTest(String inputUD, int answerBridgeIndex, boolean result) {
        Assertions.assertThat(BridgeGameUtils.isEquals(inputUD, bridgeUD, answerBridgeIndex)).isEqualTo(result);
    }

    @DisplayName("bridgeUD에 담긴 모든 내용물에 접근하여 비교가 잘 되는지 테스트(false만 반환)")
    @MethodSource("wrongTestArgumentProvider")
    @ParameterizedTest
    void isEqualsWrongTest(String inputUD, int answerBridgeIndex, boolean result) {
        Assertions.assertThat(BridgeGameUtils.isEquals(inputUD, bridgeUD, answerBridgeIndex)).isEqualTo(result);
    }

    @DisplayName("input으로 R이 들어오면 true, Q가 들어오면 false 반환")
    @MethodSource("retryTestArgumentProvider")
    @ParameterizedTest
    void retryTest(String inputRQ, boolean result) {
        Assertions.assertThat(BridgeGameUtils.retry(inputRQ)).isEqualTo(result);
    }

    private static Stream<Arguments> rightArgumentProvider() {
        return Stream.of(
            Arguments.of("U", 0, true),
            Arguments.of("D", 1, true),
            Arguments.of("U", 2, true)
        );
    }

    private static Stream<Arguments> wrongTestArgumentProvider() {
        return Stream.of(
            Arguments.of("D", 0, false),
            Arguments.of("U", 1, false),
            Arguments.of("D", 2, false)
        );
    }

    private static Stream<Arguments> retryTestArgumentProvider() {
        return Stream.of(
            Arguments.of("R", true),
            Arguments.of("Q", false)
        );
    }

}