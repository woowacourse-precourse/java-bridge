package bridge;

import bridge.domain.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    BridgeGame bridgeGame;
    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
    }

    @Test
    void checkGameTest(){
        Game game = new Game();
        game.write("U","O");
        game.forward();
        game.write("U","X");

        boolean check = bridgeGame.checkGame(game, 3);

        assertThat(check).isEqualTo(true);
    }

    @Test
    void matchTest(){
        String match = bridgeGame.match("U", "D");

        assertThat(match).isEqualTo("X");
    }
}