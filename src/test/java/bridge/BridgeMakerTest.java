package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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