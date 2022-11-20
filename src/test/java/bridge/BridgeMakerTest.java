package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {
    private static final int DOWN_NUM = 0;
    private static final int UP_NUM = 1;
    private static final String DOWN = "D";
    private static final String UP = "U";

    BridgeMaker bridgeMaker;
    BridgeNumberGenerator bridgeNumberGenerator;
    int size;

    @BeforeEach
    void init() {
        size = 5;
    }

    @DisplayName("아래로만 갈 수 있는 다리 생성")
    @Test
    void makeDownBridge() {
        bridgeNumberGenerator = new TestBridgeNumberGenerator(DOWN_NUM);
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        List<String> output = bridgeMaker.makeBridge(size);
        assertThat(output).hasSize(size)
                .contains(DOWN)
                .doesNotContain(UP);
    }

    @DisplayName("위로만 갈 수 있는 다리 생성")
    @Test
    void makeUpBridge() {
        bridgeNumberGenerator = new TestBridgeNumberGenerator(UP_NUM);
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        int size = 5;
        List<String> output = bridgeMaker.makeBridge(size);
        assertThat(output).hasSize(size)
                .contains(UP)
                .doesNotContain(DOWN);
    }

    @DisplayName("다리 길이 성공 테스트")
    @ValueSource(ints = {3, 4, 10, 15, 20})
    @ParameterizedTest
    void validSizeTest(int input) {
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        List<String> output = bridgeMaker.makeBridge(input);
        assertThat(output).hasSize(input);
    }

    @DisplayName("다리 길이 예외 테스트")
    @ValueSource(ints = {0, -1, 2, 21, 25})
    @ParameterizedTest
    void invalidSizeTest(int input) {
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        assertThatThrownBy(() -> bridgeMaker.makeBridge(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

class TestBridgeNumberGenerator implements BridgeNumberGenerator {

    private final int num;

    public TestBridgeNumberGenerator(int num) {
        this.num = num;
    }

    @Override
    public int generate() {
        return num;
    }
}