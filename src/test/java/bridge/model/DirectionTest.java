package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

    @DisplayName("U는 위 방향을 의미한다.")
    @Test
    void directionUp() {
        //given
        String direction = "U";

        //when
        Direction up = Direction.UP;

        //then
        assertThat(up.getDirection()).isEqualTo(direction);
    }

    @DisplayName("D는 아래 방향을 의미한다.")
    @Test
    void directionDown() {
        //given
        String direction = "D";

        //when
        Direction up = Direction.DOWN;

        //then
        assertThat(up.getDirection()).isEqualTo(direction);
    }

}