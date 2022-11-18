package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.AllBridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest extends NsTest {
    @DisplayName("다리 길이로 문자가 입력되었을때")
    @Test
    void 다리길이_문자입력() {
        assertSimpleTest(() -> {
            runException("1a");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @DisplayName("다리 길이로 2가 입력되었을 때")
    @Test
    void 다리길이_2_입력() {
        assertSimpleTest(() -> {
            runException("2");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @DisplayName("다리 길이로 21이 입력되었을 때")
    @Test
    void 다리길이_21_입력() {
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains("[ERROR]");
        });
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
