package bridge.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("Player가 한칸 이동할 수 있다.")
    void addMovingSpaces_Success() {
        // Given
        Player player = new Player();

        // When
        player.addMovingSpaces("U");

        // Then
        assertThat(player.getMovingSpacesSize()).isEqualTo(1);
    }

    @Test
    @DisplayName("Player가 처음부터 다시 시작할 수 있다.")
    void resetPlayer_Success() {
        // Given
        Player player = new Player();
        player.addMovingSpaces("U");
        player.addMovingSpaces("D");
        player.addMovingSpaces("U");

        // When
        player.resetPlayer();

        // Then
        assertThat(player.getMovingSpacesSize()).isEqualTo(0);
    }

    @Test
    @DisplayName("Player의 시도 횟수가 하나 증가할 수 있다.")
    void addAttempt_Success() {
        // Given
        Player player = new Player();

        // When
        player.addAttempt();

        // Then
        assertThat(player.getAttempt()).isEqualTo(2);
    }

    @Test
    @DisplayName("Player의 다리를 건너는 것에 실패할 수 있다.")
    void playerIsFail_Success() {
        // Given
        Player player = new Player();

        // When
        player.playerIsFail();

        // Then
        assertThat(player.isPossible()).isFalse();
    }
}