package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import bridge.domain.Bridge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeTest {

    int size;
    Bridge bridge;
    BridgeRandomNumberGenerator bridgeNumberGenerator;

    @BeforeEach
    void setUp() {
        size = 3;
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridge = new Bridge(3, bridgeNumberGenerator);
    }

    @Test
    void 다리_생성_길이_테스트() {
        assertThat(bridge.get().size()).isEqualTo(3);
    }

    @DisplayName("다리길이가 3 보다 작거나 20보다 크다면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,21,100})
    void 다리길이_예외_테스트(int size) {
        assertThatThrownBy(()-> new Bridge(size, bridgeNumberGenerator))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]다리길이는 3보다 작거나 20보다 클 수 없습니다.");
    }

}
