package bridge.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;


class DirectionTest {
    @DisplayName("명령어에 따라 올바른 Direction을 리턴하는지 확인")
    @Test
    void getDirectionByCommand() {
        assertThat(Direction.getDirection("U")).isEqualTo(Direction.UP);
        assertThat(Direction.getDirection("D")).isEqualTo(Direction.DOWN);
    }

    @DisplayName("숫자 값에 따라 올바른 Direction을 리턴하는지 확인")
    @Test
    void getDirectionByValue() {
        assertThat(Direction.getDirection(1)).isEqualTo(Direction.UP);
        assertThat(Direction.getDirection(0)).isEqualTo(Direction.DOWN);
    }
}