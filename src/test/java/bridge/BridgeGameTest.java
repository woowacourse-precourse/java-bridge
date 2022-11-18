package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class BridgeGameTest {
    @Test
    void 올발른_칸_이동_테스트() {
        List<String> bridge = new ArrayList<>(List.of("U","U","D"));
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame(bridge, outputView);
        Assertions.assertThat(bridgeGame.move("U")).isEqualTo(true);
    }

    @Test
    void 잘못된_칸_이동_테스트() {
        List<String> bridge = new ArrayList<>(List.of("U","U","D"));
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame(bridge, outputView);
        Assertions.assertThat(bridgeGame.move("D")).isEqualTo(false);
    }
}