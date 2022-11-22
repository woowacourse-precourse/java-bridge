package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class TypeChangeTest {

    @Nested
    class ChangeStringToIntegerTest {

        TypeChange typeChange = new TypeChange();

        @DisplayName("숫자가 아닌 문자를 입력 받았을때 예외 처리 되는지 확인")
        @Test
        void case1() {
            String test = "a";
            assertThatThrownBy(() -> typeChange.ChangeStringToInteger(test))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자를 입력해주세요");
        }

        @DisplayName("숫자와 문자를 입력 받았을때 예외 처리 되는지 확인")
        @Test
        void case2() {
            String test = "10j";
            assertThatThrownBy(() -> typeChange.ChangeStringToInteger(test))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자를 입력해주세요");
        }

        @DisplayName("숫자가 아닌 기호를 입력 받았을때 예외 처리 되는지 확인")
        @Test
        void case3() {
            String test = "=";
            assertThatThrownBy(() -> typeChange.ChangeStringToInteger(test))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자를 입력해주세요");
        }

        @DisplayName("문자형에서 정수형으로 형변환 되는지 확인")
        @Test
        void case4() {
            String test = "3";
            int answer = 3;

            assertEquals(answer, typeChange.ChangeStringToInteger(test));
        }

    }
}