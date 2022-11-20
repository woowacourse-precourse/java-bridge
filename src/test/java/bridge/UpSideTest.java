package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UpSideTest {

    @DisplayName("정답 시 다리 윗부분을 제대로 생성하는 지 확인한다.")
    @Test
    void UpSide_생성_테스트() {
        Application.movingInputs = Arrays.asList("U", "D", "U");
        UpSide upSide = new UpSide();
        assertEquals(upSide.getUpSide(), "[ O |   | O ]");
    }

    @DisplayName("정답이 아닐 시 다리 윗부분을 제대로 생성하는 지 확인한다.")
    @Test
    void UpSide_생성_테스트2() {
        Application.movingInputs = Arrays.asList("U", "D", "X");
        UpSide upSide = new UpSide();
        assertEquals(upSide.getUpSide(), "[ O |   | X ]");
    }
}