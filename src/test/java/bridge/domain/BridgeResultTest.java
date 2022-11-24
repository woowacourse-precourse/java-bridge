package bridge.domain;


import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeResultTest {

    @DisplayName("선택한 방향과 결과를 문자열로 넣는다")
    @Test
    void putUpBridge() {
        BridgeResult bridgeResult = new BridgeResult();
        bridgeResult.putResult(BridgeDirection.UP, Answer.RIGHT);

        List<String> upBridge = bridgeResult.getUpBridge();

        assertThat(upBridge.get(0)).isEqualTo("O");
    }

    @DisplayName("선택한 방향과 결과를 문자열로가 넣는다")
    @Test
    void putDownBridge() {
        BridgeResult bridgeResult = new BridgeResult();
        bridgeResult.putResult(BridgeDirection.DOWN, Answer.WRONG);

        List<String> downBridge = bridgeResult.getDownBridge();

        assertThat(downBridge.get(0)).isEqualTo("X");
    }

}