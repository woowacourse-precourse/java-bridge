package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {

    @DisplayName("다리 개수 입력에 숫자가 아닌 값이 들어가면 예외가 발생한다")
    @Test
    void inputBridgeSizeByNotNumberType() {
        InputValidator inputValidator = new InputValidator();

        assertThatThrownBy(() -> inputValidator.validateNumberType("a123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 개수 입력에 숫자가 들어가면 예외가 발생하지 않는다")
    @Test
    void inputBridgeSizeByNumberType() {
        InputValidator inputValidator = new InputValidator();

        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateNumberType("123"));
    }

    @DisplayName("숫자 앞에 0이 입력되면 예외가 발생한다")
    @Test
    void inputBridgeSizeByZeroPrefixNumber() {
        InputValidator inputValidator = new InputValidator();


        assertThatThrownBy(() -> inputValidator.validateZeroPrefix("0123"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidator.validateZeroPrefix("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 앞에 0이 들어가 있지 않으면 예외가 발생하지 않는다")
    @Test
    void inputBridgeSizeByNotZeroPrefixNumber() {
        InputValidator inputValidator = new InputValidator();

        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateZeroPrefix("1230"));

    }

    @DisplayName("숫자의 범위가 3이상 20이하가 아니면 예외가 발생한다")
    @Test
    void inputBridgeSizeByOutOfRangeNumber() {
        InputValidator inputValidator = new InputValidator();

        assertThatThrownBy(() -> inputValidator.validateBridgeSize(2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidator.validateBridgeSize(21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자의 범위가 3이상 20이하면 예외가 발생하지 않는다")
    @Test
    void inputBridgeSizeByWithinRangeNumber() {
        InputValidator inputValidator = new InputValidator();

        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateBridgeSize(3));
        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateBridgeSize(20));
    }

    @DisplayName("이동할 칸이 U나 D가 아니면 예외가 발생한다")
    @Test
    void getMovingPositionByNotUOrD() {
        InputValidator inputValidator = new InputValidator();

        assertThatThrownBy(() -> inputValidator.validateMovingPosition("L"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸이 U나 D이면 예외가 발생하지 않는다")
    @Test
    void getMovingPositionByUOrD() {
        InputValidator inputValidator = new InputValidator();

        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateMovingPosition("U"));
        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateMovingPosition("D"));
    }

    @DisplayName("재시작 여부 입력이 R이나 Q가 아니면 예외가 발생한다")
    @Test
    void getGameCommandByNotRorQ() {
        InputValidator inputValidator = new InputValidator();

        assertThatThrownBy(() -> inputValidator.validateGameCommand("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 여부 입력이 R이나 Q가 이면 예외가 발생하지 않는다")
    @Test
    void getGameCommandByRorQ() {
        InputValidator inputValidator = new InputValidator();

        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateGameCommand("R"));
        assertThatNoException()
                .isThrownBy(() -> inputValidator.validateGameCommand("Q"));
    }
}
