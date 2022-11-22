package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeGameTest {
    @Test
    void 입렫받음_값이_정답일_경우() {
        BridgeGame bridgeGame = new BridgeGame();
        String bridgeData = "U";
        String inputMoving = "U";

        boolean bool = bridgeGame.isCorrect(bridgeData, inputMoving);

        assertThat(bool).isEqualTo(true);
    }

    @Test
    void 입렫받음_값이_오답일_경우() {
        BridgeGame bridgeGame = new BridgeGame();
        String bridgeData = "U";
        String inputMoving = "D";

        boolean bool = bridgeGame.isCorrect(bridgeData, inputMoving);

        assertThat(bool).isEqualTo(false);
    }
}
