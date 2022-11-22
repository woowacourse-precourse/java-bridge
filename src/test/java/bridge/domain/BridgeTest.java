package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.bridge.Bridge;
import bridge.utils.Converter;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    private BridgeMaker bridgeMaker;
    private Bridge bridge;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("주어진 메소드를 통해 다리를 생성한다.")
    @Test
    void create_Bridge() {
        final int bridgeSize = 5;

        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));

        assertThat(bridge).isNotNull();
    }

    @DisplayName("올바른 다리 값이 생성된 경우 정상 작동한다.")
    @Test
    void create_legalBridge() {
        List<Integer> list = Arrays.asList(1, 0, 0, 1, 0);

        bridge = new Bridge(Converter.getSituationThrough(list));

        assertThat(bridge).isNotNull();
    }

    @DisplayName("잘못된 다리 값이 생성된 경우 IllegalArgumentException 이 발생한다.")
    @Test
    void create_illegalBridge() {
        List<Integer> list = Arrays.asList(4, 2, 0, 1, 0);

        assertThatThrownBy(() -> new Bridge(Converter.getSituationThrough(list)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");

    }
}