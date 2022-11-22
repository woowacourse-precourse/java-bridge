package bridge;

import bridge.service.BridgeGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameTest {

    @Test
    void 잘못된_칸_이동_테스트() {
        List<String> bridge = new ArrayList<>(List.of("U","D","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        Assertions.assertThat(bridgeGame.move("D")).isEqualTo(false);
    }

    @Test
    void 올발른_칸_이동_테스트() {
        List<String> bridge = new ArrayList<>(List.of("U","U","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        Assertions.assertThat(bridgeGame.move("U")).isEqualTo(true);
    }

    @Test
    void 올바른_칸_이동_후_성공() {
        List<String> bridge = new ArrayList<>(List.of("U","U","D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("D");
        Assertions.assertThat(bridgeGame.getSuccess()).isEqualTo(true);
    }



}
