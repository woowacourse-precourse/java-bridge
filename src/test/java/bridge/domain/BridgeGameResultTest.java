package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.BridgeGameResult;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameResultTest {
    private BridgeGameResult bridgeGameResult;

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
        assertThat(bridgeGameResult.isSuccess()).isTrue();
    }

    @Test
    void 결과_리스트_초기화_테스트() {
        bridgeGameResult.clear();
        assertThat(bridgeGameResult.getUpBridge().size()).isEqualTo(0);
        assertThat(bridgeGameResult.getDownBridge().size()).isEqualTo(0);
        assertThat(bridgeGameResult.isSuccess()).isTrue();
    }

    @Test
    void 이동_결과_변환_테스트() {
        boolean trueInput = bridgeGameResult.getComparison("O");
        assertThat(trueInput).isEqualTo(true);
        boolean falseInput = bridgeGameResult.getComparison("X");
        assertThat(falseInput).isEqualTo(false);
    }
}