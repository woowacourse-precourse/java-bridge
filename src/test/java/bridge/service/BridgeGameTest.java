package bridge.service;

import bridge.domain.Attempt;
import bridge.domain.Bridge;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeGameTest {

    @DisplayName("isMatchBridgeSize 메서드 호출")
    @Test
    void isMatchBridgeSize() {
        // given
        BridgeGame bridgeGame = createBridgeGame();

        // when

        // then
        Assertions.assertThat(bridgeGame.isMatchBridgesSize()).isFalse();
    }

    @DisplayName("getUpperBridges 메서드 호출")
    @Test
    void getUpperBridges() {
        // given
        BridgeGame bridgeGame = createBridgeGame();

        // when

        // then
        Assertions.assertThat(bridgeGame.getLowerBridges().isEmpty()).isTrue();
    }

    @DisplayName("getLowerBridges 메서드 호출")
    @Test
    void getLowerBridges() {
        // given
        BridgeGame bridgeGame = createBridgeGame();

        // when

        // then
        Assertions.assertThat(bridgeGame.getLowerBridges().isEmpty()).isTrue();
    }

    @DisplayName("isFail 메서드 호출")
    @Test
    void isFail() {
        // given
        BridgeGame bridgeGame = createBridgeGame();

        // when

        // then
        Assertions.assertThat(bridgeGame.isFail()).isTrue();
    }

    @DisplayName("retry 메서드 호출")
    @Test
    void retry() {
        // given
        BridgeGame bridgeGame = createBridgeGame();
        Attempt attempt = new Attempt();

        // when
        bridgeGame.retry(attempt);

        // then
        Assertions.assertThat(attempt.getCount()).isEqualTo(2);
    }
    BridgeGame createBridgeGame() {
        return new BridgeGame(createBridge());
    }

    Bridge createBridge() {
        List<String> input = List.of("U", "D", "D", "U");
        return new Bridge(input);
    }
}
