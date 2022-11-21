package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    @Test
    @DisplayName("다리 길이만큼 생성 잘 되는지 테스트")
    void makeBridgeTest(){
        //Given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = 3;

        //When
        List<String> bridge = bridgeMaker.makeBridge(size);

        //Then
        assertThat(bridge.size()).isEqualTo(size);

    }

}