package bridge.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class UserInputValidatorTest {


    @DisplayName("다리 길이 테스트")
    @Nested
    class BridgeSizeTest {

        @DisplayName("양의 숫자를 입력 했을 때 그 값을 그대로 반환하는 지 확인")
        @ParameterizedTest(name = "[{index}번째 테스트 : {0}]")
        @ValueSource(strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"})
        void userInputWithNumber(final String userInput) {
            assertThat(UserInputValidator.checkBridgeSize(userInput)).isEqualTo(Integer.parseInt(userInput));
        }

        @DisplayName("숫자가 아닌 문자열을 입력 했을 때 Exception 을 던지는 지 확인")
        @ParameterizedTest(name = "[{index}번째 테스트 : {0}]")
        @ValueSource(strings = {"1a", "jj", "&1", "$", "q", "we", "t", "j1"})
        void userInputWithNotNumber(final String userInput) {
            assertThatThrownBy(() -> UserInputValidator.checkBridgeSize(userInput))
                    .isInstanceOf(NumberFormatException.class);
        }

        @DisplayName("빈 문자열을 입력 했을 때 Exception 을 던지는 지 확인")
        @ParameterizedTest
        @EmptySource
        void userInputWithEmpty(final String userInput) {
            assertThatThrownBy(() -> UserInputValidator.checkBridgeSize(userInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }


    @DisplayName("다리 건너기 게임 커맨드 테스트")
    @Nested
    class gameCommandTest {

        @DisplayName("커맨드 문자열이 1자리가 아닐때 Exception 을 던지는지 확인")
        @ParameterizedTest(name = "[{index}]번째 테스트 : {0}")
        @ValueSource(strings = {"", "12", "123", "1234", "12345"})
        void movingCommandWithInvalidCommandSize(final String command) {
            assertThatThrownBy(() -> UserInputValidator.gameCommandValidation(command))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("커맨드 문자열이 소문자일 때 Exception 을 던지는지 확인")
        @ParameterizedTest(name = "[{index}]번째 테스트 : {0}")
        @ValueSource(strings = {"u", "d"})
        void movingCommandWithLowerCase(final String command) {
            assertThatThrownBy(() -> UserInputValidator.gameCommandValidation(command))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}