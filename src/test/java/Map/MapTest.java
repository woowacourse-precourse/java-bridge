package Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Model.Map;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;
import java.util.List;

public class MapTest {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    List<String> crossable = bridgeMaker.makeBridge(5);

    @Test
    void mapStartTest() {
        Map map = new Map(crossable);
        map.startMap();
        List<String> valueResult = List.of("[");
        assertEquals(valueResult,map.getMapUpper());
        assertEquals(valueResult,map.getMapLower());
    }

    @Test
    void endMapTest() {
        Map map = new Map(crossable);
        map.endMap();
        List<String> valueResult = List.of("]");
        assertEquals(valueResult,map.getMapUpper());
        assertEquals(valueResult,map.getMapLower());
    }

    @Test
    void makeMapUpperWhenCorrectTest() {
        Map map = new Map(crossable);
        map.makeMapUpper(true);
        List<String> mapUpperResult = List.of(" O ");
        List<String> mapLowerResult = List.of("   ");
        assertEquals(mapUpperResult,map.getMapUpper());
        assertEquals(mapLowerResult,map.getMapLower());
    }

    @Test
    void makeMapUpperWhenIncorrectTest() {
        Map map = new Map(crossable);
        map.makeMapUpper(false);
        List<String> mapUpperResult = List.of(" X ");
        List<String> mapLowerResult = List.of("   ");
        assertEquals(mapUpperResult,map.getMapUpper());
        assertEquals(mapLowerResult,map.getMapLower());
    }

    @Test
    void makeMapLowerWhenCorrectTest() {
        Map map = new Map(crossable);
        map.makeMapLower(true);
        List<String> mapUpperResult = List.of("   ");
        List<String> mapLowerResult = List.of(" O ");
        assertEquals(mapUpperResult,map.getMapUpper());
        assertEquals(mapLowerResult,map.getMapLower());
    }

    @Test
    void makeMapLowerWhenIncorrectTest() {
        Map map = new Map(crossable);
        map.makeMapLower(false);
        List<String> mapUpperResult = List.of("   ");
        List<String> mapLowerResult = List.of(" X ");
        assertEquals(mapUpperResult,map.getMapUpper());
        assertEquals(mapLowerResult,map.getMapLower());
    }

    @Test
    void extendMapTest() {
        Map map = new Map(crossable);
        map.startMap();
        map.extendMap(1);
        List<String> result = List.of("|");
        assertEquals(result,map.getMapUpper());
        assertEquals(result,map.getMapLower());
    }

    @Test
    void checkWhenInputIsDTest() {
        Map map = new Map(crossable);
        boolean result = true;
        assertEquals(result,map.checkWhenInputIsD("D"));
    }

    @Test
    void checkWhenInputIsUTest() {
        Map map = new Map(crossable);
        boolean result = false;
        assertEquals(result,map.checkWhenInputIsU("D"));
    }

    @Test
    void runMapTest() {
        Map map = new Map(crossable);
        boolean result = false;
        assertEquals(result,map.runMap("D","U"));
    }
}
