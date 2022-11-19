package bridge.domain.bridgeenum;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.errorenum.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RestartTest {
    private static final String ERROR_HEAD = "[ERROR]";

    @DisplayName("재시작 여부 입력 시, 지정된 값 외의 입력값은 예외가 발생한다")
    @Test
    void createInputWithWrongValue() {
        String input = "A";
        assertThatThrownBy(() -> Restart.isRestart(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_IN_RESTART.printMessage())
                .hasMessageStartingWith(ERROR_HEAD);
    }

    @DisplayName("재시작 여부 입력 시, 그에 따른 재시작 여부 반환을 테스트한다")
    @ParameterizedTest
    @CsvSource(value = {"R:true", "Q:false"}, delimiter = ':')
    void checkRestartValueByCommand(String command, boolean isRestart) {
        assertThat(Restart.isRestart(command)).isEqualTo(isRestart);
    }
}
