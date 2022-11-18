package bridge.support.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class InputValidatorTest {
    private static final String NOT_A_NUMBER_MESSAGE = "[ERROR] 숫자를 입력해주세요.";
    private static final String INVALID_MOVING_SIGN_MESSAGE = "[ERROR] 이동할 칸은 U또는 D만 입력 가능합니다";

    @DisplayName("사용자가 숫자로 변환이 불가능한 문자열을 입력하였을 때, 예외를 던지는지 테스트")
    @Test
    void validateParseStringToInteger() {
        //given
        String input = "삼";
        //when
        //then
        Assertions.assertThatThrownBy(() -> {
                      InputValidator.validateParseStringToInteger(input);
                  })
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessageContaining(NOT_A_NUMBER_MESSAGE);
    }

    @DisplayName("사용자가 이동할 칸에 U또는 D가 아닌 값을 입력하면 예외를 던지는지 테스트")
    @Test
    void validateMoving() {
        //given
        String input = "u";
        //when
        //then
        Assertions.assertThatThrownBy(() -> {
                      InputValidator.validateMoving(input);
                  })
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessageContaining(INVALID_MOVING_SIGN_MESSAGE);
    }
}