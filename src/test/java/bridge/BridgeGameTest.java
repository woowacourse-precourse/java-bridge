package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeGameTest {
    @DisplayName("다리가 있는 곳으로 이동한 결과가 제대로 나타나는지 테스트")
    @Test
    void right_move_test() {
        BridgeGame bridgeGame = new BridgeGame();

        assertThat(bridgeGame.move(List.of("D", "U", "D", "D"), "D", 0))
                .isEqualTo(" O ");
    }

    @DisplayName("다리가 없는 곳으로 이동한 결과가 제대로 나타나는지 테스트")
    @Test
    void wrong_move_test() {
        BridgeGame bridgeGame = new BridgeGame();

        assertThat(bridgeGame.move(List.of("D", "U", "D", "D"), "U", 3))
                .isEqualTo(" X ");
    }
}