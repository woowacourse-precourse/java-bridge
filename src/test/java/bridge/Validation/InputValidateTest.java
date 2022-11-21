package bridge.Validation;

import bridge.Console.Input;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidateTest {
    private InputValidate inputValidate;

    @BeforeEach
    void InputValidate(){
        inputValidate = new InputValidate();
    }

    @Test
    @DisplayName("입력이_3이상_20이하가_아니면_예외")
    void validateSizeFormatTest(){
        Integer size = 25;
        assertThatThrownBy(() -> {
            inputValidate.validateSizeFormat(size);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("다리_길이_입력값이_숫자가_아닌경우_예외")
    void validateSizeIntFormatTest(){
        String input = "a";
        assertThatThrownBy(() -> {
            inputValidate.validateSizeIntFormat(input);
        }).isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("이동_입력값이_U나_D가_아닌경우_예외")
    void validateMovingFormatTest(){
        String input = "a";
        assertThatThrownBy(() -> {
            inputValidate.validateMovingFormat(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("재시작_입력값이_R이나_Q가_아닌경우_예외")
    void validateGameCommendFormatTest(){
        String input = "a";
        assertThatThrownBy(() -> {
            inputValidate.validateGameCommendFormat(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }



}