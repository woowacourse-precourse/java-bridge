package bridge.domain;

import static bridge.domain.MovingMapState.FAIL;
import static bridge.domain.MovingMapState.NOT_GOING;
import static bridge.domain.MovingMapState.SUCCESS;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MovingMapTest {

    @DisplayName("움직임 추가")
    @Nested
    class AddMovingTest {

        @DisplayName("성공적으로 움직일 때")
        @Test
        void success() {
            MovingMap movingMap = new MovingMap();

            movingMap.addMoving("U", true);

            List<MovingMapState> upStates = movingMap.getStateList("U");
            List<MovingMapState> downStates = movingMap.getStateList("D");
            Assertions.assertThat(upStates).isEqualTo(List.of(SUCCESS));
            Assertions.assertThat(downStates).isEqualTo(List.of(NOT_GOING));
        }

        @DisplayName("실패로 움직일 때")
        @Test
        void fail() {
            MovingMap movingMap = new MovingMap();

            movingMap.addMoving("U", false);

            List<MovingMapState> upStates = movingMap.getStateList("U");
            List<MovingMapState> downStates = movingMap.getStateList("D");
            Assertions.assertThat(upStates).isEqualTo(List.of(FAIL));
            Assertions.assertThat(downStates).isEqualTo(List.of(NOT_GOING));
        }
    }

    @DisplayName("비우기")
    @Nested
    class ClearTest {

        @DisplayName("비웠을 때 안에 아무것도 없어야 한다.")
        @Test
        void clear() {
            MovingMap movingMap = new MovingMap();
            movingMap.addMoving("U", true);

            movingMap.clear();

            List<MovingMapState> upStates = movingMap.getStateList("U");
            List<MovingMapState> downStates = movingMap.getStateList("D");
            Assertions.assertThat(upStates).isEqualTo(List.of());
            Assertions.assertThat(downStates).isEqualTo(List.of());
        }
    }
}