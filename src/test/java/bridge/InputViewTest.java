package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.type.ErrorType;
import bridge.view.InputView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    private static InputView inputView;

    @BeforeAll
    static void setup() {
        inputView = new InputView();
    }

    @Test
    void 입력_값이_숫자일시_입력_값_정수로_반환() {
        String input = "12";

        assertThat(inputView.parseNumber(input)).isEqualTo(12);
    }

    @Test
    void 입력_값이_숫자가_아닌_경우_예외_발생() {
        String input = "a1";

        assertThatThrownBy(() -> inputView.parseNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.NOT_NUMBER_INPUT.getError());
    }

    @Test
    void 다리_길이_허용범위_초과_시_예외_발생() {
        int overSize = 100;

        assertThatThrownBy(() -> inputView.validateSize(overSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.OVER_SIZE.getError());
    }

    @Test
    void 이동할_칸이_U_또는_D가_아니면_예외() {
        String input = "L";

        assertThatThrownBy(() -> inputView.validateMoving(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.NOT_MOVING_INPUT.getError());
    }

}
