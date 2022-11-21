package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputViewTest {

    InputView inputView = new InputView();

    @Test
    @DisplayName("이동할 칸을 입력 받는 메서드")
    void readMoving(){
        String input = "u".toUpperCase();
        inputView.checkMovingNull(input);
        inputView.checkUpAndDown(input);
        assertEquals("U",input);
    }


}