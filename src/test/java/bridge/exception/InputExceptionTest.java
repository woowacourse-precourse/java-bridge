package bridge.exception;

import bridge.controller.BridgeGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputExceptionTest {

    @ValueSource(strings = {"a", "adf", "]", "%"})
    @ParameterizedTest
    void 다리_길이_입력값이_숫자가_아닌_경우(String size){
        assertThatThrownBy(() -> InputException.convertToNumber(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(ints = {0,1,2,21,100})
    @ParameterizedTest
    void 다리_길이_입력값의_범위가_잘못된_경우(int size){
        assertThatThrownBy(() -> InputException.validateBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"Q", "R", "1"})
    @ParameterizedTest
    void 이동할_칸_입력값이_U_or_D_가_아닌_경우(String command){
        assertThatThrownBy(() -> InputException.validateMovingCommand(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"U", "D", "1"})
    @ParameterizedTest
    void 게임_재시작_종료_입력값이_U_or_D_가_아닌_경우(String command){
        assertThatThrownBy(() -> InputException.validateGameCommand(command))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
