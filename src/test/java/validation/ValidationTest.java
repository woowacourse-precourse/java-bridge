package validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ValidationTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @ParameterizedTest
    @ValueSource(strings = {"j", "값", ".", "1 2"})
    void 다리의_길이_입력_값이_숫자가_아닐_경우_예외_처리(String input) {
        assertThatThrownBy(() -> Validation.ofBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE)
                .hasMessageContaining("다리의 길이는 숫자이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "21", "2", "1000"})
    void 다리의_길이_입력_값이_3이상_20이하가_아닐_경우_예외_처리(String input) {
        assertThatThrownBy(() -> Validation.ofBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE)
                .hasMessageContaining("다리의 길이는 3 이상 20 이하의 숫자이어야 합니다.");
    }
}
