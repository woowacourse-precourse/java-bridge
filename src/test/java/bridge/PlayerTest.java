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

    @Test
    public void movable_다리_시작점에서_움직일_수_있는지() throws Exception {
        //given
        Player player = new Player(new Bridge(List.of("U", "U")));
        assertThat(player.movable()).isTrue();
    }

    @Test
    public void move_다리_시작점에서_움직이고_현재_위치_반환() throws Exception {
        //given
        Player player = new Player(new Bridge(List.of("U", "U")));

        //when
        int playerLocationAfterMove = player.move("U");

        //then
        assertThat(playerLocationAfterMove).isEqualTo(player.getLocation());
    }
}