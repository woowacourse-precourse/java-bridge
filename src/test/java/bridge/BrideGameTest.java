package bridge;

import bridge.domain.BridgeGame;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BrideGameTest {

    @Test
    void 이동_성공_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        assertSimpleTest(() -> {
            String square = "U";
            String choice = "U";
            bridgeGame.move(square,choice);
            assertThat(bridgeGame.toString()).contains(
                    "[ O ]",
                    "[   ]"
            );
            int upSideIndex = bridgeGame.toString().indexOf("[ O ]");
            int downSideIndex = bridgeGame.toString().indexOf("[   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        });
    }

    @Test
    void 재시도_횟수_증가_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        String reply ="R";
        int attempt = 1;
        attempt = bridgeGame.retry(reply,attempt);
        assertThat(attempt).isEqualTo(2);
    }

    @Test
    void 종료시_시도횟수_테스트(){
        BridgeGame bridgeGame = new BridgeGame();
        String reply ="Q";
        int attempt = 1;
        attempt = bridgeGame.retry(reply,attempt);
        assertThat(attempt).isEqualTo(1);
    }
}
