package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

public class BridgeRandomNumberGeneratorTest {

    @RepeatedTest(100)
    void 랜덤_숫자_0과_1사이_확인() {
        //given
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

        //when
        int randNumber = bridgeRandomNumberGenerator.generate();

        //then
        assertThat(randNumber).isBetween(0, 1);
    }
}
