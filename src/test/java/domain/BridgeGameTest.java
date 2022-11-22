package domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {

    private static BridgeMaker bridgeMaker;
    private static BridgeGame bridgeGame;

    @DisplayName("다리 생성 성공 테스트")
    @ValueSource(ints = {5, 15, 20})
    @ParameterizedTest()
    void 다리_생성_성공_테스트(int size) {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(size));

        assertThat(bridgeGame.getBridgeSize()).isEqualTo(size);
    }
}
