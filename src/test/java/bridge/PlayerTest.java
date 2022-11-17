package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    @DisplayName("플레이어를 이동한다.")
    void move() {
        Player player = new Player();
        assertThat(player.move()).isEqualTo(1);
        assertThat(player.move()).isEqualTo(2);
    }
}
