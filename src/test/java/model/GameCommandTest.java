package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameCommandTest {

    @DisplayName("재시작/종료 여부가 R 또는 Q가 아닐 때 예외 처리")
    @ValueSource(strings = {"P", "S", "O", "U"})
    @ParameterizedTest(name = "[{index}]  command : {0}")
    void excessSize(String command) {
        assertThatThrownBy(() ->
                new GameCommand(command)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 재시작/종료 여부는 R 또는 Q여야 합니다.");
    }

    @DisplayName("재시작/종료 여부가 R 또는 Q일 때 통과")
    @ValueSource(strings = {"R", "Q", "r", "q", " R", "Q ", "r ", " q"})
    @ParameterizedTest(name = "[{index}]  command : [{0}]")
    void correctSize(String command) {
        assertThatCode(() ->
                new GameCommand(command)
        ).doesNotThrowAnyException();
    }
}