package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    @DisplayName("칸의 이동을 확인한다.")
    @Test
    void bridgeGameMove() {
        List<String> testBridge = Arrays.asList("U", "D", "D");
        BridgeGame bridgeGame = new BridgeGame(testBridge);

        assertThat(bridgeGame.move(InputView.UP)).isTrue();
        assertThat(bridgeGame.getNextIndex()).isEqualTo(1);
        assertThat(bridgeGame.move(InputView.UP)).isFalse();
        assertThat(bridgeGame.getNextIndex()).isEqualTo(2);
        assertThat(bridgeGame.move(InputView.DOWN)).isTrue();
        assertThat(bridgeGame.getNextIndex()).isEqualTo(3);
    }

    @DisplayName("재시작 선택 시 리셋을 확인한다.")
    @Test
    void retry() {
        List<String> testBridge = Arrays.asList("U", "D", "U", "D");
        BridgeGame bridgeGame = new BridgeGame(testBridge);

        bridgeGame.move(InputView.UP);
        assertThat(bridgeGame.getTryCnt()).isEqualTo(1);

        bridgeGame.retry();
        assertThat(bridgeGame.getNextIndex()).isEqualTo(0);
        assertThat(bridgeGame.getTryCnt()).isEqualTo(2);
    }

    @DisplayName("게임의 종료 여부를 확인한다.")
    @Test
    void gameFinished() {
        List<String> testBridge = Arrays.asList("U", "D");
        BridgeGame bridgeGame = new BridgeGame(testBridge);

        bridgeGame.move(InputView.UP);
        assertThat(bridgeGame.gameFinishedCheck()).isFalse();
        bridgeGame.move(InputView.UP);
        assertThat(bridgeGame.gameFinishedCheck()).isTrue();

        bridgeGame.retry();

        bridgeGame.move(InputView.UP);
        assertThat(bridgeGame.gameFinishedCheck()).isFalse();
        bridgeGame.move(InputView.DOWN);
        assertThat(bridgeGame.gameFinishedCheck()).isTrue();
    }
}
