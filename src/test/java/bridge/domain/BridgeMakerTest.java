package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {
    BridgeMaker bridgeMaker;
    @BeforeEach
    void setup(){
        bridgeMaker=new BridgeMaker(new BridgeRandomNumberGenerator());
    }
    @Test
    @DisplayName("입력받은 다리 길이만큼 랜덤하게 다리가 생성되었는지 확인")
    void makeBridge(){
        int bridgeSize=13;
        assertThat(bridgeMaker.makeBridge(bridgeSize).size()).isEqualTo(bridgeSize);
    }
    @Test
    @DisplayName("다리의 위 아래를 생성할 때 0을 넘기면 D가 반환되는지 확인")
    void generateDown(){
        assertThat(bridgeMaker.generateUpDown(0)).isEqualTo("D");
    }
    @Test
    @DisplayName("다리의 위 아래를 생성할 때 1을 넘기면 R이 반환되는지 확인")
    void generateUp(){
        assertThat(bridgeMaker.generateUpDown(1)).isEqualTo("U");
    }
}