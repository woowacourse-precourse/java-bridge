package bridge.rule;

import static bridge.util.Constant.*;
import static bridge.util.Constant.DOWNLOCATION;
import static bridge.util.Constant.UPLOCATION;
import static org.assertj.core.api.Assertions.*;

import bridge.domain.Bridge;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EndRuleTest {

    @Test
    @DisplayName("최종결과가 다리의 마지막 지점이면 성공")
    void 성공_테스트() {
        Bridge bridge = new Bridge(4, List.of(UPLOCATION, UPLOCATION, DOWNLOCATION, DOWNLOCATION));
        String result = EndRule.isComplete(bridge);
        assertThat(result).isEqualTo(COMPLETE);
    }

    @Test
    @DisplayName("최종결과가 다리의 마지막 지점이 아니면 실패")
    void 실패_테스트() {
        Bridge bridge = new Bridge(3, List.of(UPLOCATION, UPLOCATION, DOWNLOCATION, DOWNLOCATION));
        String result = EndRule.isComplete(bridge);
        assertThat(result).isEqualTo(FAIL);
    }

    @Test
    void 종료_판단_테스트() {
        boolean isQuit = EndRule.isQuit(QUIT);
        assertThat(isQuit).isTrue();
    }
}
