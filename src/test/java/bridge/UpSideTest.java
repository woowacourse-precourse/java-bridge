package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UpSideTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void UpSide_생성_테스트() {
        List<String> bridge = Arrays.asList("U", "D", "U");
        UpSide upSide = new UpSide(bridge);
        assertEquals(upSide.getUpSide(),"[ O |   | O ]");
    }
}