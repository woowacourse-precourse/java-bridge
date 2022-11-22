package bridge.validatorTest;

import bridge.validator.MovingValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MovingValidatorTest {

    @DisplayName("잘못된 이동 명령을 입력받았을 때 예외가 발생하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"DD", "UU", "A", "B", "5"})
    public void checkInValidateMovingCommand(String command) {
        assertThatThrownBy(() -> new MovingValidator().validate(command))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
