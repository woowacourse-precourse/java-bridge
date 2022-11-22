package bridge;

import bridge.view.InputViewType;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTypeTest {

    private InputViewType inputViewType;


    @DisplayName("다리 사이즈는 숫자여야만 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"일", "one", "i"})
    void sizeMustBeDigit(String input) {
        inputViewType = InputViewType.BRIDGE_SIZE;
        String nullStr = null;

        assertThrows(IllegalArgumentException.class, () -> {
            inputViewType.validate(input);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            inputViewType.validate(nullStr);
        });
        assertThatNoException().isThrownBy(() -> inputViewType.validate("9"));
        assertThatNoException().isThrownBy(() -> inputViewType.validate("6"));
   }

    @DisplayName("움직임은 U 또는 D여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"u", "", "1"})
    void movingMustBeUorD(String input) {
        inputViewType = InputViewType.MOVING;
        String nullStr = null;

        assertThrows(IllegalArgumentException.class, () -> {
            inputViewType.validate(nullStr);
        });
        assertThatNoException().isThrownBy(() -> inputViewType.validate("U"));
        assertThatNoException().isThrownBy(() -> inputViewType.validate("D"));
    }

    @DisplayName("커맨드는 R또는 Q여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"일", "one", "i"})
    void commandMustBeRorQ(String input) {
        inputViewType = InputViewType.GAME_COMMAND;
        String nullStr = null;

        assertThrows(IllegalArgumentException.class, () -> {
            inputViewType.validate(nullStr);
        });
        assertThatNoException().isThrownBy(() -> inputViewType.validate("R"));
        assertThatNoException().isThrownBy(() -> inputViewType.validate("Q"));
    }
}