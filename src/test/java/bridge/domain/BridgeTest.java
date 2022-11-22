package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {
    Bridge bridge = new Bridge("3");

    @DisplayName("현재의 성공 여부를 저장한다.")
    @Test
    void isCurrentMovableTest() {
        List<MoveResult> moveResults = new ArrayList<>();
        moveResults.add(new MoveResult(true, "up"));
        boolean result = bridge.isCurrentMovable(moveResults);

        assertThat(result).isEqualTo(true);
    }

    @DisplayName("다리를 다 건넜는지 여부를 확인한다.")
    @Test
    void checkNotOverStep() {
        boolean result = bridge.crossingBridgeSuccess();
        assertThat(result).isEqualTo(true);
    }
}
