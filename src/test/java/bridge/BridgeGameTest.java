package bridge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @DisplayName("이동 테스트")
    @Test
    public void move(){
        Bridge bridge = new Bridge(List.of("D","U","D"));
        BridgeGame game = new BridgeGame(bridge);
        assertSame(Result.SAME, game.move("D"));
        assertSame(Result.WRONG, game.move("D"));
        game.retry();
        game.move("D");
        game.move("U");
        assertSame(Result.CLEAR, game.move("D"));
    }

}