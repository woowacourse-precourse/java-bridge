package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {
    private Player player;
    @BeforeEach
    void init() {
        player = new Player();
    }

    @DisplayName("플레이어가 이동하는지 확인")
    @Test
    void should_Add_playerPosition_When_move() {
        player.move();
        assertThat(player.nowPosition()).isEqualTo(1);
    }

    @DisplayName("총 시도 횟수가 잘 구해지는지 확인")
    @Test
    void should_Get_totalTryNumber_When_tryGame() {
        player.tryGame();
        assertThat(player.getTotalTryNumber()).isEqualTo(1);
    }
}
