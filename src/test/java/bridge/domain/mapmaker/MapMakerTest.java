package bridge.domain.mapmaker;

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

class MapMakerTest {

    private static Stream<Arguments> provideDirectionAndStatusAndMap() {
        List<Direction> direction1 = List.of(UP);
        List<CrossStatus> status1 = List.of(SUCCESS);

        List<Direction> direction2 = List.of(UP, UP);
        List<CrossStatus> status2 = List.of(SUCCESS, FAIL);

        List<Direction> direction3 = List.of(UP, DOWN);
        List<CrossStatus> status3 = List.of(SUCCESS, SUCCESS);

        List<Direction> direction4 = List.of(UP, DOWN, DOWN);
        List<CrossStatus> status4 = List.of(SUCCESS, SUCCESS, SUCCESS);

        return Stream.of(
                Arguments.of(direction1, status1, "[ O ]\n[   ]"),
                Arguments.of(direction2, status2, "[ O | X ]\n[   |   ]"),
                Arguments.of(direction3, status3, "[ O |   ]\n[   | O ]"),
                Arguments.of(direction4, status4, "[ O |   |   ]\n[   | O | O ]")
                );
    }

    @ParameterizedTest(name = "[{index}]주어는 경로에 맞게 지도를 생성할 수 있다.")
    @MethodSource("provideDirectionAndStatusAndMap")
    void makeMapTest(
            final List<Direction> directions,
            final List<CrossStatus> statuses,
            final String map
    ) {
        // given
        MapMaker mapMaker = new MapMaker();
        for (int i = 0; i < directions.size(); i++) {
            mapMaker.addPath(directions.get(i), statuses.get(i));
        }

        // when
        String currentMap = mapMaker.getCurrentMap();

        // then
        assertThat(currentMap)
                .isEqualTo(map);
    }

    @DisplayName("clear 시 지금까지 그린 지도를 모두 비운다.")
    @Test
    void initTest() {
        // given
        MapMaker maker = new MapMaker();
        maker.addPath(UP, SUCCESS);
        maker.addPath(DOWN, SUCCESS);

        // when
        maker.init();

        // then
        assertThat(maker.getCurrentMap())
                .isEqualTo("[]\n[]");

    }
}