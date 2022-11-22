package bridge.inputview;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class readGameCommandTest  extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        run("R");
        assertThat(output()).contains("R");
    }

    @Test
    void 숫자_예외_테스트() {
        assertThatThrownBy(() -> {
            run("5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 이외_문자_예외_테스트() {
        assertThatThrownBy(() -> {
            run("Z");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        new bridge.InputView().readGameCommand();
    }
}