package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp(){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    @DisplayName("size 입력 개수만큼 bridge 생성")
    @Test
    void makeBridgeAsManyAsInput() {
        List<String> result = bridgeMaker.makeBridge(3);
        assertThat(result.size()).isEqualTo(3);
    }

    @DisplayName("1을 U로 변환")
    @Test
    void convert1ToU(){
        String result = bridgeMaker.convertToBridge(1);
        assertThat(result).isEqualTo("U");
    }

    @DisplayName("0을 D로 변환")
    @Test
    void convert0ToD(){
        String result = bridgeMaker.convertToBridge(0);
        assertThat(result).isEqualTo("D");
    }
}