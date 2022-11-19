package bridge.domain;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @DisplayName("player 객체에 거리와 경로값이 정상적으로 업데이트 된다")
    @Test
    void updateMovement() {
        Player player = new Player();
        Movement input = Movement.UP;

        player.updateMovement(input);

        assertThat(player.getDistance()).isEqualTo(1);
        assertThat(player.getRoute()).isEqualTo(List.of(Movement.UP));
    }





}