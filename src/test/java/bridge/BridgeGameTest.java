package bridge;

import bridge.Util.GAME_STATE;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeGameTest {
    private BridgeGame bridgeGameTest = new BridgeGame();
    private List<String> testBridge = Arrays.asList("U", "D", "D", "U");

    @Test
    void 정상_움직임_테스트() {
        assertThat(bridgeGameTest.move("U", testBridge)).isEqualTo(GAME_STATE.IN_GAME);
    }

    @Test
    void 잘못된_움직임_테스트(){
        assertThat(bridgeGameTest.move("D", testBridge)).isEqualTo(GAME_STATE.RETRY);
    }

    @Test
    void 게임_종료_데스트(){
        assertThat(bridgeGameTest.move("D", List.of("D"))).isEqualTo(GAME_STATE.SUCCESS);
    }

}
