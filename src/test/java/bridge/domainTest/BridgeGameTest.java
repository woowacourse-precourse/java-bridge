package bridge.domainTest;

import bridge.domain.BridgeGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeGameTest {

    @Test
    @DisplayName("해당 라운드의 사용자의 입력이 건널수 있는 다리인지 체크")
    void checkAnswerTest() {
        List<String> bridge = List.of("U","D","D","U");
        List<String> input = List.of("U","D","D","U");

        BridgeGame bridgeGame = new BridgeGame(bridge);

        for (int round = 0; round < bridge.size(); round++) {
            boolean result = bridgeGame.checkAnswer(input.get(round), round);
            Assertions.assertThat(result).isTrue();
        }
    }

    @Test
    @DisplayName("move()를 실행한 뒤 사용자의 입력이 history에 남는지 확인")
    void moveTestFirst() {
        List<String> bridge = List.of("U","D","D","U");
        List<String> input = List.of("U","D","D", "U");

        BridgeGame bridgeGame = new BridgeGame(bridge);

        for (int round = 0; round < input.size(); round++) {
            bridgeGame.move(input.get(round), round);
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
            bridgeGame.move(input.get(round), round);
        }

        List<String> history = bridgeGame.getHistory();

        Assertions.assertThat(history).containsExactly("U","D");
    }
}
