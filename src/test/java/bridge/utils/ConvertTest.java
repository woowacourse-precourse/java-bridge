package bridge.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ConvertTest {

    @DisplayName("0,1로 이루어진 U,D로 바꿔주는 테스트")
    @Test
    void convertToUpAndDownTest() {
        List<Integer> bridge = List.of(0, 1, 1, 0);
        List<String> list = Convert.toUpAndDownBridge(bridge);

        assertEquals(List.of("D", "U", "U", "D"), list);
        assertNotEquals(List.of("D", "D", "D", "D"), list);
    }
}