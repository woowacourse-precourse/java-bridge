package bridge;

import org.junit.jupiter.api.DisplayName;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest extends NsTest {

    @DisplayName("입력된 숫자가 3-20 범위 안에 있는지 확인 하는 테스트")
    @ValueSource(ints = {1, 21, -10})
    @ParameterizedTest
    void 범위_테스트(int input) {
        assertThatThrownBy(() -> InputView.rangeCheck(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 인풋이 숫자가 아닌 문자열일 경우 Exception 발생")
    @ValueSource(strings = {"It", "Is", "Wrong"})
    @ParameterizedTest
    void 숫자_테스트(String input) {
        assertThatThrownBy(() -> InputView.isNumeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 인풋이 U 혹은 D가 아닐 경우 Exception 발생")
    @ValueSource(strings = {"A", "d", "u", "!", "-1"})
    @ParameterizedTest
    void 위아래_테스트(String input) {
        assertThatThrownBy(() -> InputView.upOrDownCheck(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 인풋이 R 혹은 Q가 아닐 경우 Exception 발생")
    @ValueSource(strings = {"B", "q", "r", "@", "-100"})
    @ParameterizedTest
    void 재시작_종료_테스트(String input) {
        assertThatThrownBy(() -> InputView.redoOrQuitCheck(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    protected void runMain() {}
}
