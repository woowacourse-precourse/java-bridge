package bridge.core;

import static bridge.ErrorMessage.INVALID_GAME_COMMAND_ERROR;
import static bridge.core.GameCommand.QUIT;
import static bridge.core.GameCommand.RETRY;
import static bridge.core.GameCommand.getEnum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandTest {

    @DisplayName("게임 재시작 여부 선택에서 R 입력시 재시작이 선택된다.")
    @Test
    void getRetryEnumTest() {
        GameCommand gameCommand = getEnum("R");

        assertThat(gameCommand).isEqualTo(RETRY);
    }

    @DisplayName("게임 재시작 여부 선택에서 Q 입력시 게임 종료가 선택된다.")
    @Test
    void getQuitEnumTest() {
        GameCommand gameCommand = getEnum("Q");

        assertThat(gameCommand).isEqualTo(QUIT);
    }

    @ParameterizedTest(name = "게임 커멘드를 {0}로 잘못 입력한 경우 예외가 발생한다.")
    @ValueSource(strings = {"RR", "U", "", " ", "q"})
    void getQuitExceptionTest(String input) {
        assertThatThrownBy(() -> getEnum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_GAME_COMMAND_ERROR);
    }
}