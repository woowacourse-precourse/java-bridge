package bridge;

import bridge.domain.player.Player;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

    Player player;

    @Before
    void setUp(){
        player=new Player();
    }

    @DisplayName("moveCommand 예외 테스트")
    @Test
    public void moveCommandExceptionTest(){
        assertThrows(IllegalArgumentException.class,()->{
            player.setInputMoving("Z");
        });
    }

    @DisplayName("playerCommand 예외 테스트")
    @Test
    public void playerCommandExceptionTest(){
        assertThrows(IllegalArgumentException.class,()->{
            player.setPlayerCommand("Z");
        });
    }
}
