package bridge;

import bridge.vallidation.InputViewValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.constant.ErrorConstant.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputViewValidationTest {

    @DisplayName("예외 처리 : 입력값이 숫자가 아닐때 에러 발생 검증")
    @ParameterizedTest
    @ValueSource(strings = {"10h","hello"," "})
    void checkNotValidDigitInputValidation(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputViewValidation.isValidInput(input))
                .withMessageStartingWith(ERROR_NON_INTEGER);
    }

    @DisplayName("예외 처리 : 다리길이가 범위 안인지 검증")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 37})
    void checkRangeOfBridgeSize(int bridgeSize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputViewValidation.isValidRangeOfBridgeSize(bridgeSize))
                .withMessageStartingWith(ERROR_OUT_OF_RANGE);
    }

    @DisplayName("예외 처리 : 이동할 칸을 제대로 입력했는지 검증 (위: U, 아래: D)")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "u", "d", "g"})
    void checkNotValidMovingCommandValidation(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputViewValidation.isValidMovingCommand(input))
                .withMessageStartingWith(ERROR_NOT_VALID_MOVING_COMMAND);
    }

    @DisplayName("예외 처리 : 재시작 여부에 대한 명령어를 제대로 입력했는지 검증 (재시도: R, 종료: Q)")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "r", "q", "s"})
    void checkNotValidGameCommandValidation(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputViewValidation.isValidGameCommand(input))
                .withMessageStartingWith(ERROR_NOT_VALID_GAME_COMMAND);
    }
}
