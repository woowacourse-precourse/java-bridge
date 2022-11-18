package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeGameTest {

    @DisplayName("U가 입력되면 bridgeTrack에 U가 추가된다.")
    @Test
    void moveToU() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        bridgeGame.move("U");
        assertThat(bridgeGame.getBridgeTrack()).isEqualTo(List.of("U"));
    }

    @DisplayName("D가 입력되면 bridgeTrack에 D가 추가된다.")
    @Test
    void moveToDTwice() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        bridgeGame.move("D");
        bridgeGame.move("D");
        assertThat(bridgeGame.getBridgeTrack()).isEqualTo(List.of("D", "D"));
    }
    @DisplayName("reset()이후 bridgeTrack은 초기화된다.")
    @Test
    void resetAndCheckBridgeTrackSize() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        bridgeGame.move("D");
        assertThat(bridgeGame.getBridgeTrack()).isNotEmpty();
        bridgeGame.reset();
        assertThat(bridgeGame.getBridgeTrack()).isEmpty();
    }
    @DisplayName("최근 움직임이 정답이면 true가 반환된다.")
    @Test
    void successToMove() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        bridgeGame.move("U");
        assertThat(bridgeGame.isRecentMoveSuccessful()).isTrue();
    }
    @DisplayName("최근 움직임이 오답이면 false가 반환된다.")
    @Test
    void failToMove() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        bridgeGame.move("U");
        bridgeGame.move("U");
        assertThat(bridgeGame.isRecentMoveSuccessful()).isFalse();
    }
    @DisplayName("retry 횟수에 따라 tryCount의 횟수가 달라진다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void checkTryCountWhenRetry(int retryCount) {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        for (int i = 0; i < retryCount; i++) {
            bridgeGame.retry();
        }
        assertThat(bridgeGame.getTryCount()).isEqualTo(retryCount + 1);
    }

}
