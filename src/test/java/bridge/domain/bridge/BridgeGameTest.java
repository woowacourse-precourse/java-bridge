package bridge.domain.bridge;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.game.BridgeGame;
import bridge.domain.player.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.when;

class BridgeGameTest {

    private BridgeGame bridgeGame;
    private Player player;
    private BridgeNumberGenerator bridgeNumberGenerator;

    @BeforeEach
    void init() {
        bridgeNumberGenerator = Mockito.mock(BridgeRandomNumberGenerator.class);
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        Bridge bridge = Bridge.of(3, bridgeMaker);
        player = new Player();
        bridgeGame = BridgeGame.of(bridge, player);
    }

    @Test
    @DisplayName("다리는 아래에 생성, 유저는 위로 이동할 때 X")
    void 다리_X_테스트() {
        when(bridgeNumberGenerator.generate()).thenReturn(0);
        player.addMoving("U");

        List<List<String>> map = bridgeGame.move();

        Assertions.assertThat(map).isEqualTo(List.of(List.of("X"), List.of(" ")));
    }

    @Test
    @DisplayName("다리는 아래에 생성, 유저는 아래로 이동할 때 O")
    void 다리_O_테스트() {
        when(bridgeNumberGenerator.generate()).thenReturn(0);
        player.addMoving("D");

        List<List<String>> map = bridgeGame.move();

        Assertions.assertThat(map).isEqualTo(List.of(List.of(" "), List.of("O")));
    }

    @Test
    @DisplayName("다리는 연속 아래에 생성, 유저는 아래로 이동 후 위로 이동")
    void 다리_연속_이동후_X_테스트() {
        when(bridgeNumberGenerator.generate()).thenReturn(0);
        player.addMoving("D");
        bridgeGame.move();

        player.addMoving("U");
        List<List<String>> map = bridgeGame.move();

        Assertions.assertThat(map).isEqualTo(List.of(List.of(" ", "X"), List.of("O", " ")));
    }

    @Test
    @DisplayName("다리는 연속 아래에 생성, 유저는 아래로 연속 이동")
    void 다리_연속_이동후_O_테스트() {
        when(bridgeNumberGenerator.generate()).thenReturn(0);
        player.addMoving("D");
        bridgeGame.move();

        player.addMoving("D");
        List<List<String>> map = bridgeGame.move();

        Assertions.assertThat(map).isEqualTo(List.of(List.of(" ", " "), List.of("O", "O")));
    }
}
