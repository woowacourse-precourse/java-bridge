package bridge.model;

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
}
