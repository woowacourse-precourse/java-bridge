package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputExceptionTest {

    InputException inputException;

    @BeforeEach
    public void setUp() {
        inputException = new InputException();
    }

    @DisplayName("다리 길이 입력값 숫자가 아닌 경우 예외 처리 테스트")
    @Test
    void validateReadBridgeSizeNumber() {
        String inputNumber = "2a";
        assertThatIllegalArgumentException().isThrownBy(() -> inputException.validateReadBridgeSize(inputNumber));
    }

    @DisplayName("다리 길이 입력값 범위 벗어나는 경우 예외 처리 테스트")
    @Test
    void validateReadBridgeSizeRange() {
        String inputNumber = "33";
        assertThatIllegalArgumentException().isThrownBy(() -> inputException.validateReadBridgeSize(inputNumber));
    }

    @DisplayName("다리 길이 입력값이 숫자인 경우 테스트")
    @Test
    void isNumber() {
        String inputNumber = "16";

        boolean checkNumber = inputException.isNumber(inputNumber);

        assertThat(checkNumber).isTrue();
    }

    @DisplayName("다리 길이 입력값이 숫자가 아닌 경우 테스트")
    @Test
    void isNotNumber() {
        String inputNumber = "1s";

        boolean checkNumber = inputException.isNumber(inputNumber);

        assertThat(checkNumber).isFalse();
    }

    @DisplayName("다리 길이 입력값의 범위가 3이상 20이하인 경우 테스트")
    @Test
    void isRangeThreeToTwenty() {
        String inputNumber = "3";

        boolean checkNumber = inputException.isRangeThreeToTwenty(inputNumber);

        assertThat(checkNumber).isTrue();
    }

    @DisplayName("다리 길이 입력값의 범위가 3이상 20이하가 아닌 경우 테스트")
    @Test
    void isNotRangeThreeToTwenty() {
        String inputNumber = "21";

        boolean checkNumber = inputException.isRangeThreeToTwenty(inputNumber);

        assertThat(checkNumber).isFalse();
    }
}