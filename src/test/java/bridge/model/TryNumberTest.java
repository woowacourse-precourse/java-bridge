package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryNumberTest {
    @DisplayName("첫시도에 성공시 올바른 시도횟수를 반환한다.")
    @Test
    void createTryNumberByFirstTry() {
        TryNumber tryNumber = new TryNumber();
        assertThat(tryNumber.getTryNumber()).isEqualTo(1);
    }

    @DisplayName("세번 시도했을 시 올바른 시도횟수를 반환한다.")
    @Test
    void createTryNumberThirdTry() {
        TryNumber tryNumber = new TryNumber();
        BridgeGame bridgeGame = new BridgeGame();
        for (int count = 0; count < 2; count++) {
            bridgeGame.retry(tryNumber);
        }
        assertThat(tryNumber.getTryNumber()).isEqualTo(3);
    }
}
