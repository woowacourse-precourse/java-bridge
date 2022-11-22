package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ValidationUtil;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationUtilTest {
    ValidationUtil validationUtil = new ValidationUtil();

    @DisplayName("사용자 이동 입력이 공백이면 예외가 발생해야 한다.")
    @Test
    public void validateUserMovementIfNullTest() {
        //given
        String userInput = "";

        //when

        //then
        assertThatThrownBy(() -> validationUtil.validateUserMovementIfNull(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 이동 입력이 U or D가 아니면 예외가 발생해야 한다.")
    @Test
    public void validateUserMovementTest() {
        //given
        String userInput = "T";
        //when

        //then
        assertThatThrownBy(() -> validationUtil.validateUserMovement(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 다리 길이 입력이 3~20 범위를 넘으면 예외가 발생해야 한다.")
    @Test
    public void validateBridgeSizeInputTest() {
        //given
        String bridgeSize = "21";

        //when

        //then
        assertThatThrownBy(() -> validationUtil.validateBridgeSizeInput(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 다리 길이 입력이 공백인 경우 예외가 발생해야 한다.")
    @Test
    public void validateBridgeSizeNullInputTest() {
        //given
        String bridgeSize = "";
        //when

        //then
        assertThatThrownBy(() -> validationUtil.validateBridgeSizeNullInput(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 다리 길이 입력이 문자가 포함되어 있으면 예외가 발생해야 한다.")
    @Test
    public void validateBridgeSizeDigitInputTest() {
        //given
        String bridgeSize = "3d";
        //when

        //then
        assertThatThrownBy(() -> validationUtil.validateBridgeSizeDigitInput(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 종료 및 재시도 입력이 R 또는 Q가 아닌 경우 예외가 발생해야 한다.")
    @Test
    public void validateExitCodeTest() {
        //given
        String exitCode = "K";

        //when
        //then
        assertThatThrownBy(() -> validationUtil.validateExitCode(exitCode))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
