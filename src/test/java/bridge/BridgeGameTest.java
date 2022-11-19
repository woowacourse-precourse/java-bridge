package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.Const.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    @Test
    @DisplayName("사용자를 움직이는 기능")
    void movePlayer() {
        // given
        GameHost gameHost = new GameHost();
        BridgeGame bridgeGame = new BridgeGame();
        gameHost.setBridge(List.of("U", "D", "D", "U"));

        // when
        bridgeGame.move(gameHost, UP);

        // then
        assertThat(gameHost.getPlayerIndex()).isEqualTo(0);
        assertThat(gameHost.getPlayerAlive()).isTrue();
    }
}
