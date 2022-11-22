package bridge.ui.input.dto;

import bridge.ui.input.InputErrorText;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RestartCommandTest {
    @ParameterizedTest
    @ValueSource(strings = {"B", "C", "a", " ", " 21"})
    public void 재시작_입력은_R과_Q만_가능하다(String input) {
        String expectedErrorText = InputErrorText.ERROR_RESTART_COMMAND.errorText();

        Assertions.assertThatThrownBy(() ->
                        RestartCommand.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorText);
    }


}