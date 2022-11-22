package bridge.model;

import bridge.utils.BridgeStep;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("게임 진행과 관련해")
class BridgeGameTest {
    @ParameterizedTest
    @CsvSource(value = {"R:true", "Q:false"}, delimiter = ':')
    @DisplayName("게임 재시작 시 R을 입력하면 재시작 가능")
    void retryTest(String command, boolean isRetry) {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of(BridgeStep.UP.getStep(), BridgeStep.UP.getStep(), BridgeStep.UP.getStep(), BridgeStep.UP.getStep())));
        assertThat(bridgeGame.retry(command)).isEqualTo(isRetry);
    }
}