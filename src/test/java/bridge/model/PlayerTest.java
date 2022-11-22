package bridge.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    public void playerMoveTest(){
        Player player = new Player();
        player.moveFrontSpace();
        player.moveBackSpace();
        player.moveFrontSpace();
        player.moveFrontSpace();

        assertThat(player.getCurrentLocation()).isEqualTo(2);
    }

    @Test
    public void playerWinOrLoseTest(){
        Player player = new Player();
        player.win();
        assertThat(player.isPlayerWin()).isTrue();
    }
}
