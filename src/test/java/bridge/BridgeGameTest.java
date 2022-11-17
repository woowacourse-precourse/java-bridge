package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    void 이동_로그_테스트(){
        BridgeGame bridgeGame = new BridgeGame();

        bridgeGame.move("U", "U");
        bridgeGame.move("U", "U");
        bridgeGame.move("U", "U");
        bridgeGame.move("U", "D");
        char[][] answer = {{'O', 'O', 'O', ' '}, {' ', ' ', ' ', 'X'}};
        assertThat(bridgeGame.log).isEqualTo(answer);

    }
}