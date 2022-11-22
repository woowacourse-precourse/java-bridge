package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @DisplayName("다리 길이 경계값 예외 테스트 ")
    @ParameterizedTest
    @ValueSource(ints = {21, 2})
    void validateSizeRangeExceptionTest(int size) {
        assertThatThrownBy(() -> Validator.validateSizeRange(size))
                .isInstanceOf(IllegalArgumentException.class);
    }
}