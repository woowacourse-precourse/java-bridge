package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    Bridge bridge;
    BridgeGame bridgeGame;

    @BeforeEach
    void setUpAnswer() {
        bridge = new Bridge(List.of("U", "D", "D"));
        bridgeGame = new BridgeGame(bridge);
    }

    @DisplayName("다리 건너기 테스트")
    @Test
    void moveTest() {
        bridgeGame.move("U");
        List<List<String>> test = new ArrayList<>();
        test.add(bridgeGame.getGameResult().getUpperBridge());
        test.add(bridgeGame.getGameResult().getLowerBridge());
        assertThat(test).containsExactly(List.of("O"), List.of(" "));
    }

    @DisplayName("게임 재시도 횟수 테스트")
    @Test
    void retryTest() {
        bridgeGame.retry();
        bridgeGame.retry();
        assertThat(bridgeGame.getTryCount()).isEqualTo(3);
    }

    @DisplayName("다리 끝까지 건넌 경우 테스트")
    @Test
    void ClearGameTest() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        assertThat(bridgeGame.isClearGame()).isFalse();
    }
}
