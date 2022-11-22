package bridge.command;

import static bridge.config.ExceptionMessage.ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SizeTest {

    @DisplayName("길이를 숫자를 입력하지 않으면 예외가 발생")
    @ValueSource(strings = {"일", "2이", "23!", "1@", ""})
    @ParameterizedTest
    void inputNotNumber(String input) {
        assertThatThrownBy(()-> new Size(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR);
    }

    @DisplayName("길이가 3 ~ 20이 아닐때 예외가 발생")
    @ValueSource(strings = {"44", "2", "-10", "0"})
    @ParameterizedTest
    void inputNumberOutOfRange(String input) {
        assertThatThrownBy(()-> new Size(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR);
    }
}
