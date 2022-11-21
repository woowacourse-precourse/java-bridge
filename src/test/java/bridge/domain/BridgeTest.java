package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeTest {

    @DisplayName("사용자가 이동한 칸이 건너갈 수 있는지 테스트")
    @ParameterizedTest
    @CsvSource({"U,0,true", "U,1,false"})
    void 다리를_건널_수_있는지_테스트(String playerMove, int playerPosition, Boolean expected) {
        BridgeMovement playerMovement = BridgeMovement.findByMovement(playerMove);
        Bridge bridge = new Bridge(new ArrayList<>(Arrays.asList("U", "D", "D")));
        assertThat(bridge.isCrossable(playerMovement, playerPosition)).isEqualTo(expected);
    }

    @DisplayName("사용자가 다리를 끝까지 건넜는지 테스트")
    @ParameterizedTest
    @CsvSource({"1,false", "3,true"})
    void 다리를_건널_수_있는지_테스트(int playerPosition, Boolean expected) {
        Bridge bridge = new Bridge(new ArrayList<>(Arrays.asList("U", "D", "D")));
        assertThat(bridge.isReachedTheEnd(playerPosition)).isEqualTo(expected);
    }
}