package bridge.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    @Test
    void getMap_메서드_테스트() {
        List<String> bridge = List.of("U", "D", "U");
        final BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        List<List<String>> EXPECTED_RESULT = List.of( List.of("O", " ", " "), List.of(" ", "O", "X"));
        assertThat(bridgeGame.getMaps()).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    void retry_메서드_테스트() {
        List<String> bridge = List.of("U", "D", "U");
        final BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        bridgeGame.retry();
        List<List<String>> EXPECTED_RESULT = List.of( List.of(), List.of());
        assertThat(bridgeGame.getMaps()).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    void getAttemptCount_메서드_시도_횟수_테스트() {
        List<String> bridge = List.of("U", "D", "U");
        final BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        int EXPECTED_RESULT = 3;
        assertThat(bridgeGame.getAttemptCount()).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    void isValidLastStep_메서드_마지막_이동이_실패할_경우_false_리턴() {
        List<String> bridge = List.of("U", "D", "U");
        final BridgeGame bridgeGame = new BridgeGame(bridge);
        String FINAL_STEP = "D";

        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move(FINAL_STEP);
        Boolean EXPECTED_RESULT = false;
        assertThat(bridgeGame.isValidLastStep(FINAL_STEP)).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    void isValidLastStep_메서드_마지막_이동이_성공할_경우_true_리턴() {
        List<String> bridge = List.of("U", "D", "U");
        final BridgeGame bridgeGame = new BridgeGame(bridge);
        String FINAL_STEP = "D";

        bridgeGame.move("U");
        bridgeGame.move(FINAL_STEP);

        Boolean EXPECTED_RESULT = true;
        assertThat(bridgeGame.isValidLastStep(FINAL_STEP)).isEqualTo(EXPECTED_RESULT);
    }


    @Test
    void isGameSuccess_메서드_게임_결과_성공_테스트() {
        List<String> bridge = List.of("U", "D", "U", "U", "D");
        final BridgeGame bridgeGame = new BridgeGame(bridge);
        String FINAL_STEP = "D";

        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move(FINAL_STEP);

        Boolean EXPECTED_RESULT = true;
        assertThat(bridgeGame.isGameSuccess(FINAL_STEP)).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    void isGameSuccess_메서드_게임_결과_실패_테스트() {
        List<String> bridge = List.of("U", "D", "U", "U", "D");
        final BridgeGame bridgeGame = new BridgeGame(bridge);
        String FINAL_STEP = "U";

        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move(FINAL_STEP);

        Boolean EXPECTED_RESULT = false;
        assertThat(bridgeGame.isGameSuccess(FINAL_STEP)).isEqualTo(EXPECTED_RESULT);
    }
}
