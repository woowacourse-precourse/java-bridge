package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void beforeEach() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    @DisplayName("다리 만들기: 다리의 길이가 주어진 길이와 같아야 함")
    void givenBridgeLength_whenMakeBridge_thenSizeEqualsToBridgeLength() {
        int test = 5;
        assertThat(bridgeMaker.makeBridge(test).size()).isEqualTo(test);
    }

    @Test
    @DisplayName("다리 만들기: 만들어진 다리는 U나 D로만 이루어져야 함")
    void givenBridgeLength_whenMakeBridge_thenListOnlyContainsUOrD() {
        int test = 15;
        List<String> bridge = bridgeMaker.makeBridge(test);
        boolean expect = bridge.stream().allMatch(s -> s.equals("U") || s.equals("D"));
        assertThat(expect).isTrue();
    }
}
