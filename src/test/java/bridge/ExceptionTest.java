package bridge;

import bridge.View.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ExceptionTest {
    @DisplayName("다리 길이 입력시 숫자가 아닌 경우 예외 처리 테스트")
    @Test
    void BridgeLengthInputNotNumberExceptionTest() {
        // given
        String inputNotNumber = "22";
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.validateBridgeLength(inputNotNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }
}
