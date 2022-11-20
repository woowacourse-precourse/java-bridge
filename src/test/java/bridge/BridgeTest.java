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
    @ValueSource(ints = {-1, 1, 3})
    void checkPassableBlock(Integer currentPosition) {
        Bridge bridge = new Bridge(List.of("U", "D", "U", "D", "U"));
        String selectBlock = new String("U"); // 플레이어가 입력한 inputString
        assertThat(bridge.checkPassableBlock(currentPosition, selectBlock)).isTrue();
    }
}