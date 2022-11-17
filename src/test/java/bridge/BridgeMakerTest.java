package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {

    BridgeNumberGenerator bridgeNumberGenerator;

    @BeforeEach
    void beforeEach() {
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    }

    @DisplayName("생성한 다리의 길이를 검증한다.")
    @Test
    void 다리_길이_검증() {
        // given
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        // when
        List<String> bridge = bridgeMaker.makeBridge(10);

        // then
        assertThat(bridge.size()).isEqualTo(10);
    }

}
