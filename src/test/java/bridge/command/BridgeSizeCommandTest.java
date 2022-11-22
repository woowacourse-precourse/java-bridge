package bridge.command;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BridgeSizeCommandTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"notNumber", "1a", "22222222222222"})
    void BridgeSizeCommand_클래스는_생성시_int_로_변환할_수_없는_입력이_들어오면_예외(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new BridgeSizeCommand(input));
    }
}
