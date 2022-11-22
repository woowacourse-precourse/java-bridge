package bridge.domain.type;

import bridge.domain.type.BridgeLineType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeLineTypeTest {
    static Stream<Arguments> getValidBridgeNumberAndLine() {
        return Stream.of(
                Arguments.of(0, BridgeLineType.DOWN),
                Arguments.of(1, BridgeLineType.UP)
        );
    }

    static Stream<Arguments> getValidBridgeCommandAndLine() {
        return Stream.of(
                Arguments.of("D", BridgeLineType.DOWN),
                Arguments.of("U", BridgeLineType.UP)
        );
    }

    @ParameterizedTest
    @MethodSource("getValidBridgeNumberAndLine")
    @DisplayName("BridgeNumber로 bridgeLine을 찾아올 수 있는지 검사")
    void TestFindBridgeLineByValidNumber(int number, BridgeLineType bridgeLineType) {
        assertThat(BridgeLineType.findByNumber(number)).isEqualTo(bridgeLineType);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, -1})
    @DisplayName("유효하지 않은 BridgeNumber로 bridgeLine을 탐색할 때 에러가 발생하는지 검사")
    void TestFindBridgeLineByInvalidNumber(int number) {
        assertThatThrownBy(() -> BridgeLineType.findByNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("getValidBridgeCommandAndLine")
    @DisplayName("Command로 bridgeLine을 찾아올 수 있는지 검사")
    void TestFindBridgeLineByValidCommand(String command, BridgeLineType bridgeLineType) {
        assertThat(BridgeLineType.findByCommand(command)).isEqualTo(bridgeLineType);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "1"})
    @DisplayName("유효하지 않은 Command로 bridgeLine을 탐색할 때를 검사")
    void TestFindBridgeLineByInvalidCommand(String command) {
        assertThatThrownBy(() -> BridgeLineType.findByCommand(command)).isInstanceOf(IllegalArgumentException.class);
    }

}
