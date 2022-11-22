package bridge;

import static bridge.BridgeMaker.toInt;
import static bridge.BridgeMaker.validateBridgeSizeRange;
import static bridge.BridgeMaker.validateBridgeSizeType;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge).containsExactly("U", "D", "D", "U", "U");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "한글", "00a", "1000j", "-1"})
    void 자연수가_아닌_입력(String input) {
        assertThatThrownBy(() -> validateBridgeSizeType(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2_222_222_222", "2222222222"})
    void int_범위를_초과한_입력(String input) {
        assertThatThrownBy(() -> toInt(input))
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 21, 22})
    void 다리_길이_범위를_초과한_입력(int size) {
        assertThatThrownBy(() -> validateBridgeSizeRange(size))
                .isInstanceOf(IllegalArgumentException.class);
    }


}