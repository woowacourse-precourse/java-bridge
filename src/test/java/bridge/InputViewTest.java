package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

class InputViewTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리 크기 값이 정수가 아닐 때의 예외 처리")
    @ValueSource(strings = {"abc", "a1c", "1.1"})
    @ParameterizedTest
    void 다리_크기_정수_입력_테스트(String input) {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> new InputView().validateBridgeSize(input)).isInstanceOf(IllegalArgumentException.class);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("다리 크기 값이 3 이상 20 이하의 자연수가 아닐 때의 예외 처리")
    @ValueSource(strings = {"2", "21", "-1"})
    @ParameterizedTest
    void 다리_크기_자연수_범위_테스트(String input) {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> new InputView().validateBridgeSize(input)).isInstanceOf(IllegalArgumentException.class);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("이동값이 U또는 D가 아닐 때의 예외처리")
    @ValueSource(strings = {"", "UD", "DU", "ABC", "u", "d"})
    @ParameterizedTest
    void 이동_문자열_테스트(String input) {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> new InputView().validateMove(input)).isInstanceOf(IllegalArgumentException.class);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
