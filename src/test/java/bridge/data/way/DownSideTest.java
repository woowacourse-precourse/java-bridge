package bridge.data.way;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DownSideTest {

    @DisplayName("다리 아랫부분을 제대로 생성하는 지 확인한다.")
    @Test
    void DownSide_생성_테스트() {
        DownSide downSide = new DownSide();
        downSide.downSideArr = Arrays.asList("O", " ", "O");
        downSide.makeDownSide();
        assertEquals(downSide.getDownSide(), "[ O |   | O ]");
    }
}