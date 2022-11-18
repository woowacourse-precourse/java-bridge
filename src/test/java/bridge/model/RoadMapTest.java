package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RoadMapTest {
    private static RoadMap roadMap;

    @BeforeAll
    static void setRoadMap(){
        roadMap = new RoadMap(List.of("U")) {
            @Override
            protected void validate(List<String> directions) {
            }
        };
    }

    @DisplayName("현재 가지고 있는 칸의 개수를 반환한다.")
    @Test
    void testGetSize(){
        assertThat(roadMap.getSize())
                .isEqualTo(1);
    }

    @DisplayName("칸 위치와 제공된 방향이 같다면 true 값을 반환한다.")
    @Test
    void testMatchPositionWithDirection(){
        int roadPosition = 0;
        String direction = "U";
        assertThat(roadMap.matchPositionWithDirection(roadPosition, direction))
                .isTrue();
    }

    @DisplayName("위치하지 않은 칸이거나 제공된 방향이 다르다면 false 값을 반환한다.")
    @ParameterizedTest
    @CsvSource({"1,U", "0,D"})
    void testNotMatchPositionWithDirection(int roadPosition, String direction){
        assertThat(roadMap.matchPositionWithDirection(roadPosition, direction))
                .isFalse();
    }

    @DisplayName("칸 위치와 다른 칸이 같다면 true 값을 반환한다.")
    @Test
    void testMatchPositionWithRoad(){
        int roadPosition = 0;
        Road road = new Road("U");
        assertThat(roadMap.matchPositionWithRoad(roadPosition, road))
                .isTrue();
    }

    @DisplayName("위치하지 않은 칸이거나 제공된 칸이 다르다면 false 값을 반환한다.")
    @ParameterizedTest
    @CsvSource({"1,U", "0,D"})
    void testNotMatchPositionWithRoad(int roadPosition, String direction){
        Road road = new Road(direction);
        assertThat(roadMap.matchPositionWithRoad(roadPosition, road))
                .isFalse();
    }
}
