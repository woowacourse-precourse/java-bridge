package bridge.model.valid;

import bridge.model.valid.BridgeSizeValidator;
import bridge.model.valid.GameCommandValidator;
import bridge.model.valid.InputValidator;
import bridge.model.valid.MovingValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class InputValidatorTest {

    /*
     * 다리 길이 입력에 대한 예외 검사
     * */
    @DisplayName("3 이상 20 이하의 숫자를 입력하지 않으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"3j", "", "45", "0", "200000000000000000000000"})
    void invalidBridgeSizeInputTest(String input) {
        InputValidator inputValidator = new BridgeSizeValidator();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }

    @DisplayName("3 이상 20 이하의 숫자를 입력하면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"3", "20"})
    void validBridgeSizeInputTest(String input) {
        InputValidator inputValidator = new BridgeSizeValidator();
        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }

    /*
     * 이동할 칸 입력에 대한 예외 검사
     * */
    @DisplayName("U, D 중 하나를 입력하지 않으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"u", "d", "UD"})
    void invalidMovingInputTest(String input) {
        InputValidator inputValidator = new MovingValidator();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }

    @DisplayName("U, D 중 하나를 입력하면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void validMovingInputTest(String input) {
        InputValidator inputValidator = new MovingValidator();
        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }

    /*
     * 게임 재시작/종료 여부 입력에 대한 예외 검사
     * */
    @DisplayName("R, Q 중 하나를 입력하지 않으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "RQ"})
    void invalidGameCommandInputTest(String input) {
        InputValidator inputValidator = new GameCommandValidator();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }

    @DisplayName("R, Q 중 하나를 입력하면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void validGameCommandInputTest(String input) {
        InputValidator inputValidator = new GameCommandValidator();
        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateInput(input));
    }
}
