package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @Test
    void 맵_초기화_테스트() {
        Map map = new Map();
        String moving = "U";
        String check = "O";
        map.makeMap(moving, check);
        assertThat(map.getUpMap()).isEqualTo("[ O ]");
        assertThat(map.getDownMap()).isEqualTo("[   ]");
    }

    @Test
    void 맵_추가_테스트() {
        Map map = new Map();
        String moving = "U";
        String check = "O";
        map.makeMap(moving, check);
        String moving2 = "D";
        String check2 = "X";
        map.makeMap(moving2, check2);
        assertThat(map.getUpMap()).isEqualTo("[ O |   ]");
        assertThat(map.getDownMap()).isEqualTo("[   | X ]");
    }

    @Test
    void 맵_리셋_테스트() {
        Map map = new Map();
        String moving = "U";
        String check = "X";
        map.makeMap(moving, check);
        map.resetMap();
        assertThat(map.getUpMap()).isEqualTo("[  ]");
        assertThat(map.getDownMap()).isEqualTo("[  ]");
    }
}