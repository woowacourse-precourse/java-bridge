package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
