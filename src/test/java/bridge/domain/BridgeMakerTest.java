package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeMakerTest {
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @DisplayName("숫자가 아닌 input 에러 테스트")
    @Test
    void 숫자_아닌_경우_에러_테스트(){
        String input = "숫자아님";
        assertThatThrownBy(() -> bridgeMaker.getSizeInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위에서 벗어난 경우 에러 테스트")
    @ValueSource(strings = {"2", "-5", "31"})
    @ParameterizedTest
    void 범위_벗어난_경우_에러_테스트(Integer input){
        assertThatThrownBy(() -> bridgeMaker.makeBridge(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 생성 테스트")
    @Test
    void 다리_생성_테스트(){
        int input = 5;
        assertEquals(5,
                bridgeMaker.makeBridge(5).size());
    }
}
