package bridge;

import bridge.util.MessageConstant;
import bridge.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class InputTest {
    InputView inputView = new InputView();
    @BeforeEach()
    void setUp() {
        inputView = new InputView();
    }
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    @DisplayName("아무것도 입력하지 않았을 때 예외가 발생한다.")
    void 입력값이_없으면_예외발생(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.readBridgeSize(input))
                .withMessage(MessageConstant.ERROR_EMPTY.getValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    @DisplayName("U or D대신 아무것도 입력하지 않았을 때 예외가 발생한다.")
    void U_OR_D_대신_아무것도_입력하지_않았을때_예외가_발생한다(String direction) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.readMoving(direction))
                .withMessage(MessageConstant.ERROR_EMPTY.getValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"!", "base", "15a", "10.", "020", "05"})
    @DisplayName("NULL 을 포함하여 숫자가 아닌 값이 입력됐을 때 예외가 발생한다.")
    void 입력값이_숫자가아니면_예외발생(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.readBridgeSize(input))
                .withMessage(MessageConstant.ERROR_BRIDGE_LENGTH.getValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "-1", "2", "21", "22"})
    @DisplayName("다리 길이 범위를 벗어난 값이 입력됐을 때 예외가 발생한다.")
    void 입력값이_다리길이범위_벗어나면_예외발생(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.readBridgeSize(input))
                .withMessage(MessageConstant.ERROR_BRIDGE_LENGTH.getValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "a", "b", "1", "2", "UD"})
    @DisplayName("사용자가 U or D가 아닌 다른 값을 입력하면 예외가 발생한다.")
    void 입력값이_U_OR_D가_아닐때_예외발생(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.readMoving(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    @DisplayName("사용자가 U or D를 입력하면 해당 값을 Return한다.")
    void 입력값이_U_OR_D일때_정상_Return_한다(String input) {
        assertThat(inputView.readMoving(input)).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"})
    @DisplayName("정상 범위의 다리길이가 입력되면 해당 숫자를 Return한다.")
    void 다리길이_입력값이_정상일때_정상_Return_한다(String length) {
        assertThat(inputView.readBridgeSize(length))
                .isEqualTo(Integer.valueOf(length));
    }
}
