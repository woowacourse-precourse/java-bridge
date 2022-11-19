package bridge;

import bridge.model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlayerTest {

    List<String> bridge = List.of("D","D","D","U","U","D");

    @Test
    void moveTest()
    {
        Player player = new Player(bridge);
        Assertions.assertFalse(player.isFinish());
        List<String> moves = List.of("D","D","D","U","U","D");
        for (String nextMove : moves)
        {
            Assertions.assertTrue(player.move(nextMove));
        }
        Assertions.assertTrue(player.isFinish());
    }

    @Test
    void moveFailTest()
    {
        Player player = new Player(bridge);
        Assertions.assertFalse(player.isFinish());
        List<String> moves = List.of("U","U","U","U","U","U","U","U","U");
        for (String nextMove : moves)
        {
            Assertions.assertFalse(player.move(nextMove));
        }
        Assertions.assertFalse(player.isFinish());
    }


}
