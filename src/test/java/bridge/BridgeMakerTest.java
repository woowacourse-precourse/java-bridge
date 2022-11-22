package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {
    @Test
    void 타입바꾸기_테스트1() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        String output = bridgeMaker.changeTypeMovableSpace(1);
        String result = "U";
        assertThat(output).isEqualTo(result);
    }
    @Test
    void 타입바꾸기_테스트2() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        String output = bridgeMaker.changeTypeMovableSpace(0);
        String result = "D";
        assertThat(output).isEqualTo(result);
    }
    @Test
    void 타입바꾸기_예외_테스트3() {
        try {
            BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
            String output = bridgeMaker.changeTypeMovableSpace(3);
            String result = "D";
            assertThat(output).isEqualTo(result);
        } catch (IllegalArgumentException e) {
            assertThat("잘못된 숫자가 생성되었습니다.").isEqualTo(e.getMessage());
        }
    }

}