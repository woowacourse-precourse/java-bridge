package bridge.model;

import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeMakerTest {
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void beforeEach() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }


    @Test
    @DisplayName("다리 생성 성공")
    void case1() {
        int bridgeSize = 13;
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        assertThat(bridge.size()).isEqualTo(bridgeSize);
    }

    @Test
    @DisplayName("다리 생성 실패: BridgeSize 유효하지 않음")
    void case2() {
        int bridgeSize = 1_000;
        assertThatThrownBy(() -> bridgeMaker.makeBridge(bridgeSize)).isInstanceOf(IllegalArgumentException.class);
    }

}
