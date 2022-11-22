package bridge.domain.map;

import bridge.domain.bridge.CrossStatus;
import bridge.domain.direction.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static bridge.domain.bridge.CrossStatus.FAIL;
import static bridge.domain.bridge.CrossStatus.SUCCESS;
import static bridge.domain.direction.Direction.DOWN;
import static bridge.domain.direction.Direction.UP;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeMapTest {

    private static Stream<Arguments> provideDirectionAndStatusAndMap() {
        List<Direction> direction1 = List.of(UP);
        List<CrossStatus> status1 = List.of(SUCCESS);
        BridgeMap bridgeMap1 = new BridgeMap();
        bridgeMap1.addPath(UP, SUCCESS);

        List<Direction> direction2 = List.of(UP, UP);
        List<CrossStatus> status2 = List.of(SUCCESS, FAIL);
        BridgeMap bridgeMap2 = new BridgeMap();
        bridgeMap2.addPath(UP, SUCCESS);
        bridgeMap2.addPath(UP, FAIL);

        List<Direction> direction3 = List.of(UP, DOWN);
        List<CrossStatus> status3 = List.of(SUCCESS, SUCCESS);
        BridgeMap bridgeMap3 = new BridgeMap();
        bridgeMap3.addPath(UP, SUCCESS);
        bridgeMap3.addPath(DOWN, SUCCESS);

        List<Direction> direction4 = List.of(UP, DOWN, DOWN);
        List<CrossStatus> status4 = List.of(SUCCESS, SUCCESS, SUCCESS);
        BridgeMap bridgeMap4 = new BridgeMap();
        bridgeMap4.addPath(UP, SUCCESS);
        bridgeMap4.addPath(DOWN, SUCCESS);
        bridgeMap4.addPath(DOWN, SUCCESS);

        return Stream.of(
                Arguments.of(direction1, status1, bridgeMap1),
                Arguments.of(direction2, status2, bridgeMap2),
                Arguments.of(direction3, status3, bridgeMap3),
                Arguments.of(direction4, status4, bridgeMap4)
        );
    }

    @ParameterizedTest(name = "[{index}]주어는 경로에 맞게 지도를 생성할 수 있다.")
    @MethodSource("provideDirectionAndStatusAndMap")
    void makeMapTest(
            final List<Direction> directions,
            final List<CrossStatus> statuses,
            final BridgeMap map
    ) {
        // given
        BridgeMap currentMap = new BridgeMap();
        for (int i = 0; i < directions.size(); i++) {
            currentMap.addPath(directions.get(i), statuses.get(i));
        }

        // when, then
        for (int i = 0; i < currentMap.getBottomLine().size(); i++) {
            assertThat(currentMap.getBottomLine().get(i)).isEqualTo(map.getBottomLine().get(i));
            assertThat(currentMap.getTopLine().get(i)).isEqualTo(map.getTopLine().get(i));
        }
    }

    @DisplayName("clear 시 지금까지 그린 지도를 모두 비운다.")
    @Test
    void initTest() {
        // given
        BridgeMap map = new BridgeMap();
        map.addPath(UP, SUCCESS);
        map.addPath(DOWN, SUCCESS);

        // when
        map.init();

        // then
        assertThat(map.getTopLine().size())
                .isEqualTo(2); // Start Symbol, End Symbol 포함
        assertThat(map.getBottomLine().size())
                .isEqualTo(2);
    }
}