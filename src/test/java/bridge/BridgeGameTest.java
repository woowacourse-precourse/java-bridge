package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    private final String PASS = "O";
    private final String FAIL = "X";

    @DisplayName("사용자가 입력한 이동할 칸과 다리를 제대로 비교하는 지 확인")
    @Test
    void compareTest() {
        BridgeGame bridgeGame = new BridgeGame();
        assertThat(bridgeGame.checkAnswer(List.of("U", "D", "D", "U", "D", "U"), "D", 3))
                .isEqualTo(PASS);
        assertThat(bridgeGame.checkAnswer(List.of("U", "D", "D", "U", "D", "U"), "U", 3))
                .isEqualTo(FAIL);
    }
}
