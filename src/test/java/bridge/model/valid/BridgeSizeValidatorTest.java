package bridge.model.valid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class BridgeSizeValidatorTest {

    @DisplayName("3 이상 20 이하의 숫자를 입력하지 않으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"3j", "", "45", "0", "200000000000000000000000"})
    void invalidBridgeSizeInputTest(String input) {
        InputValidator inputValidator = new BridgeSizeValidator();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }

    @DisplayName("3 이상 20 이하의 숫자를 입력하면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"3", "20"})
    void validBridgeSizeInputTest(String input) {
        InputValidator inputValidator = new BridgeSizeValidator();
        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }
}
