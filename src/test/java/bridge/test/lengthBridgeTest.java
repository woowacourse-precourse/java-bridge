package bridge.test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.model.lengthBridge;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class lengthBridgeTest {

    @ValueSource(strings = {"3", "5", "8", "20"})
    @ParameterizedTest
    void lengthBridge_테스트(String input) {
        assertThat(new lengthBridge(input).getLength()).isEqualTo(Integer.parseInt(input));
    }

    @ValueSource(strings = {"x", "a1", "1d", "@","2"})
    @ParameterizedTest
    void lengthBridge_예외_테스트(String input) {
        assertThatThrownBy(() -> new lengthBridge(input)).isInstanceOf(
            IllegalArgumentException.class);
    }
}
