package bridge.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapTest {
    private static Map map = new Map();
    private static StringBuilder sb1 = new StringBuilder();
    private static StringBuilder sb2 = new StringBuilder();

    @DisplayName("맵이 제대로 그려지는지 확인")
    @ParameterizedTest
    @CsvSource({"ROUND_CLEAR, BLANK", "BLANK,ROUND_FAIL"})
    void drawTest(RoundTrace up, RoundTrace down) {
       List<String> roundTrace = Arrays.asList(down.getFootPrint(), up.getFootPrint());

       map.draw(roundTrace);
       sb1.append(up.getFootPrint());
       sb2.append(down.getFootPrint());

       assertEquals(map.getMap1(), sb1.substring(0, sb1.length()-1));
       assertEquals(map.getMap2(), sb2.substring(0, sb2.length()-1));
    }
}