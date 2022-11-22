package model.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static model.bridge.PositionType.D;
import static model.bridge.PositionType.U;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMapTest {

    BridgeMap map;

    @BeforeEach
    void setUp() {
        map = new BridgeMap();
        map.updateMap(true);
        map.updateMap(null);
        map.updateMap(null);
        map.updateMap(true);
        map.updateMap(false);
    }

    @DisplayName("현재까지 이동한 결과를 맵에 저장")
    @Test
    void updateMap() {
        assertThat(map.getMap()).containsExactly("O", " ", " ", "O", "X");
    }
}