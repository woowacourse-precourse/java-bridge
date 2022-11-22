package bridge.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapTest {

    Map map;

    @BeforeEach
    @DisplayName("user 객체 생성")
    void userInit() {
        map = new Map();
    }

    @Test
    @DisplayName("Map이 방향의 수 만큼 생성되 있는지 확인")
    void checkMapSize() {
        Assertions.assertEquals(map.getMap().size(), BridgeDirection.getBridgeDirectionSize());
    }

    @Test
    @DisplayName("들어온 결과와 방향에 맞게 Map이 그려졌는지 확인")
    void checkMapDraw() {
        List<String> down = List.of("O", " ");
        List<String> up = List.of(" ", "O");
        List<List<String>> inputMap = new ArrayList<>(List.of(down, up));
        map.drawMap(0, true);
        map.drawMap(1, true);
        Assertions.assertEquals(map.getMap(), inputMap);
    }

    @Test
    @DisplayName("재시작으로 Map 초기화 확인")
    void checkMapReset() {
        map.retry();
        List<List<String>> resetMap = map.getMap().stream()
                .filter(layer -> layer.size() == 0)
                .collect(Collectors.toList());
        Assertions.assertEquals(resetMap.size(), BridgeDirection.getBridgeDirectionSize());
    }
}
