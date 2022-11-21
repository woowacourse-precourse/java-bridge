package bridge.validate;

import bridge.exception.InvalidStringFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class validateStringFormatTest {

    @DisplayName("문자가 아닌 값이 들어오면 에러를 발생한다.")
    @Test
    void InputStringByWrongFormat() {
        assertThatThrownBy(() -> validateStringFormat.validate("1"))
                .isInstanceOf(InvalidStringFormatException.class);
    }

    @DisplayName("알파벳이 들어오면 정상적으로 통과한다.")
    @Test
    void InputStringByCorrectFormat() {
        // given
        String string = "abcdek";

        // when
        validateStringFormat.validate(string);

        // then
    }
}
