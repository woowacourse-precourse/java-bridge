package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    
    @DisplayName("다리의 길이로 지정이 가능한 숫자인지 확인하는 메서드")
    @Test
    void isBridgeSizeNumber(){
        InputView inputView = new InputView();
        assertTrue(inputView.isBridgeSizeNumber("20"));
    }

}