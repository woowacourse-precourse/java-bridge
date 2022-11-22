package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.BridgeMaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMakerTest {
    private final int MINIMUM_NUMBER = 1;
    private final int MAXIMUM_NUMBER = 45;
    private BridgeMaker bridgeMaker;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;

    @BeforeEach
    void setUp() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    @Test
    void 다리_만들기_테스트() {
        assertThat(bridgeMaker.makeBridge(3)).containsAnyOf("U", "D");
    }

    @Test
    void 랜덤_숫자_생성_테스트() {
        int input = bridgeMaker.createRandomNumber();
        assertThat(input).isGreaterThan(MINIMUM_NUMBER - 1)
                .isLessThan(MAXIMUM_NUMBER + 1);
    }

    @ParameterizedTest
    @CsvSource({"0,D", "1,U"})
    void 다리_위치_획득_테스트(int randomNumber, String sign) {
        String input = bridgeMaker.getBridgeSide(randomNumber);
        assertThat(input).isEqualTo(sign);
    }
}