package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Nested
    class IsNumber {
        @DisplayName("입력값이 숫자로 변환되는 경우 변환된 값을 반환한다.")
        @Test
        void inputByNumber() {
            // given
            String input = "4";

            // when
            int number = Validator.isNumber(input);

            // then
            Assertions.assertThat(number).isEqualTo(Integer.parseInt(input));
        }

        @DisplayName("입력값이 숫자로 변환되지 않는 경우 예외를 반환한다.")
        @Test
        void inputByString() {
            String input = "adf";

            Assertions.assertThatThrownBy(() -> Validator.isNumber(input))
                    .hasMessageContaining("[ERROR] 다리 길이는 숫자여야 합니다.")
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class IsInRange {
        @DisplayName("입력 숫자가 3 ~ 20 사이라면 예외를 반환하지 않는다.")
        @Test
        void inputByNumber() {
            Assertions.assertThatNoException()
                    .isThrownBy(() -> Validator.isInRange(6));
        }

        @DisplayName("입력 숫자가 3 ~ 20 사이가 아니라면 예외를 반환한다.")
        @Test
        void inputByString() {
            Assertions.assertThatThrownBy(() -> Validator.isInRange(24))
                    .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
