import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class BridgeMakerTest {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @DisplayName("입력한 길이의 문자열 리스트 반환")
    @Test
    void makeBridgeSizeTest() {
        List<String> result = bridgeMaker.makeBridge(10);
        Assertions.assertThat(result.size()).isEqualTo(10);
    }

    @DisplayName("다리에는 U가 포함된다")
    @Test
    void bridgeContainsWordU() {
        List<String> result = bridgeMaker.makeBridge(10);
        Assertions.assertThat(result).contains("U");
    }

    @DisplayName("다리에는 D가 포함된다")
    @Test
    void bridgeContainsWordD() {
        List<String> result = bridgeMaker.makeBridge(10);
        Assertions.assertThat(result).contains("D");
    }

    @DisplayName("다리에 U,D를 제외한 나머지는 포함되지 않는다")
    @Test
    void bridgeContainsOnlyUD() {
        List<String> result = bridgeMaker.makeBridge(10);
        Assertions.assertThat(result).containsOnly("D", "U");
    }
}