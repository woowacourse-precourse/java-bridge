package bridge.domain.player;


import org.assertj.core.api.Assertions;
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
        Assertions.assertThat(afterMoveLocation).isEqualTo(beforeMoveLocation+1);

    }

}
