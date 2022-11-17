package bridge;

import static bridge.config.ExceptionMessage.ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.option.Option;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OptionTest {

    @DisplayName("알파벳 대문자만 입력하지 않으면 예외가 발생")
    @ValueSource(strings = {"a", "Aa", "aA", "1A", ""})
    @ParameterizedTest
    void inputNotUppercase(String input) {
        assertThatThrownBy(()-> new Option(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR);
    }
}
