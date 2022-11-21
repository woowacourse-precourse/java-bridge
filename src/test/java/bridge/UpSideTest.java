package bridge;

import bridge.data.way.UpSide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UpSideTest {

    @DisplayName("정답 시 다리 윗부분을 제대로 생성하는 지 확인한다.")
    @Test
    void UpSide_생성_테스트() {
        UpSide upSide = new UpSide();
        upSide.upSideArr = Arrays.asList("O", " ", "O");
        upSide.makeUpSide();
        assertEquals(upSide.getUpSide(), "[ O |   | O ]");
    }
}