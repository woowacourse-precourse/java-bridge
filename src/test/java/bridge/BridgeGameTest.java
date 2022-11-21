package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeGameTest {

    private BridgeGame bridgeGame;
    private List<String> bridge;

    @BeforeEach
    void init() {
        bridge = List.of("U", "U", "D", "U", "D", "D", "U");
        bridgeGame = new BridgeGame(bridge);
    }

    @DisplayName("move 메서드를 실행하면 user 배열에 입력 받은 문자가 추가된다.")
    @Test
    void move() {
        bridgeGame.move("U");
        List<String> user = bridgeGame.getUser();
        Assertions.assertThat(user.size()).isEqualTo(1);
        Assertions.assertThat(user).containsExactly("U");
    }

    @DisplayName("\"R\"을 입력하면 시도횟수가 증가하고, 유저 입력값이 초기화한다.")
    @Test
    void retry() {
        Assertions.assertThat(bridgeGame.retry("R")).isTrue();

        List<String> user = bridgeGame.getUser();
        Assertions.assertThat(user).isEmpty();
        int attempts = bridgeGame.getAttempts();
        Assertions.assertThat(attempts).isEqualTo(2);
    }

    @DisplayName("입력값과 다리의 값을 비교하여 boolean 값을 반환한다.")
    @Test
    void isCorrect() {
        bridgeGame.move("U");
        Assertions.assertThat(bridgeGame.isCorrect())
                .isTrue();
        bridgeGame.move("U");
        Assertions.assertThat(bridgeGame.isCorrect())
                .isTrue();
        bridgeGame.move("U");
        Assertions.assertThat(bridgeGame.isCorrect())
                .isFalse();
    }
}