package model.map;

import model.bridge.PositionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static model.bridge.PositionType.D;
import static model.bridge.PositionType.U;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMapsTest {

    BridgeMaps maps;

    @BeforeEach
    void setUp() {
        maps = new BridgeMaps();
        maps.updateMaps(U, true);
        maps.updateMaps(U, true);
        maps.updateMaps(D, true);
        maps.updateMaps(D, false);
    }

    @DisplayName("현재까지 이동한 결과를 맵에 저장")
    @Test
    void getMaps() {
        Map<PositionType, List<String>> map = maps.getMaps();
        List<String> upMap = map.get(U);
        List<String> downMap = map.get(D);

        assertThat(upMap).containsExactly("O", "O", " ", " ");
        assertThat(downMap).containsExactly(" ", " ", "O", "X");
    }

    @DisplayName("현재까지 이동한 결과를 초기화")
    @Test
    void reset() {
        maps.reset();

        Map<PositionType, List<String>> map = maps.getMaps();
        List<String> upMap = map.get(U);
        List<String> downMap = map.get(D);

        assertThat(upMap).hasSize(0);
        assertThat(downMap).hasSize(0);
    }
}