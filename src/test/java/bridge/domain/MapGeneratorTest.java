package bridge.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MapGeneratorTest {

    @DisplayName("이동 기록에 따라 다리 상태를 출력한다.")
    @Test
    void generateMap() {
        // given
        List<Record> history = List.of(
                new Record(BridgeCell.UP, true),
                new Record(BridgeCell.UP, true),
                new Record(BridgeCell.DOWN, false)
        );

        // when, then
        assertThat(MapGenerator.generateMap(history)).isEqualTo(
          "[ O | O |   ]\n" + "[   |   | X ]"
        );
    }
}
