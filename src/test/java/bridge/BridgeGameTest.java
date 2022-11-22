package bridge;

import bridge.constant.SuccessFail;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.constant.SuccessFail.FAIL;
import static bridge.constant.SuccessFail.SUCCESS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeGameTest {
    @Test
    void moveTest() {
        List<String> bridge = List.of("U", "D", "U");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.player).isEqualTo(List.of("U", "D"));
    }

    @Test
    void retryTest() {
        List<String> bridge = List.of("U", "D", "U");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.retry();
        assertThat(bridgeGame.player).isEqualTo(List.of());
    }

    @Test
    void isSuccessTest_SUCCESS() {
        List<String> bridge = List.of("U", "D", "U");
        List<String> player = List.of("U", "D", "U");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.player = player;
        SuccessFail isSuccess = bridgeGame.isSuccess();
        assertThat(isSuccess).isEqualTo(SUCCESS);
    }

    @Test
    void isSuccessTest_FAIL() {
        List<String> bridge = List.of("U", "D", "U");
        List<String> player = List.of("U", "D", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.player = player;
        SuccessFail isSuccess = bridgeGame.isSuccess();
        assertThat(isSuccess).isEqualTo(FAIL);
    }

    @Test
    void isFinish_true1() {
        List<String> bridge = List.of("U", "D", "U");
        List<String> player = List.of("U", "U");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.player = player;
        boolean isFinish = bridgeGame.isFinish();
        assertThat(isFinish).isEqualTo(true);
    }

    @Test
    void isFinish_true2() {
        List<String> bridge = List.of("U", "D", "U");
        List<String> player = List.of("U", "D", "U");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.player = player;
        boolean isFinish = bridgeGame.isFinish();
        assertThat(isFinish).isEqualTo(true);
    }

    @Test
    void isFinish_true3() {
        List<String> bridge = List.of("U", "D", "U");
        List<String> player = List.of("U", "D", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.player = player;
        boolean isFinish = bridgeGame.isFinish();
        assertThat(isFinish).isEqualTo(true);
    }

    @Test
    void isFinish_false() {
        List<String> bridge = List.of("U", "D", "U");
        List<String> player = List.of("U", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.player = player;
        boolean isFinish = bridgeGame.isFinish();
        assertThat(isFinish).isEqualTo(false);
    }
}