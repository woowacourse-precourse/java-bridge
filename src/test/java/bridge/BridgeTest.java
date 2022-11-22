package bridge;

import bridge.domain.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeTest {

    @DisplayName("플레이어가 선택한 칸이 건널 수 있는 칸이면 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4})
    void checkPassableBlock(Integer nextPosition) {
        Bridge bridge = new Bridge(List.of("U", "D", "U", "D", "U"));
        String selectBlock = new String("U"); // 플레이어가 입력한 inputString
        assertThat(bridge.checkPassableBlock(nextPosition, selectBlock)).isTrue();
    }

    @DisplayName("플레이어가 선택한 칸이 건널 수 없는 칸이면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4})
    void checkNonPassableBlock(Integer nextPosition) {
        Bridge bridge = new Bridge(List.of("U", "D", "U", "D", "U"));
        String selectBlock = new String("D"); // 플레이어가 입력한 inputString
        assertThat(bridge.checkPassableBlock(nextPosition, selectBlock)).isFalse();
    }
}