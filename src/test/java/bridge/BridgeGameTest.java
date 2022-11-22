package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.gameplay.BridgeGame;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeGameTest {
    BridgeGame bridgeGame;
    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame(List.of("U", "D", "U"));
    }


    @DisplayName("U가 입력되면 bridgeTrack에 U가 추가된다.")
    @Test
    void moveToU() {
        bridgeGame.move("U");
        assertThat(bridgeGame.getBridgeTrack()).isEqualTo(List.of("U"));
    }

    @DisplayName("D가 입력되면 bridgeTrack에 D가 추가된다.")
    @Test
    void moveToDTwice() {
        bridgeGame.move("D");
        bridgeGame.move("D");
        assertThat(bridgeGame.getBridgeTrack()).isEqualTo(List.of("D", "D"));
    }
    @DisplayName("reset()이후 bridgeTrack은 초기화된다.")
    @Test
    void resetAndCheckBridgeTrackSize() {
        bridgeGame.move("D");
        assertThat(bridgeGame.getBridgeTrack()).isNotEmpty();
        bridgeGame.retry();
        assertThat(bridgeGame.getBridgeTrack()).isEmpty();
    }
    @DisplayName("최근 움직임이 정답이면 true가 반환된다.")
    @Test
    void successToMove() {
        bridgeGame.move("U");
        assertThat(bridgeGame.isRecentMoveSuccessful()).isTrue();
    }
    @DisplayName("최근 움직임이 오답이면 false가 반환된다.")
    @Test
    void failToMove() {
        bridgeGame.move("U");
        bridgeGame.move("U");
        assertThat(bridgeGame.isRecentMoveSuccessful()).isFalse();
    }
    @DisplayName("retry 횟수에 따라 tryCount의 횟수가 달라진다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void checkTryCountWhenRetry(int retryCount) {
        for (int i = 0; i < retryCount; i++) {
            bridgeGame.retry();
        }
        assertThat(bridgeGame.getTryCount()).isEqualTo(retryCount + 1);
    }
    @DisplayName("다리와 똑같이 움직이면 성공한다.")
    @Test
    void gameSuccess() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        assertThat(bridgeGame.isBridgeGameSuccess()).isTrue();
    }
    @DisplayName("움직이는데 실패하면 성공한 상태가 아니다.")
    @Test
    void gameIsNotSuccess() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        assertThat(bridgeGame.isBridgeGameSuccess()).isFalse();
    }
    @DisplayName("끝까지 도달하지 않으면 성공한 상태가 아니다.")
    @Test
    void gameIsNotSuccess2() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.isBridgeGameSuccess()).isFalse();
    }
}
