package bridge.InputValidator;

import bridge.InputValidator.BridgeSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class BridgeSizeTest {
    private BridgeSize bridgeSize;

    @ValueSource(strings = {"abc", "1abc", "$bb12"})
    @ParameterizedTest
    void 숫자_아닌_입력값(String input) {
        assertThatThrownBy(() -> new BridgeSize(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"-134", "31", "2", "123"})
    @ParameterizedTest
    void 범위_바깥의_입력값(String input) {
        assertThatThrownBy(() -> new BridgeSize(input)).isInstanceOf(IllegalArgumentException.class);
    }
}