package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.BridgeGame;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void setup() {
        List<String> bridges = Arrays.asList("U","D","U");
        bridgeGame = new BridgeGame(bridges);
    }

    @Test
    void 건널_수_있는_칸으로_이동_시_true_반환() {
        List<String> correctInputs = Arrays.asList("U","D","U");

        for (String input : correctInputs) {
            assertThat(bridgeGame.move(input)).isEqualTo(true);
        }
    }

    @Test
    void 건널_수_없는_칸으로_이동_시_false_반환() {
        String input = "D";

        assertThat(bridgeGame.move(input)).isEqualTo(false);
    }

}
