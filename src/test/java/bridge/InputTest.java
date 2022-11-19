package bridge;

import bridge.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {
    @DisplayName("다리 길이 입력값 검사")
    @Test
    void bridgeSizeTest(){
        assertThatThrownBy(()-> new InputView().checkNumber(21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유저 입력값 검사")
    @Test
    void readMovingTest(){
        assertThatThrownBy(()-> new InputView().checkText("I"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
