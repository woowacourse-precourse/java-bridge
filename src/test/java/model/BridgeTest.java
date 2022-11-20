package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import model.enums.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BridgeTest {
    private final String UP = "U";
    private final String DOWN = "D";

    Bridge bridge = new Bridge(List.of(UP,DOWN,UP));


    @Nested
    @DisplayName("movable 메서드는 이동할 행과 열을 입력받아")
    class describe_movable {

        @Test
        @DisplayName("이동 가능 여부를 반환한다.")
        void returnGameStatus(){
            assertThat(bridge.movable(0,UP)).isEqualTo(true);
            assertThat(bridge.movable(1,UP)).isEqualTo(false);
            assertThat(bridge.movable(2,UP)).isEqualTo(true);

            assertThat(bridge.movable(0,DOWN)).isEqualTo(false);
            assertThat(bridge.movable(1,DOWN)).isEqualTo(true);
            assertThat(bridge.movable(2,DOWN)).isEqualTo(false);
        }
    }
}
