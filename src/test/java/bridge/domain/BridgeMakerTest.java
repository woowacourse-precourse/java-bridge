package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeMaker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("다리 생성에 대한 검증")
class BridgeMakerTest {

    @Test
    void 랜덤으로_생성된_값이_0인_경우() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        String result = bridgeMaker.convertNumberToDirection(0);
        Assertions.assertThat(result).isEqualTo(BridgeMaker.DOWN);
    }

    @Test
    void 랜덤으로_생성된_값이_1인_경우() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        String result = bridgeMaker.convertNumberToDirection(1);
        Assertions.assertThat(result).isEqualTo(BridgeMaker.UP);
    }

    @ParameterizedTest(name = "랜덤으로 생성된 값이 {0}일 때 예외처리")
    @ValueSource(ints = {2,3,4,5,6})
    void 랜덤으로_생성된_값에_오류가_있는_경우(int generateNum) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Assertions.assertThatThrownBy(() -> bridgeMaker.convertNumberToDirection(generateNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 랜덤으로 생성된 숫자에 오류가 있습니다.");
    }
}