package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {


    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);


    @DisplayName("특정 사이즈를 입력했을 때 해당 길이의 사이즈를 가진 다리 반환")
    @Test
    void givenBridgeSize_whenMakeBridge_thenReturnBridgeOfParticularSize() {
        //Given
        int size = 10;

        //When
        List<String> bridge = bridgeMaker.makeBridge(size);

        //Then
        assertThat(bridge.size()).isEqualTo(size);
    }

    @DisplayName("특정 사이즈를 입력했을 때 다리는 U 또는 D로만 채워져 있다.")
    @Test
    void givenBridgeSize_whenMakeBridge_thenReturnBridgeWithoutBlank() {
        //Given
        int size = 10;

        //When
        List<String> bridge = bridgeMaker.makeBridge(size);

        //Then
        assertThat(bridge).containsOnly("U", "D");
    }
}
