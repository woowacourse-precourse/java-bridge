package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MovementTest {

    @DisplayName("방향을 나타내는 문자열 객체를 넣으면 Movement 객체가 반환된다")
    @Test
    void getMovement() {
        String input = "D";

        Movement movement = Movement.getMovement(input);

        assertThat(movement).isEqualTo(Movement.DOWN);
    }




}