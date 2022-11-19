package Utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidateUtilsTest {

    @Nested
    @DisplayName("isValidateLength 메소드 테스트")
    class TestIsValidateLength {
        @DisplayName("범위에 맞지 않는 다리 길이를 입력했을 때")
        @ValueSource(strings = {"-100", "43", "100jj", "삼", "3?"})
        @ParameterizedTest
        void case1(String input) {
            assertThatThrownBy(() -> ValidateUtils.isValidateLength(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }

}