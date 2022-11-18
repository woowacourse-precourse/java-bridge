package bridge.game;

import static bridge.constant.BridgeConstants.DOWN_SIDE;
import static bridge.constant.BridgeConstants.UP_SIDE;
import static org.assertj.core.api.Assertions.*;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeMakerTest {

    @ParameterizedTest
    @DisplayName(" Bridge가 정상적으로 생성되었는지 확인한다.")
    @ValueSource(ints = {3,4,5,10,20})
    public void checkResultGeneratedByBridgeMaker(int size) throws Exception{
        //given
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        //when
        List<String> bridge = bridgeMaker.makeBridge(size);

        //then
        assertThat(bridge.size()).isEqualTo(size);
        assertThat(bridge.stream().allMatch(value -> value.equals(UP_SIDE) || value.equals(DOWN_SIDE))).isEqualTo(true);
    }
}
