package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame();
    }

    @DisplayName("BridgeGame 생성 테스트")
    @Test
    void createBridgeGame() throws Exception{
        Field playerPathField = BridgeGame.class.getDeclaredField("playerPath");
        playerPathField.setAccessible(true);
        PlayerPath playerPath = (PlayerPath) playerPathField.get(bridgeGame);
        Field tryCountField = BridgeGame.class.getDeclaredField("tryCount");
        tryCountField.setAccessible(true);
        TryCount tryCount = (TryCount) tryCountField.get(bridgeGame);

        assertThat(playerPath).isNotNull();
        assertThat(tryCount).isNotNull();
    }

    @DisplayName("새로운 다리를 만드는 테스트")
    @Test
    void newBridgeTest() {

    }
}
