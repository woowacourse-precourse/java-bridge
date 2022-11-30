package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.constant.Const.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void beforeEach() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    @DisplayName("다리를 만드는 기능")
    void makeBridge() {
        // given
        List<String> bridge = bridgeMaker.makeBridge(20);

        // then
        assertThat(bridge.size()).isEqualTo(20);
        assertThat(bridge.stream().allMatch(step -> step.equals(UP) || step.equals(DOWN))).isTrue();
    }
}
