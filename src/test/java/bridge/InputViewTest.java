package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputViewTest {
    @Test
    @DisplayName("다리 길이를 입력받고 예외를 잘 처리하는지 확인")
    public void checkCorrectLengthTest() {
        InputView inputView = new InputView();
        String input = "35";
        assertThatThrownBy(() -> inputView.checkCorrectLength(input)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("U나 D가 입력되지 않았을 때 예외를 던지는지 확인")
    public void checkCorrectMovingTest() {
        InputView inputView = new InputView();
        String input = "IO";
        assertThatThrownBy(() -> inputView.checkCorrectMoving(input)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }


    @Test
    @DisplayName("R이나 Q가 입력되지 않았을 때 예외를 던지는지 확인")
    public void checkCorrectRetryTest() {
        InputView inputView = new InputView();
        String input = "DD";
        assertThatThrownBy(() -> inputView.checkCorrectRetry(input)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR");
    }
}
