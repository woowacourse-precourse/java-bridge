package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    @DisplayName("플레이어를 이동한다.")
    void move() {
        Player player = new Player();
        player.move("U");
        assertThat(player.getPosition()).isEqualTo(1);
        assertThat(player.getDirection()).isEqualTo("U");

        player.move("D");
        assertThat(player.getDirection()).isEqualTo("D");
        assertThat(player.getPosition()).isEqualTo(2);
    }
}
