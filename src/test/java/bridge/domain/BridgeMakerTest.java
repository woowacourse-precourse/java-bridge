package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
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
        final String DOWN_SIDE = "D";
        final String UP_SIDE = "U";

        //when
        List<String> bridge = bridgeMaker.makeBridge(size);

        //then
        assertThat(bridge.size()).isEqualTo(size);
        assertThat(bridge.stream().allMatch(value -> value.equals(DOWN_SIDE) || value.equals(UP_SIDE))).isEqualTo(true);
    }
}
