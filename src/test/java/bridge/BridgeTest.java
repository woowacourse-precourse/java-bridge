package bridge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @DisplayName("다음 칸을 전달받아 정답과 비교 후 boolean 반환")
    @Test
    public void isCorrectDirection(){
        Bridge bridge = new Bridge(List.of("U", "D", "U", "U"));
        assertFalse(bridge.isCorrect(List.of("D")));
        assertTrue(bridge.isCorrect(List.of("U")));
    }

}