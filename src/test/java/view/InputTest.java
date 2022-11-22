package view;

import bridge.domain.BridgeGame;
import bridge.exception.InputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class InputTest {

    @DisplayName("다리생성입력_숫자아니면_실패")
    @ValueSource(strings = {"a", "b", "!"})
    @ParameterizedTest()
    void 다리생성_입력_숫자_실패_테스트(String size) {
        assertThatThrownBy(() -> InputException.validateInputLength(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리생성입력_숫자이면_성공")
    @ValueSource(strings = {"5", "10", "20"})
    @ParameterizedTest()
    void 다리생성_입력_숫자_성공_테스트(String size) {
        assertThatNoException().isThrownBy(() -> InputException.validateInputLength(size));
    }

    @DisplayName("다리생성입력_숫자범위_실패")
    @ValueSource(strings = {"0", "2", "21"})
    @ParameterizedTest()
    void 다리생성_입력_숫자범위_실패_테스트(String size) {
        assertThatThrownBy(() -> InputException.validateInputLength(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리생성입력_숫자범위_성공")
    @ValueSource(strings = {"5", "12", "19"})
    @ParameterizedTest()
    void 다리생성_입력_숫자범위_성공_테스트(String size) {
        assertThatNoException().isThrownBy(() -> InputException.validateInputLength(size));
    }

    @DisplayName("이동명령어_입력_실패")
    @ValueSource(strings = {"u", "d", "c"})
    @ParameterizedTest()
    void 이동명령어_입력_실패_테스트(String size) {
        assertThatThrownBy(() -> InputException.validateInputLength(size))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
