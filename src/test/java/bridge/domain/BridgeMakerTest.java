package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void init() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("다리 생성 성공")
    @Test
    void makeBridge() {
        List<String> actual = bridgeMaker.makeBridge(3);
        assertThat(actual).contains("U", "D");
    }

    @DisplayName("다리 길이의 범위가 3~20이 아니면 예외 발생")
    @ValueSource(ints = {1, -1, 21})
    @ParameterizedTest
    void makeBridgeOutOfRange(int input) {
        assertThatThrownBy(() -> bridgeMaker.makeBridge(input)).isInstanceOf(
            IllegalStateException.class);
    }
}
