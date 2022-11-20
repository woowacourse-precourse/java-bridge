package bridge.domainTest;

import bridge.domain.BridgeGame;
import bridge.domain.StageResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeGameTest {

    @Test
    @DisplayName("해당 라운드의 사용자의 입력이 정답이면 PASS 반환")
    void passTest() {
        List<String> bridge = List.of("U","D","D","U");

        BridgeGame bridgeGame = new BridgeGame(bridge);

        StageResult result = bridgeGame.compareInputWithBridge("U");

        Assertions.assertThat(result).isEqualTo(StageResult.PASS);
    }

    @Test
    @DisplayName("해당 라운드의 사용자의 입력이 틀리면 FAIL 반환")
    void failTest() {
        List<String> bridge = List.of("U","D","D","U");

        BridgeGame bridgeGame = new BridgeGame(bridge);

        StageResult result = bridgeGame.compareInputWithBridge("D");

        Assertions.assertThat(result).isEqualTo(StageResult.FAIL);
    }

    @Test
    @DisplayName("마지막까지 정답을 틀리지 않고 맞출경우 SUCCESS 반환")
    void successTest() {
        List<String> bridge = List.of("U","D","D","U");
        String lastUserInput = "U";

        BridgeGame bridgeGame = new BridgeGame(bridge);

        for (int stage = 0; stage < bridge.size() - 1; stage++) {
            bridgeGame.pass();
        }

        StageResult result = bridgeGame.compareInputWithBridge(lastUserInput);

        Assertions.assertThat(result).isEqualTo(StageResult.SUCCESS);
    }

    @Test
    @DisplayName("move()를 실행한 뒤 사용자의 입력이 history에 남는지 확인")
    void moveTestFirst() {
        List<String> bridge = List.of("U","D","D","U");
        List<String> input = List.of("U","D","D", "U");

        BridgeGame bridgeGame = new BridgeGame(bridge);

        for (int round = 0; round < input.size(); round++) {
            bridgeGame.move(input.get(round));
        }

        List<String> history = bridgeGame.getHistory();

        Assertions.assertThat(history).containsExactly("U","D","D","U");
    }

    @Test
    @DisplayName("move()를 실행한 뒤 사용자의 입력이 중간에 틀려도 history에 남는지 확인")
    void moveTestSecond() {
        List<String> bridge = List.of("U","D","D","U");
        List<String> input = List.of("U","D");

        BridgeGame bridgeGame = new BridgeGame(bridge);

        for (int round = 0; round < input.size(); round++) {
            bridgeGame.move(input.get(round));
        }

        List<String> history = bridgeGame.getHistory();

        Assertions.assertThat(history).containsExactly("U","D");
    }
}
