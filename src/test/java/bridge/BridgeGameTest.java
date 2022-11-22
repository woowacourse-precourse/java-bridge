package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeGameTest {
    @Test
    void 입력받은_값이_정답일_경우_isCorrect_함수_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        String bridgeData = "U";
        String inputMoving = "U";

        boolean bool = bridgeGame.isCorrect(bridgeData, inputMoving);

        assertThat(bool).isEqualTo(true);
    }

    @Test
    void 입력받은_값이_오답일_경우_isCorrect_함수_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        String bridgeData = "U";
        String inputMoving = "D";

        boolean bool = bridgeGame.isCorrect(bridgeData, inputMoving);

        assertThat(bool).isEqualTo(false);
    }

    @Test
    void 입력받은_값이_정답일_경우_move_함수_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        String bridgeData = "U";
        String inputMoving = "U";

        bridgeGame.move(bridgeData,inputMoving);

        assertThat(bridgeGame.playedCount).isEqualTo(1);
        assertThat(bridgeGame.isSuccess).isEqualTo("성공");
    }

    @Test
    void 입력받은_값이_오답일_경우_move_함수_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        String bridgeData = "U";
        String inputMoving = "D";

        bridgeGame.move(bridgeData,inputMoving);

        assertThat(bridgeGame.playedCount).isEqualTo(2);
        assertThat(bridgeGame.isSuccess).isEqualTo("실패");
    }
}
