package bridge.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameFlagTest {

    @ParameterizedTest
    @DisplayName("GameFlag를 생성할 때 R 또는 Q 외의 입력이 들어오면 예외가 발생해야 한다.")
    @ValueSource(strings = {"0", "1", "U", "D"})
    void createGameFlagByOtherString(String input) {
        // expect
        assertThatThrownBy(() -> GameFlag.ofString(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("GameFlag를 생성할 때 R 또는 Q 입력이 들어오면 정상적으로 생성되어야 한다.")
    @ValueSource(strings = {"R", "Q"})
    void createGameFlagBy_R_Or_Q_String(String input) {
        // expect
        assertThat(GameFlag.ofString(input))
                .isInstanceOf(GameFlag.class);
    }
}