package bridge.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class TextValidatorTest {
    private final static String MOVE_WAY_ERROR_MESSAGE = "[ERROR] 이동 방향은 U또는 D만 입력 가능합니다.";

    @DisplayName("이동 방향 입력이 U 또는 D가 아닐 시 예외가 발생한다.")
    @Nested
    class isUpOrDownTest {
        @Test
        void 값이_올바른_경우() {
            TextValidator.validateMoveWay("U");
            TextValidator.validateMoveWay("D");
        }

        @CsvSource({"A", "s", "u", "1", "-8", "~", "!!!"})
        @ParameterizedTest
        void U_또는_D가_아닌_경우(String input) {
            assertThatThrownBy(() -> TextValidator.validateMoveWay(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(MOVE_WAY_ERROR_MESSAGE);
        }
    }


}