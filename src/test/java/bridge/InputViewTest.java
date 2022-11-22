package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    
    @DisplayName("다리의 길이로 지정이 가능한 숫자인지 검사하는 메서드")
    @Test
    void isBridgeSizeNumber(){
        Valid valid = new Valid();
        assertTrue(valid.isBridgeSizeNumber("3"));
    }
    
    @DisplayName("입력 값이 U 또는 D인지 검사하는 메서드")
    @Test
    void isReadMoving(){
        Valid valid = new Valid();
        assertTrue(valid.isReadMoving("U"));
    }

    @DisplayName("입력 값이 R 또는 Q인지 검사하는 메서드")
    @Test
    void isRetry(){
        Valid valid = new Valid();
        assertTrue(valid.isRetry("R"));
    }

}