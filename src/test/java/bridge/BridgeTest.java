package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

    @DisplayName("다리 길이 입력과 동일한 크기의 다리가 만들어졌는지 확인하고, 모두 U와 D로 이루어져있는지 확인한다.")
    @Test
    void 다리_정상적으로_만들어졌는지_확인() {
        int size = 3;
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridgeAnswer = bridgeMaker.makeBridge(size);
        Bridge bridge = new Bridge(bridgeAnswer);
        BridgeGame bridgeGame = new BridgeGame(bridge);

        for (String s : bridgeAnswer)
            assertThat(bridgeGame.validateMoving(s)).isEqualTo(true);
        assertThat(bridge.getBridgeSize()).isEqualTo(size);
    }

    @DisplayName("다리 길이 입력에 대해 답과 비교하여 성공 여부를 올바르게 체크하는지 확인한다.")
    @Test
    void 다리_정답과_비교해_실패여부_확인() {
        List<String> bridgeAnswer = List.of("U", "D", "D");
        Bridge bridge = new Bridge(bridgeAnswer);
        assertThat(bridge.checkAnswer("U", 1)).isEqualTo(false);
    }
}
