package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovementTest {

    @DisplayName("saveMoving메서드는 움직임을 저장하고 moveCount를 1증가시킨다.")
    @Test
    void saveMoving() {
        Movement movement = new Movement();
        String input = "U";
        movement.saveMoving(new Moving(input));
        Assertions.assertThat(movement.getMoveCount()).isEqualTo(1);
        Assertions.assertThat(movement.getMoving()).isEqualTo(input);
    }
}