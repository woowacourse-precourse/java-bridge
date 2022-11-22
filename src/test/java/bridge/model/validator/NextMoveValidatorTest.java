package bridge.model.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NextMoveValidatorTest {
    @ParameterizedTest
    @DisplayName("잘못된 이동할 칸을 입력 받으면 예외를 발생시킨다.")
    @CsvSource({
            "A",
            "b",
            "d",
            "u",
            "UU",
            "1",
            "2D"
    })
    void throwExceptionForInvalidNextMove(String input) {
        assertThatThrownBy(() -> new NextMoveValidator().validateInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
