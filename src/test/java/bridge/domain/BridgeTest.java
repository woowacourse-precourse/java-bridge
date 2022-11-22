package bridge.domain;

import static bridge.utils.Constant.DOWN;
import static bridge.utils.Constant.UP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {
    Bridge bridge = new Bridge("3");

    @DisplayName("현재 스텝의 성공 여부를 저장")
    @Test
    void checkNowGoodMove() {
        List<BridgeResult> bridgeResults = new ArrayList<>();
        bridgeResults.add(new BridgeResult("up",true));
        boolean result = bridge.nowGoodMove(bridgeResults);

        assertThat(result).isEqualTo(true);
    }

    @DisplayName("스텝이 bridge 사이즈보다 작은지 여부 저장")
    @Test
    void checkNotOverStep() {
        boolean result = bridge.notOverStep();
        assertThat(result).isEqualTo(true);
    }

}
