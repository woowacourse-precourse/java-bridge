package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.util.Constant;
import org.junit.jupiter.api.Test;

public class UpsideBridgeRenderingTest {

    @Test
    void 위쪽_다리_건너기_성공_위쪽_다리_표현() {
        assertThat(UpsideBridgeRendering.renderUpsideBridge("U", true))
                .isEqualTo(Constant.SUCCESS);
    }

    @Test
    void 위쪽_다리_건너기_실패_위쪽_다리_표현() {
        assertThat(UpsideBridgeRendering.renderUpsideBridge("U", false))
                .isEqualTo(Constant.FAIL);
    }

    @Test
    void 아래쪽_다리_건너기_성공_위쪽_다리_표현() {
        assertThat(UpsideBridgeRendering.renderUpsideBridge("D", true))
                .isEqualTo(Constant.BLANK);
    }

    @Test
    void 아래쪽_다리_건너기_실패_위쪽_다리_표현() {
        assertThat(UpsideBridgeRendering.renderUpsideBridge("D", false))
                .isEqualTo(Constant.BLANK);
    }
}
