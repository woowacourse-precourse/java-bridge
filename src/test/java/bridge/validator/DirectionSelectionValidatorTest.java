package bridge.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DirectionSelectionValidatorTest {

    @DisplayName("방향 입력 테스트 - 실패")
    @ParameterizedTest
    @ValueSource(strings = {"woowa", "tech", "course"})
    void inputRestartFailTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> DirectionSelectionValidator.validate(input));
    }

    @DisplayName("방향 입력 테스트 - 성공")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void inputRestartSuccessTest(String input) {
        assertDoesNotThrow(() -> DirectionSelectionValidator.validate(input));
    }
}