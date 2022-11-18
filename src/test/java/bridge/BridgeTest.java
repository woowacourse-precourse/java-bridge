package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    @DisplayName("해당 순서의 칸이 동일하면 true를 반환한다")
    @Test
    void judgePossibleToMove() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));

        boolean possibleToMove = bridge.isPossibleToMove("D", 1);

        assertThat(possibleToMove).isEqualTo(true);
    }

    @DisplayName("해당 순서의 칸이 동일하지 않으면 false를 반환한다")
    @Test
    void judgeImpossibleToMove() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));

        boolean possibleToMove = bridge.isPossibleToMove("U", 1);

        assertThat(possibleToMove).isEqualTo(false);
    }
}
