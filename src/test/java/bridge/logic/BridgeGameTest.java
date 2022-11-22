package bridge.logic;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.MovingResult;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    private static BridgeGame bridgeGame;

    @BeforeAll
    static void init() {
        bridgeGame = new BridgeGame();
    }

    @Test
    @DisplayName("사용자가 칸을 올바르게 이동한 경우를 테스트")
    void moveRight() {
        String moving = "U";
        List<String> bridge = List.of("U", "D", "D");
        int round = 0;

        MovingResult movingResult = bridgeGame.move(moving, bridge, round);
        assertThat(movingResult.getResult()).isEqualTo("O");
    }

    @Test
    @DisplayName("사용자가 칸을 올바르게 이동하지 않은 경우를 테스트")
    void moveWrong() {
        String moving = "U";
        List<String> bridge = List.of("U", "D", "D");
        int round = 1;

        MovingResult movingResult = bridgeGame.move(moving, bridge, round);
        assertThat(movingResult.getResult()).isEqualTo("X");
    }

}
