package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.util.Constants.Constant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DownBridgeRenderingTest {


    @ValueSource(booleans = {true, false})
    @ParameterizedTest
    void 다리_모양_공백(boolean input) {
        assertThat(DownBridgeRendering.renderDownBridge(Constant.UPSIDE, input)).isEqualTo(Constant.BLANK);
    }

    @Test
    void 다리_모양_성공() {
        assertThat(DownBridgeRendering.renderDownBridge(Constant.DOWN, true)).isEqualTo(Constant.SUCCESS);
    }

    @Test
    void 다리_모양_실패() {
        assertThat(DownBridgeRendering.renderDownBridge(Constant.DOWN, false)).isEqualTo(Constant.FAIL);
    }
}
