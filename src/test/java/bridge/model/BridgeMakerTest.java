package bridge.model;

import bridge.constant.ErrorMessage;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {

    public static final int GENERATED_NUMBER = 0;

    BridgeNumberGenerator numberGenerator;
    BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        numberGenerator = new BridgeTestNumberGenerator(Lists.newArrayList(0, 1, 1));
        bridgeMaker = new BridgeMaker(numberGenerator);
    }

    @DisplayName("다리 생성 테스트")
    @Test
    void createBridgeTest() {
        List<String> bridge = bridgeMaker.makeBridge(3);

        assertThat(bridge).containsExactly("D", "U", "U");
    }

    @DisplayName("다리 길이 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 21})
    void createBridgeSizeError(int bridgeSize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> bridgeMaker.makeBridge(bridgeSize))
                .withMessage(ErrorMessage.INVALID_BRIDGE_SIZE_RANGE);
    }

    static class BridgeTestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        public BridgeTestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(GENERATED_NUMBER);
        }
    }
}