package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputValidationTest {

    @DisplayName("예외 처리 : 올바르지 않은 다리 길이에 대한 유효성 검증")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "0", "21", "999"})
    void 다리_길이_유효성_테스트(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidation.validateReadBridgeSize(input));
    }
}
