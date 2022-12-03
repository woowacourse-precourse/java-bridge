package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    static BridgeMaker bridgeMaker;

    @BeforeAll
    static void init() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 20})
    @DisplayName("원하는 크기로 다리가 제대로 만들어졌는지 테스트")
    void bridge_size_is_desired_size(Integer desiredSize) {
        // given

        // when
        List<String> bridge = bridgeMaker.makeBridge(desiredSize);

        // then
        assertThat(bridge.size()).isEqualTo(desiredSize);
    }

}