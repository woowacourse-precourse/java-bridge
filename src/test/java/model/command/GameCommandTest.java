package model.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameCommandTest {

    @DisplayName("재시도/종료 여부가 R 또는 Q가 아닐 때 예외 처리")
    @ValueSource(strings = {"P", "S", "O", "U"})
    @ParameterizedTest(name = "[{index}]  command : {0}")
    void excessSize(String command) {
        assertThatThrownBy(() ->
                new GameCommand(command)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 재시도/종료 여부는 R 또는 Q여야 합니다.");
    }

    @DisplayName("재시도/종료 여부가 R 또는 Q일 때 통과")
    @ValueSource(strings = {"R", "Q", "r", "q", " R", "Q ", "r ", " q"})
    @ParameterizedTest(name = "[{index}]  command : [{0}]")
    void correctSize(String command) {
        assertThatCode(() ->
                new GameCommand(command)
        ).doesNotThrowAnyException();
    }

    @DisplayName("재시도를 선택했을 때 재시도 여부 TRUE 반환")
    @Test
    void isRetry() {
        GameCommand gameCommand = new GameCommand("R");
        assertTrue(gameCommand.isRetry());
    }

    @DisplayName("종료를 선택했을 때 재시도 여부 FALSE 반환")
    @Test
    void isQuit() {
        GameCommand gameCommand = new GameCommand("Q");
        assertFalse(gameCommand.isRetry());
    }
}