package Utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class InputUtilsTest {

    @Nested
    @DisplayName("isDigit 메소드 테스트")
    class TestIsDigit {
        @Test
        @DisplayName("정수를 입력받을 경우")
        void case1() {
            String input = "3";
            assertThat(InputUtils.isDigit(input)).isTrue();
        }


        @DisplayName("정수 이외의 값을 입력받을 경우")
        @ValueSource(strings = {"숫자", "??", "1000j", "abcd"})
        @ParameterizedTest
        void case2(String input) {
            assertThat(InputUtils.isDigit(input)).isFalse();
        }
    }


}