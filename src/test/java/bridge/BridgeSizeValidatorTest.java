package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class BridgeSizeValidatorTest {

    private static final InputValidator inputValidator = new BridgeSizeValidator();

    @DisplayName("잘못된 다리 길이를 입력 받으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"3j", "", "45", "0", "200000000000000000000000"})
    void invalidBridgeSizeInputTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }

    @DisplayName("올바른 다리 길이를 입력 받으면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"3", "20"})
    void validBridgeSizeInputTest(String input) {
        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }
}
