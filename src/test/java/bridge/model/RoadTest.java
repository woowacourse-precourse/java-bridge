package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constant.message.GameErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RoadTest {
    @DisplayName("존재하지 않은 이동 명령어일 때 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"u", "Q", " ", ""})
    void testNotValidDirection(String direction) {
        assertThatThrownBy(() -> new Road(direction)).hasMessage(GameErrorMessage.NO_SUCH_DIRECTION.getMessage())
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("주어진 방향과 일치하다면 true 값을 반환한다.")
    @Test
    void testMatchDirection(){
        Road road = new Road("U");
        assertThat(road.matchDirection("U"))
                .isTrue();
    }

    @DisplayName("주어진 방향과 일치하지 않다면 false 값을 반환한다.")
    @Test
    void testNotMatchDirection(){
        Road road = new Road("U");
        assertThat(road.matchDirection("D"))
                .isFalse();
    }

    @DisplayName("현재 칸과 주어진 칸이 일치하다면 true 값을 반환한다.")
    @Test
    void testMatchRoad(){
        Road road = new Road("U");
        Road other = new Road("U");

        assertThat(road.matchRoad(other))
                .isTrue();
    }

    @DisplayName("현재 칸과 주어진 칸이 일치하지 않다면 false 값을 반환한다.")
    @Test
    void testNotMatchRoad(){
        Road road = new Road("U");
        Road other = new Road("D");

        assertThat(road.matchRoad(other))
                .isFalse();
    }
}
