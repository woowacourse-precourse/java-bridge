package bridge.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class DirectionTest {
    @DisplayName("명령어에 따라 올바른 Direction을 리턴하는지 확인")
    @Test
    void getDirectionByCommand() {
        assertThat(Direction.getDirection("U")).isEqualTo(Direction.UP);
        assertThat(Direction.getDirection("D")).isEqualTo(Direction.DOWN);
    }
}