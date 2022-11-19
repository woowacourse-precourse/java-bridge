package model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.ErrorMessage;

class UserTest {

    @ParameterizedTest
    @DisplayName("[validateUserInput] 이동할 칸 입력시 user의 입력값이 정확한 경우 테스트")
    @ValueSource(strings = {"U", "D"})
    void correctUserInput(String userInput) {
        //given
        //when
        //then
        assertThatNoException().isThrownBy(()->User.validateUserInput(userInput));
    }

    @ParameterizedTest
    @DisplayName("[validateUserInput] 이동할 칸 입력시 user의 입력값이 U, D 가 아닌경우 예외발생")
    @ValueSource(strings = {"ASD", "Q",".","test"})
    void notCorrectUserInput(String userInput) {
        //given
        //when
        //then
        assertThatThrownBy(() -> User.validateUserInput(userInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.STAIRS_U_OR_D);
    }
}