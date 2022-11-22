package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class ExceptionTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeAll
    static void beforeSet(){
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridgeMaker.makeBridge(3);
    }

    @Test
    @DisplayName("다리 길이 입력에서 3이하 숫자를 입력하였을 때 예외 처리")
    void input_under_3() {
        assertSimpleTest(() -> {
            runException("2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("다리 길이 입력에서 40이상 숫자를 입력하였을 때 예외 처리")
    void input_upper_40() {
        assertSimpleTest(() -> {
            runException("40");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("다리 길이 입력에서 아무 것도 입력하지 않았을 때 예외 처리")
    void input_nothing() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("다리 길이 입력에서 문자를 입력했을 때 예외 처리")
    void input_letter() {
        assertSimpleTest(() -> {
            runException("U");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("사용자가 이동할 칸 입력에서 U, D가 아닌 다른 문자를 입력 하였을 때 예외 처리")
    void input_different_letter() {
        assertSimpleTest(() -> {
            runException("3", "a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("사용자가 이동할 칸 입력에서 아무 것도 입력하지 않았을 때 예외 처리")
    void input_nothing_to_move() {
        assertSimpleTest(() -> {
            runException("3", " ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("재시도 여부 입력에서 R, Q가 아닌 다른 문자를 입력하였을 때 예외 처리")
    void input_different_letter_retry() {
        assertSimpleTest(() -> {
            runException("3", "U" ,"D", "D", "a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
