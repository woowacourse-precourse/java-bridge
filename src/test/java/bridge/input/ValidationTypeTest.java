package bridge.input;

import bridge.type.ValidationType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidationTypeTest {

    @DisplayName("입력 사이즈에 따른 예외 테스트")
    @ValueSource(strings = {"-11", "3.3", "a", "+3", "-", "21"})
    @ParameterizedTest
    void checkSize_예외(String input) {
        boolean canRead = ValidationType.validate(ValidationType.CHECK_SIZE, input);
        assertThat(canRead).isFalse();
    }

    @DisplayName("입력 사이즈에 따른 정상 테스트")
    @ValueSource(strings = {"3", "15", "20"})
    @ParameterizedTest
    void checkSize_정상(String input) {
        boolean canRead = ValidationType.validate(ValidationType.CHECK_SIZE, input);
        assertThat(canRead).isTrue();
    }

    @DisplayName("이동할 칸에 대한 입력에 따른 예외 테스트")
    @ValueSource(strings = {"u", "d", "1", "a"})
    @ParameterizedTest
    void checkMoving_예외(String input) {
        boolean canRead = ValidationType.validate(ValidationType.CHECK_MOVING, input);
        assertThat(canRead).isFalse();
    }

    @DisplayName("이동할 칸에 대한 입력에 따른 정상 테스트")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void checkMoving_정상(String input) {
        boolean canRead = ValidationType.validate(ValidationType.CHECK_MOVING, input);
        assertThat(canRead).isTrue();
    }

    @DisplayName("게임 재시작 여부에 대한 입력에 따른 예외 테스트")
    @ValueSource(strings = {"r", "q", "1", "a"})
    @ParameterizedTest
    void checkGameCommand_예외(String input) {
        boolean canRead = ValidationType.validate(ValidationType.CHECK_GAME_COMMAND, input);
        assertThat(canRead).isFalse();
    }

    @DisplayName("게임 재시작 여부에 대한 입력에 따른 정상 테스트")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void checkGameCommand_정상(String input) {
        boolean canRead = ValidationType.validate(ValidationType.CHECK_GAME_COMMAND, input);
        assertThat(canRead).isTrue();
    }
}
