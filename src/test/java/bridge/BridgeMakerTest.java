package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @DisplayName("랜덤값을 원하는 길이만큼 생성하는지 테스트")
    @Test
    public void makeBridgeLengthTest() {
        //given
        int size = 10;

        //when
        List<String> bridge = bridgeMaker.makeBridge(size);

        //then
        assertThat(bridge.size()).isEqualTo(size);
    }

    @DisplayName("생성된 bridge가 U와 D로만 이루어져 있는지 테스트")
    @Test
    public void convertUpOrDown() {
        //given
        int size = 10;
        List<String> list = List.of("U", "D");

        //when
        List<String> bridge = bridgeMaker.makeBridge(size);

        //then
        bridge.stream().map(i -> assertThat(list.contains(i)).isEqualTo(true));
    }
}