package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest extends NsTest {

    private static final String RETRY_COMMAND_ERROR = "[ERROR] 입력은 R과 Q 중 하나의 문자여야 합니다.";
    private static final String MOVING_COMMAND_ERROR = "[ERROR] 이동할 칸은 U와 D 중 하나의 문자여야 합니다.";
    private static final String BRIDGE_SIZE_INPUT_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";


    @ValueSource(strings = {"999", "0", "-123", "ABCDEFG"})
    @ParameterizedTest
    void 다리_길이_입력(String input){
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(BRIDGE_SIZE_INPUT_ERROR);
        });
    }

    @ValueSource(strings = {"A", "abcdeafdgsasdf", "-123", " "})
    @ParameterizedTest
    void 이동_커맨드가_아닌_입력(String input) {
        assertSimpleTest(() -> {
            runException("3", input);
            assertThat(output()).contains(MOVING_COMMAND_ERROR);
        });
    }

    @ValueSource(strings = {"U", "abcdeafdgsasdf", "-123", " "})
    @ParameterizedTest
    void 재시작_커맨드가_아닌_입력(String input){
        assertRandomNumberInRangeTest(() -> {
            runException("3", "U", "U", input);
            assertThat(output()).contains(RETRY_COMMAND_ERROR);
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}