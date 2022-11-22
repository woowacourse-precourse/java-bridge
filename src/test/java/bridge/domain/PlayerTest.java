package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class PlayerTest {

    Player player = new Player();

    @DisplayName("Bridge 객체의 값과 Player 객체의 이동값이 같을 경우 'True'가 반환")
    @Test
    void matchPlayerAndBridgeTrue() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        player.updateMovement(Movement.UP);
        player.updateMovement(Movement.DOWN);
        player.updateMovement(Movement.UP);

        boolean matchingResult = player.matchPlayerAndBridge(bridge);

        assertThat(matchingResult).isTrue();
    }

    @DisplayName("Bridge 객체의 값과 Player 객체의 이동값이 다를 경우 'False'가 반환")
    @Test
    void matchPlayerAndBridgeFalse() {
        Bridge bridge = new Bridge(List.of("D", "D", "U"));
        player.updateMovement(Movement.UP);
        player.updateMovement(Movement.DOWN);
        player.updateMovement(Movement.UP);

        boolean matchingResult = player.matchPlayerAndBridge(bridge);

        assertThat(matchingResult).isFalse();
    }

    @DisplayName("Player 객체에 거리와 경로값이 정상적으로 업데이트 된다")
    @Test
    void updateMovement() {

        Movement input = Movement.UP;

        player.updateMovement(input);

        assertThat(player.getDistance()).isEqualTo(1);
        assertThat(player.getRoute()).isEqualTo(List.of(Movement.UP));
    }

    @DisplayName("Player 객체 업데이트 이후 정상적으로 초기화 된다")
    @Test
    void resetPlayer() {
        Movement input = Movement.UP;

        player.updateMovement(input);
        player.resetPlayer();

        assertThat(player.getDistance()).isEqualTo(0);
        assertThat(player.getRoute()).isEqualTo(new ArrayList<>());
    }
}