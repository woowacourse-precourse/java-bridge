package bridge;

import bridge.view.CommandType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CommandTypeTest {

    @DisplayName("사용자의 올바른 입력에 대해서 명령어를 불러오는 테스트")
    @CsvSource(value = {"U:MOVE_TO_UP", "D:MOVE_TO_DOWN", "R:GAME_RETRY", "Q:GAME_QUIT"}, delimiter = ':')
    @ParameterizedTest
    public void loadValidCommand(String input, CommandType commandType) {
        assertThat(CommandType.of(input)).isEqualTo(commandType);
    }

    @DisplayName("찾을 수 없는 명령어에 대해 예외 처리 테스트")
    @ValueSource(strings = {"s", "1", "g", "erg"})
    @ParameterizedTest
    public void loadInvalidCommandInput(String input) {
        assertThatThrownBy(() -> CommandType.of(input))
                .isInstanceOf(NoSuchElementException.class);
    }
}
