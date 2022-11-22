package bridge.command;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RetryCommandTest {
    @ParameterizedTest
    @NullSource
    void RetryCommand_클래스는_생성시_null_입력이_들어오면_예외(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new RetryCommand(input));
    }
}