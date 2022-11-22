package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    @DisplayName("입력받은 길이에 해당하는 다리를 생성한다.의 원하는 크기가 만들어지는지 테스트")
    @Test
    void makeBridgeSizeTest1() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        assertThat(bridgeMaker.makeBridge(5).size())
                .isEqualTo(5);
    }
}