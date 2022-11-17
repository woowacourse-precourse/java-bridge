package bridge;

import static bridge.Validator.validateInputSize;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    @DisplayName("다리 길이 숫자 범위 테스트")
    @ValueSource(ints = {-1, 0, 46})
    @Test
    void validateInputSizeTest(int input) {
        validateInputSize(input);
    }
}
