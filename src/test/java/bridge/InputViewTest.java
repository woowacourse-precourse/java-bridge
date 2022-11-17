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


}
