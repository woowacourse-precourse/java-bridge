package bridge.constant.command;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constant.message.GameErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CommandTest {
    @DisplayName("코드에 해당하는 명령어 값 반환한다.")
    @Test
    void testConvertKeyToValue() {
        DirectionCommand upCommand = DirectionCommand.UP;
        assertThat(Command.convertKeyToValue(upCommand.getKey(), DirectionCommand.class)).isEqualTo(
                upCommand.getValue());
    }

    @DisplayName("존재하지 않은 코드 값이면 예외를 발생한다.")
    @Test
    void testNotConvertKeyToValue() {
        assertThatThrownBy(() -> Command.convertKeyToValue(999, DirectionCommand.class)).hasMessage(
                GameErrorMessage.NO_SUCH_COMMAND.getMessage()).isInstanceOf(IllegalStateException.class);

    }
}
