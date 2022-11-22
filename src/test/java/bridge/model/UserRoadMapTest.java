package bridge.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constant.message.GameErrorMessage;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserRoadMapTest {
    private UserRoadMap userRoadMap;

    @BeforeEach
    void setUserRoadMap() {
        userRoadMap = new UserRoadMap(List.of("U"));
    }

    @DisplayName("위치에 해당하는 칸이 없을 때 예외를 발생한다.")
    @Test
    void testNotGetRoad() {
        int roadPosition = 1;
        assertThatThrownBy(() -> userRoadMap.getRoad(roadPosition)).hasMessage(
                GameErrorMessage.NO_SUCH_ROAD_POSITION.getMessage()).isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("이동했던 모든 칸들을 지운다.")
    @Test
    void testClearRoad(){
        assertSimpleTest(() -> {
           userRoadMap.clear();
           assertThat(userRoadMap.getSize())
                   .isEqualTo(0);
        });
    }

    @DisplayName("이동할 칸에 대해 생성 및 저장한다.")
    @Test
    void testAddRoad(){
        assertSimpleTest(() -> {
            int originSize = userRoadMap.getSize();
            String direction = "U";
            userRoadMap.addRoad(direction);
            assertThat(userRoadMap.getSize())
                    .isEqualTo(originSize + 1);
        });
    }
}
