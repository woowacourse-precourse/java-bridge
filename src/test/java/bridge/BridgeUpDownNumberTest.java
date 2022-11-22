package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.common.BridgeGameConstants.DOWN;
import static bridge.common.BridgeGameConstants.UP;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeUpDownNumberTest {

    BridgeUpDownNumber bridgeUpDownNumber;

    @BeforeEach()
    void init(){
        bridgeUpDownNumber = new BridgeUpDownNumber();
    }

    @Test
    @DisplayName("사용자 input 에 대한 값을 정수로 변환하는 테스트")
    void 사용자_입력_숫자로_변환_테스트1() {

        String userInput = UP;
        int test = bridgeUpDownNumber.upOrDown(userInput);

        assertThat(test).isEqualTo(0);

    }

    @Test
    @DisplayName("사용자 input 에 대한 값을 정수로 변환하는 테스트")
    void 사용자_입력_숫자로_변환_테스트2() {

        String userInput = DOWN;
        int test = bridgeUpDownNumber.upOrDown(userInput);

        assertThat(test).isEqualTo(1);

    }

}