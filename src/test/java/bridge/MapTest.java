package bridge;

import enumCollections.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    @DisplayName("맵 생성 테스트")
    @Test
    void 윗칸_이동_테스트() {
        Map map = new Map();
        map.addUpper("O");
        assertThat(map.getMaps())
                .toString()
                .contains("[O]");
    }

    @DisplayName("맵 생성 테스트")
    @Test
    void 아래칸_이동_테스트() {
        Map map = new Map();
        map.addBelow("O");
        assertThat(map.getMaps())
                .toString()
                .contains("[O]");
    }
}