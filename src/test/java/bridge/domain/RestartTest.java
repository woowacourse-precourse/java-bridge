package bridge.domain;

import bridge.exception.InvalidRestartFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RestartTest {

    @DisplayName("R 혹은 Q가 아닌 값이 들어오면 에러를 발생한다.")
    @Test
    void checkValidateByWrongString() {
        assertThatThrownBy(() -> Restart.validate("A"))
                .isInstanceOf(InvalidRestartFormatException.class);
    }

    @DisplayName("R 혹은 Q가 들어오면 정상 통과한다.")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void checkValidateByCorrectString(String string) {
        Restart.validate(string);
    }
}
