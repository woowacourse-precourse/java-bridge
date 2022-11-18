package bridge.domain.bridge.model;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class BridgeMapComponentTest {
    @Test
    public void 숫자로_생성_하는_경우_테스트() {
        int up = 1;
        int down = 0;
        SoftAssertions.assertSoftly(softAssertions -> {
                    softAssertions.assertThat(BridgeMapComponent.fromCode(up)).isEqualTo(BridgeMapComponent.UP);
                    softAssertions.assertThat(BridgeMapComponent.fromCode(down)).isEqualTo(BridgeMapComponent.DOWN);
                }
        );
    }


}