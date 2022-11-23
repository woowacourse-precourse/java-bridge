package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovementTest {

    @DisplayName("saveMoving메서드는 움직임을 저장하고 moveCount를 1증가시킨다.")
    @Test
    void saveMoving() {
        Movement movement = new Movement();
        String input = "U";
        movement.saveMoving(new Moving(input));
        assertThat(movement.getMoveCount()).isEqualTo(1);
        assertThat(movement.getMoving()).isEqualTo(input);
    }
}