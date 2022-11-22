package bridge.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RetryCommandTest {

    @ParameterizedTest
    @DisplayName("재시작 입력 코드 입력 오류 검증")
    @ValueSource(strings = {"Z", "X", "123", " "})
    void 재시작_입력_코드는_R과_Q만_가능합니다(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RetryCommand.convertTypeCommand(input))
                .withMessageContaining(RetryCommand.ERROR_NOT_FOUND_COMMAND_VALUE);
    }
}