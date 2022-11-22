package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.util.Constants.Constant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UpsideBridgeRenderingTest {

    @ValueSource(booleans = {true, false})
    @ParameterizedTest
    void 위쪽_다리_모양_공백(boolean input) {
        assertThat(UpsideBridgeRendering.renderUpsideBridge(Constant.DOWN, input)).isEqualTo(Constant.BLANK);
    }

    @Test
    void 위쪽_다리_모양_성공() {
        assertThat(UpsideBridgeRendering.renderUpsideBridge(Constant.UPSIDE, true))
                .isEqualTo(Constant.SUCCESS);
    }

    @Test
    void 위쪽_다리_모양_실패() {
        assertThat(UpsideBridgeRendering.renderUpsideBridge(Constant.UPSIDE, false))
                .isEqualTo(Constant.FAIL);
    }
}
