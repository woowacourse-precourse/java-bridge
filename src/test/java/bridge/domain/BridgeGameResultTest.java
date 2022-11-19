package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.BridgeGameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameResultTest {

    private final BridgeGameResult gameResult = new BridgeGameResult();

    @DisplayName("게임 시도 횟수를 증가시킨다.")
    @Test
    void checkIncreaseTryCount() {
        int actual = gameResult.increaseTryCount();
        assertThat(actual).isEqualTo(2);
    }
}
