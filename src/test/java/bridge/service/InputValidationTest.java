package bridge.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import bridge.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class InputValidationTest {

    InputValidation inputValidation = new InputValidation();

    @DisplayName("입력받은 사이즈가 숫자인가")
    @ValueSource(strings = {"qwe", "123q", "1!1"})
    @ParameterizedTest
    void isNumberTest(String bridgeLength) {
        assertThat(inputValidation.isNumber(bridgeLength)).isFalse();
    }

    @DisplayName("사이즈 범위가 3~20인가")
    @ValueSource(ints = {1, 30, -5})
    @ParameterizedTest
    void isValidRangeTest(int size) {
        assertThat(inputValidation.isValidRange(size)).isFalse();
    }

    @DisplayName("사용자가 입력한 이동할 칸이 U,D인가 ")
    @ValueSource(strings = {"u", "UU", "VAWEF"})
    @ParameterizedTest
    void isValidDirectionTest(String moveDirection) {
        assertThat(inputValidation.isValidDirection(moveDirection)).isFalse();
    }

    @DisplayName("사용자가 입력한 게임 재시작 명령어가 R,Q인가 ")
    @ValueSource(strings = {"r", "QR", "ffeq"})
    @ParameterizedTest
    void isValidGameRetryInputTest(String gameRetryCommand) {
        assertThat(inputValidation.isValidGameRetryInput(gameRetryCommand)).isFalse();
    }
}