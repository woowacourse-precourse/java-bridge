package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameCommandTest {

    @DisplayName("재시작 여부 입력 테스트 - 실패")
    @ParameterizedTest
    @ValueSource(strings = {"woowa", "tech", "course"})
    void inputRestartFailTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> GameCommand.getByCommandString(input));
    }

    @DisplayName("재시작 여부 입력 테스트 - 실패")
    @ParameterizedTest
    @ValueSource(strings = {"Q", "R"})
    void inputRestartSuccessTest(String input) {
        assertDoesNotThrow(() -> GameCommand.getByCommandString(input));
    }

}