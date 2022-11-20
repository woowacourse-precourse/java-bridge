package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import model.enums.MoveChoice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RetryIntentionTest {

    private static String UP = MoveChoice.UP.moving;
    private static String DOWN = MoveChoice.DOWN.moving;
    private static List<String> moveChoices = List.of(UP, DOWN, UP, UP, UP);
    private static Bridge bridge = new Bridge(moveChoices);

    @Nested
    @DisplayName("movable 메서드는 인덱스와 문자열을 입력받아")
    class describe_getMoving {

        @Test
        @DisplayName("해당 위치로의 이동이 가능한지 여부를 반환한다.")
        void returnMovingTest() {
            assertThat(bridge.movable(0, UP)).isEqualTo(true);
            assertThat(bridge.movable(1, UP)).isEqualTo(false);
            assertThat(bridge.movable(1, DOWN)).isEqualTo(true);
            assertThat(bridge.movable(2, UP)).isEqualTo(true);
        }
    }
}
