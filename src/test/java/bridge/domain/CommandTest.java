package bridge.domain;

import bridge.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CommandTest {

    @DisplayName("재시작/종료 여부 입력 값은 Q또는 R여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"Q", "R"})
    void validMovingTest(String input) {
        new Command(input);
    }

    @DisplayName("재시작/종료 여부 입력 값이 Q또는 R가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D", "A", "", "*", " ", "/"})
    void validMovingTestError(String input) {
        Assertions.assertThatThrownBy(() -> new Command(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_COMMAND_VALUE.getMessage());
    }

    @DisplayName("isRetry메서드는 command가 R일 경우 true를, Q일 경우 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"R:true", "Q:false"}, delimiter = ':')
    void isRetryTest(String input, boolean expected) {
        Command command = new Command(input);
        Assertions.assertThat(command.isRetry()).isEqualTo(expected);
    }
}