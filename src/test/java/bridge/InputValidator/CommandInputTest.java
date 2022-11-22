package bridge.InputValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CommandInputTest {
    CommandInput commandInput;


    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void 정상_입력(String input) {
        commandInput = new CommandInput(input);
        assertThat(commandInput.getCommandInput()).isEqualTo(input);
    }

    @ValueSource(strings = {"1234", "-2", "-434"})
    @ParameterizedTest
    void 숫자_비정상_입력(String input) {
        assertThatThrownBy(() -> new CommandInput(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"abc", "&D", "RDR"})
    @ParameterizedTest
    void 문자열_비정상_입력(String input) {
        assertThatThrownBy(() -> new CommandInput(input)).isInstanceOf(IllegalArgumentException.class);
    }
}