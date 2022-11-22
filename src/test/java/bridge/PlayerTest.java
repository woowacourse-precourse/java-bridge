package bridge;

import bridge.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    Player player;

    @BeforeEach()
    void setUp() {
        player = new Player();
    }

    @Test
    @DisplayName("플레이어가 게임을 시도할때마다 시도 횟수를 저장한다.")
    void 플레이어가_게임을시도하면_횟수를_저장한다() {
        IntStream.range(0, 10).forEach((idx) -> {
            player.tryGame();
            assertThat(player.toString()).isEqualTo(String.valueOf(idx + 1));
        });
    }
}
