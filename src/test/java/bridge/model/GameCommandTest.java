package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class GameCommandTest {

    @DisplayName("재시작/종료 여부 예외 처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "r", "W"})
    void createCommandExceptionTest(String command) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> GameCommand.of(command));
    }
}