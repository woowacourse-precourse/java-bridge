package bridge.domain.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameCommandTest {

    @DisplayName("재시작 혹은 종료를 위한 입력이 R 또는 Q 가 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"'r'", "'q'", "'5'", "'R&'"})
    void createGameCommand_with_invalid_format(String direction) {
        assertThatThrownBy(() -> new GameCommand(direction))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 혹은 종료를 위한 입력이 공백이라면 예외가 발생한다.")
    @Test
    void createGameCommand_with_blank() {
        assertThatThrownBy(() -> new GameCommand(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
