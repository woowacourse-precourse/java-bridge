package input;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ExceptionTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    @Test
    void 다리길이_문자입력_예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 다리길이_숫자범위_예외_테스트(){
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 이동위치_입력_예외_테스트(){
        assertSimpleTest(() -> {
            runException("3","X");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 게임재시작_입력_예외_테스트(){
        assertRandomNumberInRangeTest(() -> {
            runException("3","U","D","X");
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 1, 1, 1);
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
