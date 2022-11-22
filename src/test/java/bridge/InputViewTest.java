package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest extends NsTest{
    private static final String ERROR_MESSAGE = "[ERROR]";

    @ParameterizedTest
    @ValueSource(strings = {"a", "1.2"})
    public void 다리_길이_입력_예외_형식(String input){
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ValueSource(strings = {"-1", "21", "2"})
    @ParameterizedTest
    public void 다리_길이_입력_예외_범위(String input){
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ValueSource(strings = {"1", "u", "X"})
    @ParameterizedTest
    public void 이동_입력_예외_형식(String input){
        assertRandomNumberInRangeTest(() -> {
            runException("3", "D", input);
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 0, 0, 1);
    }

    @ValueSource(strings = {"1", "q", "X"})
    @ParameterizedTest
    public void 재시도_입력_예외_형식(String input){
        assertRandomNumberInRangeTest(() -> {
            runException("3", "U", input);
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 0, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}