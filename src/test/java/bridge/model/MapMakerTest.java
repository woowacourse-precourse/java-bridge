package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("지도 생성 테스트")
class MapMakerTest {
    private final MapMaker mapMaker = new MapMaker();

    @Test
    @DisplayName("지도가 제대로 반환되면 통과")
    void buildMap_CompareBridgeWithMovement_ReturnMap() {
        Bridge bridge = new Bridge(List.of(Direction.U, Direction.D, Direction.D));
        Stack<Direction> movement = new Stack<>();
        movement.addAll(Arrays.asList(Direction.U, Direction.D, Direction.U));
        assertThat(mapMaker.buildMap(movement, bridge))
                .isEqualTo("[ O |   | X ]\n[   | O |   ]");
    }
}