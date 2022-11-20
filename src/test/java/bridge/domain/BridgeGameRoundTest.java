package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameRoundTest {

    @ParameterizedTest(name = "[{index}] maxRound = {0}")
    @ValueSource(ints = {0, 1, 10, 30, 50, 100})
    @DisplayName("여러 번의 다음 라운드가 진행되고 진행된 라운드 수를 확인을 성공한다.")
    void whenNextRoundAndCheckThenSuccessTest(int maxRound) {
        // given
        BridgeGameRound bridgeGameRound = new BridgeGameRound();

        // when
        for (int next = 0; next < maxRound; next++) {
            bridgeGameRound.nextRound();
        }
        int currentRound = bridgeGameRound.checkRound();

        // then
        assertThat(currentRound).isEqualTo(maxRound + 1);
    }
}