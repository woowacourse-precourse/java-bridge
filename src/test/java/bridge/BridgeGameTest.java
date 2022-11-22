package bridge;

import bridge.Domain.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {
    BridgeGame bridgeGame;
    @BeforeEach
    void 선언부() {
        bridgeGame = new BridgeGame();
    }

    @ParameterizedTest
    @CsvSource(value = {"R:true","Q:false"}, delimiter = ':')
    void 재시작_기능_테스트(String input, boolean answer) {
        assertThat(bridgeGame.retry(input)).isEqualTo(answer);
    }
}