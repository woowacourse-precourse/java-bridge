package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.userInfo.GameCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameCommandTest {

    @DisplayName("재시작 혹은 종료를 위한 입력이 공백이라면 예외가 발생한다.")
    @Test
    void createDirectionWithBlank() {
        assertThatThrownBy(() -> new GameCommand(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 혹은 종료를 위한 입력이 R 또는 Q 가 아니라면 예외가 발생한다.")
    @Test
    void createDirectionWithInvalidCharacter() {
        assertThatThrownBy(() -> new GameCommand("r"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}