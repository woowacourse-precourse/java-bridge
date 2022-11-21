package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

class LogicUnitTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리길이_숫자아니면_예외처리() {
        assertSimpleTest(() -> {
//            InputView inputView = new InputView();
//            System.setIn(new ByteArrayInputStream("a".getBytes()));
//            inputView.readBridgeSize();
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리길이_3미만_20초과이면_예외처리() {
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 이동_UorD아니면_예외처리() {
        assertSimpleTest(() -> {
            runException("3", "a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
