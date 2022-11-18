package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    @Test
    @DisplayName("다리 생성 테스트")
    public void makeBridgeTest() {
        // given
        int size = 3;

        // when
        List<String> bridge = bridgeMaker.makeBridge(size);

        // then
        assertThat(bridge.size()).isEqualTo(size);
    }

    @Test
    @DisplayName("isDown 테스트")
    public void isDownTest() {
        // given
        int number = 0;

        // when
        boolean result = bridgeMaker.isDown(number);

        // then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("generatorNumber 테스트")
    public void generatorNumberTest() {
        // given
        List<Integer> resultList = List.of(0, 1);

        // when
        int result = bridgeMaker.generatorNumber(() -> bridgeRandomNumberGenerator.generate());

        // then
        assertThat(resultList.contains(result)).isEqualTo(true);
    }
}
