package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DrawMapTest {

    @DisplayName("입력값에 맞는 결과를 String으로 반환한다.")
    @Test
    void returnMapToPrintTest() {
        DrawMap drawMap = new DrawMap();
        List<String> bridge = List.of("U", "U", "U");
        List<String> playerInput = List.of("U", "U", "U");
        assertEquals(drawMap.returnMapToPrint(bridge, playerInput), "[ O | O | O ]\n[   |   |   ]");
    }
}
