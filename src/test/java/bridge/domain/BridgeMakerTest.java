package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("다리 생성에 대한 검증")
class BridgeMakerTest {

    @Test
    void 랜덤으로_생성된_값이_0인_경우() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        String result = bridgeMaker.convertNumberToDirection(0);
        Assertions.assertThat(result).isEqualTo(Direction.DOWN.getValue());
    }

    @Test
    void 랜덤으로_생성된_값이_1인_경우() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        String result = bridgeMaker.convertNumberToDirection(1);
        Assertions.assertThat(result).isEqualTo(Direction.UP.getValue());
    }
}