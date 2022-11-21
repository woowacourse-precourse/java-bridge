package bridge.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameCommandTest {

    @DisplayName("R, Q가 주어질 때 GameCommand 생성")
    @Test
    void createGameCommand() {
        GameCommand restart = GameCommand.of("R");
        GameCommand quit = GameCommand.of("Q");
        assertThat(restart.isRestart()).isTrue();
        assertThat(quit.isQuit()).isTrue();
    }

    @DisplayName("R, Q 이외의 입력 값으로 GameCommand 생성 시 예외 발생")
    @Test
    void createCommandInvalidInput() {
        assertThatThrownBy(() -> GameCommand.of("d"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 게임 재시작/종료 여부 입력의 경우 R과 Q 뿐이어야 합니다.");
    }
}
