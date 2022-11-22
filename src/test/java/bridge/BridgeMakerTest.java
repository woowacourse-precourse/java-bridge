package bridge;

import bridge.domain.BridgeMaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {

    private BridgeNumberGenerator numberGenerator;
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        numberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(numberGenerator);
    }

    @ParameterizedTest
    @CsvSource("3, 3, 10, 10, 20, 20")
    void 다리_길이_테스트(int size, int expected) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        int actual = bridge.size();
        assertThat(actual).isEqualTo(expected);
    }
}
