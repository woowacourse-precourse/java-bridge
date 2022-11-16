package bridge.service;

import static org.assertj.core.api.Assertions.*;

import bridge.util.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    @DisplayName("다리의 길이를 입력받을 때 길이가 3 미만이면 예외가 발생한다.")
    void receiveBridgeLengthByUnder3() {
        // given
        int size = 2;
        //expect
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리의 길이를 입력받을 때 길이가 20 초과이면 예외가 발생한다.")
    void receiveBridgeLengthByOver20() {
        // given
        int size = 21;
        //expect
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }
}