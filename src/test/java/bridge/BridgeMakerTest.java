package bridge;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    BridgeMaker bridgeMaker;

    @BeforeEach
    void setUP() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("다리 길이 입력하면 그 길이에 맞는 다리가 생성")
    @Test
    void makeBridge() {
        int bridgeSize = 3;

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        System.out.println(bridge);
        assertThat(bridge.size()).isEqualTo(3);
    }
}