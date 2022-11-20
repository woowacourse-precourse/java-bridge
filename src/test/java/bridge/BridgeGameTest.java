package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @DisplayName("위쪽으로 이동 가능한 다리에서 위쪽으로 가면 이동한다.")
    @Test
    void moveSuccessTest() {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U")));

        assertThat(bridgeGame.move("U")).isTrue();
    }

    @DisplayName("위쪽으로 이동 가능한 다리에서 아래쪽으로 가면 이동할 수 없다.")
    @Test
    void moveFailTest() {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U")));

        assertThat(bridgeGame.move("D")).isFalse();
    }

    @DisplayName("다리의 끝에서는 이동할 수 없다.")
    @Test
    void moveAtEndOfBridgeFailTest() {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U")));
        bridgeGame.move("U");

        assertThat(bridgeGame.move("U")).isFalse();
    }

    @DisplayName("다리 끝까지 도착했을때 True를 반환한다.")
    @Test
    void isReachedEndOfBridgeTest() {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U")));
        bridgeGame.move("U");

        assertThat(bridgeGame.isReachedEndOfBridge()).isTrue();
    }

    @DisplayName("다리 끝에 도착하지 않았을때 False를 반환한다.")
    @Test
    void isReachedEndOfBridgeFailTest() {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U")));

        assertThat(bridgeGame.isReachedEndOfBridge()).isFalse();
    }
}