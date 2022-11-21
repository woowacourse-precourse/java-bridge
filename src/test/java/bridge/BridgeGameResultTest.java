package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameResultTest {
    BridgeGameResult bridgeGameResult;

    @BeforeEach
    void setUp() {
        bridgeGameResult = new BridgeGameResult();
    }

    @Test
    void 다리_건너기_결과_리스트_테스트() {
        bridgeGameResult.addResult("U", "O");
        bridgeGameResult.addResult("D", "O");
        bridgeGameResult.addResult("D", "O");

        assertThat(bridgeGameResult.getUpBridge()).isEqualTo(Arrays.asList("O", " ", " "));
        assertThat(bridgeGameResult.getDownBridge()).isEqualTo(Arrays.asList(" ", "O", "O"));
        assertThat(bridgeGameResult.getSuccess()).isTrue();
    }

    @Test
    void 결과_리스트_초기화_테스트() {
        bridgeGameResult.clear();
        assertThat(bridgeGameResult.getUpBridge().size()).isEqualTo(0);
        assertThat(bridgeGameResult.getDownBridge().size()).isEqualTo(0);
        assertThat(bridgeGameResult.getSuccess()).isTrue();
    }
}