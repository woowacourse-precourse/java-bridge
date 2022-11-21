package bridge.InputValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.InputValidator.MoveInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class MoveInputTest {
    MoveInput moveInput;


    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void 정상_입력(String input) {
        moveInput = new MoveInput(input);
        assertThat(moveInput.getMoveDirection()).isEqualTo(input);
    }

    @ValueSource(strings = {"1234", "-2", "-434"})
    @ParameterizedTest
    void 숫자_비정상_입력(String input) {
        assertThatThrownBy(() -> new MoveInput(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"abc", "&D", "RDR"})
    @ParameterizedTest
    void 문자열_비정상_입력(String input) {
        assertThatThrownBy(() -> new MoveInput(input)).isInstanceOf(IllegalArgumentException.class);
    }
}