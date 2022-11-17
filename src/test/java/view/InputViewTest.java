package view;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.ErrorMessage;

class InputViewTest {

    @DisplayName("[InputView] 다리 사이즈 입력시 숫자가 아닌경우 예외처리(음수인경우에도 view단에서 예외처리)")
    @ParameterizedTest
    @ValueSource(strings = {"12hjh3","123d","a1234","-123"})
    void NotCorrectInputBridgeSize(String input) {
        //given
        InputView inputView = new InputView();
        //when
        //then
        assertThatThrownBy(() -> inputView.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.IS_NOT_DIGIT);
    }

    @DisplayName("[InputView] 다리 사이즈 입력값이 숫자인경우")
    @ParameterizedTest
    @ValueSource(strings = {"100","231","2123"})
    void correctInputBridgeSize(String input) {
        //given
        InputView inputView = new InputView();
        //when
        //then
        assertDoesNotThrow(() -> inputView.validateBridgeSize(input));
    }
}