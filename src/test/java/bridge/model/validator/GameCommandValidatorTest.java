package bridge.model.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameCommandValidatorTest {
    @ParameterizedTest
    @DisplayName("잘못된 커멘드를 입력 받으면 예외를 발생시킨다.")
    @CsvSource({
            "r",
            "q",
            "G",
            "D",
            "UU",
            "1",
            "2D"
    })
    void throwExceptionForInvalidGameCommand(String input) {
        assertThatThrownBy(() -> new GameCommandValidator().validateInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
