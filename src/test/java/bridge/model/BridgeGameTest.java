package bridge.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {

    private final List<String> bridge = List.of("U", "U", "U");
    private BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        this.bridgeGame = new BridgeGame(this.bridge);
    }

    @Test
    @DisplayName("move 성공 : 모두 안전")
    void case1() {
        List<String> directions = List.of("U", "U", "U");
        for (String direction : directions) {
            boolean result = bridgeGame.move(direction);
            assertThat(result).isEqualTo(true);
        }

    }

    @Test
    @DisplayName("move 성공 : 안전하지 않은 경우")
    void case2() {
        List<String> directions = List.of("U", "U", "D");
        for (int i = 0; i < directions.size(); i++) {
            boolean result = bridgeGame.move(directions.get(i));
            if (i == directions.size() - 1) {
                assertThat(result).isEqualTo(false);
                continue;
            }
            assertThat(result).isEqualTo(true);
        }
    }

    @Test
    @DisplayName("move 실패: 유효하지 않은 direction")
    void case3() {
        String direction = "R";
        assertThatThrownBy(() -> bridgeGame.move(direction)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("retry 성공")
    void case4() {
        String gameCommand = "R";
        List<Step> steps = new ArrayList<>();
        steps.add(Step.UP_SUCCESS);
        steps.add(Step.UP_FAIL);
        bridgeGame.getResult().setSteps(steps);
        boolean result = bridgeGame.retry(gameCommand);
        assertThat(result).isEqualTo(true);
        assertThat(bridgeGame.getResult().getTrial()).isEqualTo(2);
    }

    @Test
    @DisplayName("retry 실패: 유효하지 않은 direction")
    void case5() {
        String gameCommand = "AAA";
        assertThatThrownBy(() -> bridgeGame.retry(gameCommand)).isInstanceOf(IllegalArgumentException.class);
    }
}
