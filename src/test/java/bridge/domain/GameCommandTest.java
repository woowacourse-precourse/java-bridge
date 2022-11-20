package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameCommandTest {

    @Test
    void values() {
        for (GameCommand command : GameCommand.values()) {
            System.out.println(command.name());
        }
    }

    @DisplayName("정상 커맨드 입력")
    @ValueSource(strings = {"Q", "R"})
    @ParameterizedTest
    void goodCommand(String c) {
        GameCommand command = GameCommand.of(c);
        assertThat(command.getCommand()).isEqualTo(c);
    }

    @DisplayName("비정상 커맨드 입력")
    @ValueSource(strings = {"A", "B", "C", "D", "E", "F", "Z", "0", "1", "2", "QQ", "RR", "", " ", "\n"})
    @ParameterizedTest
    void badCommand(String c) {
        assertThrows(IllegalArgumentException.class, () -> {
            GameCommand command = GameCommand.of(c);
        });
    }
}