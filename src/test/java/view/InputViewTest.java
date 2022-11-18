package view;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.ErrorMessage;

class InputViewTest {
    private final InputView inputView = new InputView();

    @DisplayName("[validateDigit] 다리 사이즈 입력시 숫자가 아닌경우 예외처리(음수인경우에도 view단에서 예외처리)")
    @ParameterizedTest
    @ValueSource(strings = {"12hjh3","123d","a1234","-123"})
    void NotCorrectInputBridgeSize(String input) {
        //given
        //when
        //then
        assertThatThrownBy(() -> inputView.validateDigit(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.SHOULD_DIGIT);
    }

    @DisplayName("[validateDigit] 다리 사이즈 입력값이 숫자인경우")
    @ParameterizedTest
    @ValueSource(strings = {"100","231","2123"})
    void correctInputBridgeSize(String input) {
        //given
        //when
        //then
        assertDoesNotThrow(() -> inputView.validateDigit(input));
    }

    @DisplayName("[validateCharacter] 입력이 문자가 이닌경우 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"10","21","21133"})
    void notCorrectInputOneStairs(String input) {
        //given
        //when
        //then
        assertThatThrownBy(() -> inputView.validateCharacter(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.SHOULD_CHARACTER);
    }

    @DisplayName("[validateCharacter] 입력이 문자인경우 테스트 ")
    @ParameterizedTest
    @ValueSource(strings = {"asds","test","안녕하세요"})
    void inputCharacter(String input) {
        //given
        //when
        //then
        assertDoesNotThrow(() -> inputView.validateCharacter(input));
    }


}