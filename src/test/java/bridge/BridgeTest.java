package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import bridge.domain.Bridge;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeTest extends NsTest {

    @ValueSource(ints = {2, 21, 100})
    @ParameterizedTest
    void 다리길이_범위초과_예외_테스트(int size) {
        List<String> ar = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            ar.add(String.valueOf(i));
        }
        assertThatThrownBy(() -> new Bridge(ar))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 index 번째에서 건널 수 있는 다리가 movingPoint 가 맞는지 테스트")
    @Test
    void checkPassableTest() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));

        assertThat(bridge.isCrossed("U", 0)).isTrue();
        assertThat(bridge.isCrossed("U", 1)).isFalse();
        assertThat(bridge.isCrossed("D", 2)).isFalse();
    }

    @DisplayName("다리와 사용자가 건넌 다리가 같을때, 반환값 테스트")
    @Test
    void isSameBridgeTest() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        List<String> copyBridge = new ArrayList<>(List.of("U", "D", "U"));
        List<String> nonCopyBridge = new ArrayList<>(List.of("U", "D", "D"));

        assertThat(bridge.isSame(copyBridge)).isTrue();
        assertThat(bridge.isSame(nonCopyBridge)).isFalse();
    }

    @Override
    protected void runMain() {

    }
}
