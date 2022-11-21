package bridge;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.util.Validator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidatorTest {
    private Validator validator = new Validator();

    @Test
    void 다리_길이_유효_검증() {
        for (int bridgeSize = 3; bridgeSize <= 20; bridgeSize++) {
            validator.validateBridgeSize(String.valueOf(bridgeSize));
            assertThatNoException();
        }
    }

    @ParameterizedTest
    @CsvSource({"1", "2", "21", "a"})
    void 다리_길이_예외_검증(String bridgeSize) {
        assertThatThrownBy(() -> validator.validateBridgeSize(bridgeSize)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"U", "D"})
    void 이동_유효_검증(String moving) {
        validator.validateMoving(moving);
        assertThatNoException();
    }

    @ParameterizedTest
    @CsvSource({"a", "2", "Q"})
    void 이동_예외_검증(String moving) {
        assertThatThrownBy(() -> validator.validateMoving(moving)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"R", "Q"})
    void 재시작_유효_검증(String command) {
        validator.validateGameCommand(command);
        assertThatNoException();
    }

    @ParameterizedTest
    @CsvSource({"a", "2", "U"})
    void 재시작_예외_검증(String command) {
        assertThatThrownBy(() -> validator.validateGameCommand(command)).isInstanceOf(IllegalArgumentException.class);
    }
}
