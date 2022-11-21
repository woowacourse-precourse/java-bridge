package bridge.model;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {
    MockedStatic<Randoms> randomsMockedStatic;

    private BridgeGame bridgeGame;

    @BeforeEach
    void beforeAll() {
        randomsMockedStatic = Mockito.mockStatic(Randoms.class);
        Mockito.when(Randoms.pickNumberInRange(0,1)).thenReturn(1,0,1);

        bridgeGame = new BridgeGame();
    }

    @AfterEach
    void afterEach() {
        randomsMockedStatic.close();
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
    void newBridgeTest() throws Exception {
        bridgeGame.newBridge(3);
        Field bridgeField = BridgeGame.class.getDeclaredField("bridge");
        bridgeField.setAccessible(true);
        Bridge bridge = (Bridge) bridgeField.get(bridgeGame);

        List<Plate> playerPath = List.of(Plate.UP_PLATE, Plate.DOWN_PLATE, Plate.UP_PLATE);

        assertThat(bridge.sameAs(playerPath)).isTrue();
    }
}
