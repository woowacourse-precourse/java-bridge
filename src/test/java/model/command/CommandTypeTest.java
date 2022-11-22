package model.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandTypeTest {

    @DisplayName("R 또는 Q가 아닐 때 예외 처리")
    @ValueSource(strings = {"P", "S", "O", "U"})
    @ParameterizedTest(name = "[{index}]  command : {0}")
    void isRetry(String command) {
        assertThatThrownBy(() ->
                CommandType.isRetry(command)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("R 또는 Q가 아닙니다.");

    }
}