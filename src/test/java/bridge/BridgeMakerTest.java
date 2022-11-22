package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeMakerTest {
    private int bridgeSize;
    private List<String> bridgeList;

    @BeforeEach
    void beforeTestSetting() {
        bridgeSize = 10;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeList = bridgeMaker.makeBridge(bridgeSize);
    }

    @DisplayName("입력된 다리 길이만큼 다리가 생성되었는지 길이 체크")
    @Test
    void testBridgeLength() {
        Assertions.assertThat(bridgeList.size()).isEqualTo(bridgeSize);
    }

    @DisplayName("생성된 다리가 U or D 만 가지고 있는지 체크")
    @Test
    void testBridgeEntry() {
        Assertions.assertThat(bridgeList).containsOnly("U", "D");
    }
}
