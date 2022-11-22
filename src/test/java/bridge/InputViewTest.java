package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest extends NsTest {

    private static final String RETRY_COMMAND_ERROR = "[ERROR] 입력은 R과 Q 중 하나의 문자여야 합니다.";
    private static final String MOVING_COMMAND_ERROR = "[ERROR] 이동할 칸은 U와 D 중 하나의 문자여야 합니다.";
    private static final String BRIDGE_SIZE_INPUT_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    @Test
    void 다리_길이에_숫자_아닌_입력(){
        assertSimpleTest(() -> {
            runException("abcefs!!fasdj");
            assertThat(output()).contains(BRIDGE_SIZE_INPUT_ERROR);
        });
    }

    @Test
    void 다리_길이에_범위_아닌_숫자_입력(){
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(BRIDGE_SIZE_INPUT_ERROR);
        });
    }

    @Test
    void 이동_커맨드가_아닌_입력() {
        assertSimpleTest(() -> {
            runException("3","A");
            assertThat(output()).contains(MOVING_COMMAND_ERROR);
        });
    }

    @Test
    void 재시작_커맨드가_아닌_입력(){
        assertRandomNumberInRangeTest(() -> {
            runException("3", "U", "U", "abc");
            assertThat(output()).contains(RETRY_COMMAND_ERROR);
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}