package bridge;

import bridge.View.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ExceptionTest {
    InputView inputView = new InputView();
    @DisplayName("다리 길이 입력시 숫자가 아닌 경우 예외 처리 테스트")
    @Test
    void BridgeLengthInputNotNumberExceptionTest() {
        // given
        String inputNotNumber = "22";

        // when, then
        assertThatThrownBy(() -> inputView.validateBridgeLength(inputNotNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }

    @DisplayName("이동시 U나 D 이외의 값을 입력한 경우 예외 처리 테스트")
    @Test
    void validateIsUOrDTest() {
        // given
        String inputNotUOrD = "K";

        // when, then
        assertThatThrownBy(() -> inputView.validateIsUOrD(inputNotUOrD))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("재시작/종료 입력시 R나 Q 이외의 값을 입력한 경우 예외 처리 테스트")
    @Test
    void validateIsROrQTest() {
        // given
        String inputNotROrQ = "K";

        // when, then
        assertThatThrownBy(() -> inputView.validateIsROrQ(inputNotROrQ))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
