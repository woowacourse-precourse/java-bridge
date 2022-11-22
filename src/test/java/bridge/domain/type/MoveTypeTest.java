package bridge.domain.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveTypeTest {
    static Stream<Arguments> getValidBridgeNumberAndLine() {
        return Stream.of(
                Arguments.of(0, MoveType.DOWN),
                Arguments.of(1, MoveType.UP)
        );
    }

    static Stream<Arguments> getValidBridgeCommandAndLine() {
        return Stream.of(
                Arguments.of("D", MoveType.DOWN),
                Arguments.of("U", MoveType.UP)
        );
    }

    @ParameterizedTest
    @MethodSource("getValidBridgeNumberAndLine")
    @DisplayName("BridgeNumber로 bridgeLine을 찾아올 수 있는지 검사")
    void TestFindBridgeLineByValidNumber(int number, MoveType moveType) {
        assertThat(MoveType.findByNumber(number)).isEqualTo(moveType);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, -1})
    @DisplayName("유효하지 않은 BridgeNumber로 bridgeLine을 탐색할 때 에러가 발생하는지 검사")
    void TestFindBridgeLineByInvalidNumber(int number) {
        assertThatThrownBy(() -> MoveType.findByNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("getValidBridgeCommandAndLine")
    @DisplayName("Command로 bridgeLine을 찾아올 수 있는지 검사")
    void TestFindBridgeLineByValidCommand(String command, MoveType moveType) {
        assertThat(MoveType.findByCommand(command)).isEqualTo(moveType);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "1"})
    @DisplayName("유효하지 않은 Command로 bridgeLine을 탐색할 때를 검사")
    void TestFindBridgeLineByInvalidCommand(String command) {
        assertThatThrownBy(() -> MoveType.findByCommand(command)).isInstanceOf(IllegalArgumentException.class);
    }

}
