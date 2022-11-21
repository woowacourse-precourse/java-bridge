package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandTest {
    @DisplayName("재시도/종료 입력값이 R 또는 Q가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"D", "1"})
    void 사용자_재시도_종료_값_예외처리(String command) {
        assertThatThrownBy(() -> GameCommand.findByCommand(command))
                .isInstanceOf(IllegalArgumentException.class);
    }
}