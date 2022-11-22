package bridge.domainTest;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeStage;
import bridge.domain.StageResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeGameTest {
    @BeforeEach
    void reset() {
        BridgeStage.resetStage();
    }

    @Test
    @DisplayName("해당 라운드의 사용자의 입력이 정답이면 PASS 반환")
    void passTest() {
        List<String> bridge = List.of("U","D","D","U");

        BridgeGame bridgeGame = new BridgeGame(bridge);

        StageResult result = bridgeGame.move("U");

        Assertions.assertThat(result).isEqualTo(StageResult.PASS);
    }

    @Test
    @DisplayName("해당 라운드의 사용자의 입력이 틀리면 FAIL 반환")
    void failTest() {
        List<String> bridge = List.of("U","D","D","U");

        BridgeGame bridgeGame = new BridgeGame(bridge);

        StageResult result = bridgeGame.move("D");

        Assertions.assertThat(result).isEqualTo(StageResult.FAIL);
    }

    @Test
    @DisplayName("마지막까지 정답을 틀리지 않고 맞출경우 SUCCESS 반환")
    void successTest() {
        List<String> bridge = List.of("U","D","D","U");
        List<String> userInput = List.of("U","D","D","U");

        BridgeGame bridgeGame = new BridgeGame(bridge);

        for (int stage = 0; stage < bridge.size() - 1; stage++) {
            bridgeGame.pass();
        }

        String lastInput = bridge.get(bridge.size() - 1);
        StageResult lastResult = bridgeGame.move(lastInput);


        Assertions.assertThat(lastResult).isEqualTo(StageResult.SUCCESS);
    }

    @Test
    @DisplayName("결과가 PASS이면 BridgeStage의 stage를 1 증가한다")
    void afterPassTest() {
        List<String> bridge = List.of("U","D","D","U");

        BridgeGame bridgeGame = new BridgeGame(bridge);

        bridgeGame.pass();

        int stage = BridgeStage.currentStage();

        Assertions.assertThat(stage).isEqualTo(1);
    }

    @Test
    @DisplayName("게임을 재시작하면 BridgeStage의 retry를 증가시키고 stage를 0으로 초기화 한다")
    void retryTest() {
        List<String> bridge = List.of("U","D","D","U");
        BridgeGame bridgeGame = new BridgeGame(bridge);

        bridgeGame.retry();

        int retry = BridgeStage.getRetry();
        int stage = BridgeStage.currentStage();

        Assertions.assertThat(retry).isEqualTo(2);
        Assertions.assertThat(stage).isEqualTo(0);

    }
}
