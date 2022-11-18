package bridge.inputview;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class readBridgeSizeTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        run("11");
        assertThat(output()).contains("11");
    }

    @Test
    void 길이_범위_예외_테스트() {
        assertThatThrownBy(() -> {
            run("40");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 길이_문자_예외_테스트() {
        assertThatThrownBy(() -> {
            run("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        new bridge.InputView().readBridgeSize();
    }
}
