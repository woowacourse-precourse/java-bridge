package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeTest extends NsTest {
    public static Exeption exeption = new Exeption();
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("다리 개수 예외_테스트_확인 에러메세지 발생")
    void 다리_개수_예외_발생_테스트_확인() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("문자를 입력했을 때 에러메세지 발생")
    @Test
    void 문자를_입력_했을_때() {
        assertSimpleTest(() -> {
            runException("abcd");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
