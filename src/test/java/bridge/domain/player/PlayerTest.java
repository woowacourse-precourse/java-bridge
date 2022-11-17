package bridge.domain.player;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("플레이어의 위치를 한칸 이동시킨다.")
    void movePlayerLocationTest() {
        //given
        Player player = new Player();
        int beforeMoveLocation = player.getPlayerLocation();

        //when
        player.movePlayerLocation();

        //then
        int afterMoveLocation = player.getPlayerLocation();
        assertThat(afterMoveLocation).isEqualTo(beforeMoveLocation + 1);

    }

    @Test
    @DisplayName("플레이어의 위치를 초기화 시킨다.")
    void resetPlayerLocationTest() {
        //given
        Player player = new Player();
        int beforeMoveLocation = player.getPlayerLocation();
        player.movePlayerLocation();
        player.movePlayerLocation();

        //when
        player.resetPlayerLocation();

        //then
        int afterResetLocation = player.getPlayerLocation();
        assertThat(afterResetLocation).isEqualTo(beforeMoveLocation);
    }

}
