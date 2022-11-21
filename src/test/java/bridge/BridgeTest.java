package bridge;

import bridge.model.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeTest {

    @DisplayName("U, D의 올바른 입력으로 다리를 생성")
    @ParameterizedTest
    @MethodSource("generateValidBridges")
    public void bridgeMakeTest(List<String> input, String expected) {
        assertThat(new Bridge(input).toString())
                .isEqualTo(expected);
    }

    @DisplayName("U, D 외의 다른 문자가 삽입된 문자열로 다리를 생성 시 예외 처리")
    @Test
    public void bridgeMakeWithInvalidCharacter() {
        List<String> bridgeInput = List.of("U", "D", "D", "Q", "U");
        assertThatThrownBy(() -> new Bridge(bridgeInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("길이가 3미만인 다리를 생성 시 예외 처리")
    @Test
    public void bridgeMakeWithLowBoundSize() {
        List<String> bridgeInput = List.of("U", "U");
        assertThatThrownBy(() -> new Bridge(bridgeInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("길이가 20 초과인 다리를 생성 시 예외 처리")
    @Test
    public void bridgeMakeWithUpperBoundSize() {
        List<String> bridgeInput = List.of("U", "U", "U", "D", "D", "U", "D", "U", "U", "U", "D", "D", "U", "U", "U", "U", "U", "D", "U", "U", "D");
        assertThatThrownBy(() -> new Bridge(bridgeInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> generateValidBridges() {
        return Stream.of(
                Arguments.of(Arrays.asList("U", "U", "D", "U"), "UUDU"),
                Arguments.of(Arrays.asList("D", "D", "D"), "DDD"),
                Arguments.of(Arrays.asList("U", "D", "U", "D", "D", "U", "U", "D"), "UDUDDUUD"),
                Arguments.of(Arrays.asList("U", "U", "U", "U", "U", "U", "U"), "UUUUUUU")
        );
    }

}
