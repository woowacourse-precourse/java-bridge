package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayerTest {
    @Test
    public void getLocation_다리_위_자신의_블록_인덱스_계산() throws Exception {
        Player player = new Player(new Bridge(List.of("U", "U")));

        assertThat(player.getLocation()).isEqualTo(0);
    }
}