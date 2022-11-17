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
}
