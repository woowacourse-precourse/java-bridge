package bridge.ui.input.dto;

import bridge.ui.input.InputErrorText;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoveCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", "V", "C", "abdabs", ""})
    public void 이동할_칸_선택은_U_또는_D_만_가능_하다(String input) {
        String expectedErrorText = InputErrorText.ERROR_MOVE_COMMAND.errorText();

        Assertions.assertThatThrownBy(() ->
                        MoveCommand.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorText);
    }
}