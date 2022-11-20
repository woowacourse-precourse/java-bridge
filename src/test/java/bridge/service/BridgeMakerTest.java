package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.service.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {
    BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @ParameterizedTest
    @DisplayName("다리의 길이를 입력받을 때 길이가 3 미만, 20 초과이면 예외가 발생해야 한다.")
    @ValueSource(ints = {2, 21})
    void makeBridgeByUnder3OrOver20Size(int size) {
        //expect
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리의 길이를 입력받을 때 정상적으로 생성되어야 한다.")
    void makeBridge() {
        // given
        int size = 3;

        // when
        List<String> bridge = bridgeMaker.makeBridge(size);

        // then
        assertThat(bridge.size())
                .isEqualTo(3);
    }
}