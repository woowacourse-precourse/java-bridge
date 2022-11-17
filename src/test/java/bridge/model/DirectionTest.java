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
        Direction down = Direction.DOWN;

        //then
        assertThat(down.getDirection()).isEqualTo(direction);
    }

    @DisplayName("0은 아래 방향을 생성하는 코드이다.")
    @Test
    void generateCodeDown() {
        //given
        int code = 0;

        //when
        Direction down = Direction.DOWN;

        //then
        assertThat(down.isMatchGenerateCode(code)).isTrue();
    }

    @DisplayName("1은 위 방향을 생성하는 코드이다.")
    @Test
    void generateCodeUp() {
        //given
        int code = 1;

        //when
        Direction up = Direction.UP;

        //then
        assertThat(up.isMatchGenerateCode(code)).isTrue();
    }

}