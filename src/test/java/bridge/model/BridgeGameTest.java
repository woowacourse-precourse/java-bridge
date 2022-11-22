package bridge.model;

import bridge.util.Rules;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    private MockedStatic<Randoms> randomsMockedStatic;

    private BridgeGame bridgeGame;
    PlayerPath playerPath;
    TryCount tryCount;

    @BeforeEach
    void beforeAll() throws Exception {
        randomsMockedStatic = Mockito.mockStatic(Randoms.class);
        Mockito.when(Randoms.pickNumberInRange(0, 1)).thenReturn(1, 0, 1);

        bridgeGame = new BridgeGame();
        Field playerPathField = BridgeGame.class.getDeclaredField("playerPath");
        playerPathField.setAccessible(true);
        playerPath = (PlayerPath) playerPathField.get(bridgeGame);
        Field tryCountField = BridgeGame.class.getDeclaredField("tryCount");
        tryCountField.setAccessible(true);
        tryCount = (TryCount) tryCountField.get(bridgeGame);
    }

    @AfterEach
    void afterEach() {
        randomsMockedStatic.close();
    }

    @DisplayName("BridgeGame 생성 테스트")
    @Test
    void createBridgeGame() {
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

        List<Tile> otherBridge = List.of(Tile.UP_TILE, Tile.DOWN_TILE, Tile.UP_TILE);

        assertThat(bridge.sameAs(otherBridge)).isTrue();
    }

    @DisplayName("한칸 이동하는 테스트")
    @Test
    void moveTest() throws Exception {
        bridgeGame.move("U");

        Tile currentTile = playerPath.currentTile();

        assertThat(currentTile).isEqualTo(Tile.UP_TILE);
    }

    @DisplayName("재시도 시 플레이어 경로 초기화 테스트")
    @Test
    void retryPlayerFieldInitTest() throws Exception {
        bridgeGame.retry(Rules.GAME_RETRY);

        assertThat(playerPath.currentPosition()).isEqualTo(-1);
        assertThat(playerPath.currentTile()).isEqualTo(null);
    }

    @DisplayName("재시도 시 시도 횟수 +1 테스트")
    @Test
    void retryCountAddTest() throws Exception {
        int beforeCount = tryCount.getTryCount();

        bridgeGame.retry(Rules.GAME_RETRY);

        assertThat(tryCount.getTryCount()).isEqualTo(beforeCount + 1);
    }
}
