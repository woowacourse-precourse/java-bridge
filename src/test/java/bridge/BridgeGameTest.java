package bridge;

import bridge.service.BridgeGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameTest {

    @DisplayName("잘못된 칸 이동인지 테스트한다.")
    @Test
    void 잘못된_칸_이동_테스트() {
        List<String> bridge = new ArrayList<>(List.of("U","D","Ugit "));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        Assertions.assertThat(bridgeGame.move("D")).isEqualTo(false);
    }

    @DisplayName("올바른 칸 이동인지 테스트한다.")
    @Test
    void 올발른_칸_이동_테스트() {
        List<String> bridge = new ArrayList<>(List.of("U","U","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        Assertions.assertThat(bridgeGame.move("U")).isEqualTo(true);
    }

    @DisplayName("올바른 칸 이동 후 성공하는지 테스트한다.")
    @Test
    void 올바른_칸_이동_후_성공_테스트() {
        List<String> bridge = new ArrayList<>(List.of("U","U","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("D");
        Assertions.assertThat(bridgeGame.getSuccess()).isEqualTo(true);
    }

    @DisplayName("잘못된 칸 이동 후 실패하는지 테스트한다.")
    @Test
    void 잘못된_칸_이동_후_실패_테스트() {
        List<String> bridge = new ArrayList<>(List.of("U","D","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        Assertions.assertThat(bridgeGame.getSuccess()).isEqualTo(false);
    }
}
