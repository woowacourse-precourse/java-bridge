package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgesTest {

    @DisplayName("이동 완려 여부 확인")
    @Test
    void check_is_end() {
        Bridges bridges = new Bridges(3);
        Player player = new Player();
        assertThat(bridges.isEnd(player)).isFalse();
        player.move();
        assertThat(bridges.isEnd(player)).isFalse();
        player.move();
        assertThat(bridges.isEnd(player)).isTrue();
    }
}
