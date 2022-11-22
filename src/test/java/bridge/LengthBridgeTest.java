package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.model.MoveBox;
import bridge.model.LengthBridge;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LengthBridgeTest {

    @ValueSource(strings = {"1", "11", "113", "145141"})
    @ParameterizedTest
    void lengthBridge_테스트(String input) {
        assertThat(new LengthBridge(input).getLength()).isEqualTo(Integer.parseInt(input));
    }

    @ValueSource(strings = {"x", "a1", "1d", "@"})
    @ParameterizedTest
    void lengthBridge_예외_테스트(String input) {
        assertThatThrownBy(() -> new LengthBridge(input)).isInstanceOf(IllegalArgumentException.class);
    }
}