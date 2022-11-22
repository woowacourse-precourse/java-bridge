package bridge;

import bridge.domain.Player;
import org.junit.jupiter.api.BeforeEach;

public class PlayerTest {
    Player player;

    @BeforeEach()
    void setUp() {
        player = new Player();
    }

}
