package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class MovementTest {

    @DisplayName("방향을 나타내는 문자열 객체를 넣으면 해당 속성을 가진 Movement 객체가 반환된다")
    @Test
    void getMovement() {
        String input = "D";

        Movement movement = Movement.getMovementByDirection(input);

        assertThat(movement).isEqualTo(Movement.DOWN);
    }




}