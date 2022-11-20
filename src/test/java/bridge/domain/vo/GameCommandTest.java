package bridge.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.domain.vo.GameCommand.createGameCommand;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameCommandTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("R 또는 Q의 문자 1개를 입력 시 예외가 발생하지 않는다.")
    @Test
    void SuccessCase() {
        assertThatCode(() -> createGameCommand("R"))
                .doesNotThrowAnyException();

        assertThatCode(() -> createGameCommand("Q"))
                .doesNotThrowAnyException();
    }

    @DisplayName("R 또는 Q의 문자 1개를 입력 시 성공적으로 GameCommand를 생성한다.")
    @Test
    void createGameCommandTest() {
        assertThat(createGameCommand("R"))
                .isInstanceOf(GameCommand.class);

        assertThat(createGameCommand("Q"))
                .isInstanceOf(GameCommand.class);
    }

    @DisplayName("GameCommand를 1개 이상의 문자를 입력 시 예외가 발생한다.")
    @Test
    void case1() {
        assertThatThrownBy(() -> createGameCommand("hi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("GameCommand를 R 또는 Q로 입력하지 않을 시 예외가 발생한다.")
    @Test
    void case2() {
        assertThatThrownBy(() -> createGameCommand("A"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}