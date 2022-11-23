package bridge.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeComparatorTest {

    private BridgeComparator bridgeComparator;

    @BeforeEach
    void setUp() {
        bridgeComparator = new BridgeComparator();
    }

    @DisplayName("이동한 곳에 다리가 있으면 O 반환")
    @Test
    void generateBridgeO() {
        //given
        String expectedResult = "O";
        List<String> bridge = new ArrayList<>(List.of("U", "U", "D", "D"));
        int location = 0;
        String moving = "U";

        //when
        String result = bridgeComparator.compareBridge(bridge, moving, 0);

        //then
        assertEquals(expectedResult, result);
    }

    @DisplayName("이동한 곳에 다리가 없으면 X 반환")
    @Test
    void generateBridgeX() {
        //given
        String expectedResult = "X";
        List<String> bridge = new ArrayList<>(List.of("D", "U", "D", "D"));
        int location = 0;
        String moving = "U";

        //when
        String result = bridgeComparator.compareBridge(bridge, moving, 0);

        //then
        assertEquals(expectedResult, result);
    }

    @DisplayName("해당 다리 결과 위치에 X 표시가 있으면 true 반환 테스트")
    @Test
    void generateBridgeMapX() {
        //given
        List<String> bridgeUpMap = new ArrayList<>(List.of("O", "X"));
        List<String> bridgeDownMap = new ArrayList<>(List.of("", ""));
        List<List<String>> bridgeMap = new ArrayList<>(List.of(bridgeUpMap, bridgeDownMap));
        int location = 1;

        //when
        boolean result = bridgeComparator.isExpressionX(1, bridgeMap);

        //then
        assertEquals(true, result);
    }

    @DisplayName("사용자의 위치가 다리 끝에 도달 했는지 체크하는 기능 테스트")
    @Test
    void generateEndPoint() {
        //given
        List<String> bridge = new ArrayList<>(List.of("O", "O", "X"));
        int location = 2;

        //when
        boolean result = bridgeComparator.isEndPoint(bridge, location);

        //then
        assertEquals(true, result);
    }
}
