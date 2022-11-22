package bridge.domain;

import static bridge.utils.Constant.DOWN;
import static bridge.utils.Constant.UP;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeResultTest {
    BridgeResult bridgeResult = new BridgeResult(UP, true);

    @DisplayName("위쪽 다리 이동인지 확인하는 메서드")
    @Test
    void UpMoveIsTrue() {
        boolean result = bridgeResult.isUpMove();
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("다리 이동이 성공하였는지 확인하는 메서드")
    @Test
    void SuccessMoveIsTrue() {
        boolean result = bridgeResult.isSuccessMove();
        assertThat(result).isEqualTo(true);
    }

}
