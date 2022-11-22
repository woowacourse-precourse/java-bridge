package bridge.view.constant;

import static bridge.view.constant.BridgeShape.PREFIX_BRIDGE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BridgeShapeTest {

    @Test
    void 다리그림을_그리는데_필요한_모양_출력성공() throws Exception {
        assertThat(PREFIX_BRIDGE.getShape()).isEqualTo("[");
    }

}