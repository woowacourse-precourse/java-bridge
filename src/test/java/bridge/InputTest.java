package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class InputTest {
    InputView inputView = new InputView();
    @BeforeEach()
    void setUp() {
        inputView = new InputView();
    }
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    @DisplayName("아무것도 입력하지 않았을 때 예외가 발생한다.")
    void 입력값이_없으면_예외발생(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> inputView.validateIsNotEmpty(input))
                .withMessage("[ERROR] 숫자를 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"!", "base", "15a", "10."})
    @DisplayName("NULL 을 포함하여 숫자가 아닌 값이 입력됐을 때 예외가 발생한다.")
    void 입력값이_숫자가아니면_예외발생(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> inputView.validateIsNumber(input))
                .withMessage("[ERROR] 숫자만 입력할 수 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "-1", "2", "21", "22"})
    @DisplayName("다리 길이 범위를 벗어난 값이 입력됐을 때 예외가 발생한다.")
    void 입력값이_다리길이범위_벗어나면_예외발생(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> inputView.validateIsLengthRange(input))
                .withMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
}
