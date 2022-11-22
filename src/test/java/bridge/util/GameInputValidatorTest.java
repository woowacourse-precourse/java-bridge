package bridge.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameInputValidatorTest {

    private final String lowStringNumber = "10";
    private final String upStringNumber = "30";
    private final Integer lowIntNumber = 10;
    private final Integer upIntNumber = 30;
    private final String upper = "U";
    private final String lower = "D";
    private final String retry = "R";
    private final String quit = "Q";
    private final String nullMessage = "null";
    private final GameInputValidator validator = new GameInputValidator();

    @DisplayName("[3 ~ 20] 범위에 속하는 문자열이 들어왔을때")
    @Test
    void isRangedNumber() {
        // given
        int rangedNumber = validator.parseNumber(lowStringNumber);

        // when

        // then
        Assertions.assertThat(rangedNumber).isEqualTo(lowIntNumber);
    }

    @DisplayName("[3 ~ 20] 범위에 속하지 않는 문자열이 들어왔을때")
    @Test
    void isNotRangedNumber() {
        // given

        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> validator.parseNumber(upStringNumber));
    }

    @DisplayName("Moving 입력이 U 또는 D인 경우")
    @Test
    void isValidMoving() {
        // given

        // when
        String validMovingMessage = validator.isValidMovingMessage(upper);

        // then
        Assertions.assertThat(validMovingMessage).isEqualTo(upper);
    }

    @DisplayName("Moving 입력이 U 또는 D가 아닌 경우")
    @Test
    void isNotValidMoving() {
        // given

        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> validator.isValidMovingMessage(nullMessage));
    }

    @DisplayName("Retry 입력이 R 또는 Q인 경우")
    @Test
    void isValidRetry() {
        // given

        // when
        String validRetryMessage = validator.isValidRetryMessage(retry);

        // then
        Assertions.assertThat(validRetryMessage).isEqualTo(retry);
    }

    @DisplayName("Retry 입력이 R 또는 Q가 아닌 경우")
    @Test
    void isNotValidRetry() {
        // given

        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> validator.isValidRetryMessage(nullMessage));
    }
}
