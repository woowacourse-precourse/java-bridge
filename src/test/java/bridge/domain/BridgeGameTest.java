package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        Player player = new Player(new ArrayList<>(), 1);
        bridgeGame = new BridgeGame(bridge, player);
    }

    @Test
    void 유저_이동_테스트() {
        String moving = "U";
        bridgeGame.move(moving);

        String lastMovedResult = bridgeGame.getPlayer().getLastMovedResult();
        assertThat(lastMovedResult).isEqualTo("O");
    }
}