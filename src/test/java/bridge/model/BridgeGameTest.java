package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameTest {

    @DisplayName("재시도 시 사용자 상태 초기화, 시도 횟수 증가")
    @ParameterizedTest
    @ValueSource(ints = {3, 7, 14, 20})
    void retry(int bridgeSize) {
        BridgeGame bridgeGame = new BridgeGame(bridgeSize, new BridgeMaker(new BridgeRandomNumberGenerator()));
        bridgeGame.retry();

        assertThat(bridgeGame.getTrialCount()).isEqualTo(2);
    }
}