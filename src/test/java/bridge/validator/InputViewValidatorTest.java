package bridge.validator;

import bridge.exception.UserInputException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputViewValidatorTest {


    @DisplayName("양의 숫자를 입력 했을 때 그 값을 그대로 반환하는 지 확인")
    @ParameterizedTest(name = "[{index}번째 테스트 : {0}]")
    @ValueSource(strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"})
    void userInputWithNumber(final String userInput) {
        assertThat(InputViewValidator.ckeckBridgeSize(userInput)).isEqualTo(userInput);
    }

    @DisplayName("양의 숫자가 아닌 문자열을 입력 했을 때 Exception 을 던지는 지 확인")
    @ParameterizedTest(name = "[{index}번째 테스트 : {0}]")
    @ValueSource(strings = {"-1", "1a", "jj", "&1", "$", "q", "we", "t", "j1"})
    void userInputWithNotNumber(final String userInput) {
        assertThatThrownBy(() -> InputViewValidator.ckeckBridgeSize(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 문자열을 입력 했을 때 Exception 을 던지는 지 확인")
    @ParameterizedTest
    @EmptySource
    void userInputWithEmpty(final String userInput) {
        assertThatThrownBy(() -> InputViewValidator.ckeckBridgeSize(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}