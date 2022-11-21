package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LogicUnitTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 예외_다리길이_숫자아닌경우() {
            InputView inputView = new InputView();
            System.setIn(new ByteArrayInputStream("3".getBytes()));
            int test = inputView.handleCheckLengthValidate("a");
            assertThat(output()).contains(ERROR_MESSAGE);
    }

//    @ValueSource(strings = {"a", "U", "D", "Q"})
//    @ParameterizedTest
//    void 다리길이_숫자아니면_예외처리() {
//        assertSimpleTest(() -> {
//            runReadBridgeSizeTest(input);
//            assertThat(output()).contains(ERROR_MESSAGE);
//        });
//    }

    @Test
    void 예외_다리길이_3미만_20초과() {
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        int test = inputView.handleCheckLengthRangeValidate(21);
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @Test
    void 예외_이동_UorD_아닌경우() {
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("U".getBytes()));
        String test = inputView.handleCheckMoveValidate("E");
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @Test
    void 예외_재시작_RorQ아닌경우() {
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("R".getBytes()));
        String test = inputView.handleCheckGameCommandValidate("E");
        assertThat(output()).contains(ERROR_MESSAGE);
    }

//    private void runReadBridgeSizeTest(final Object args) {
//        System.setIn(new ByteArrayInputStream("a".getBytes()));
//        InputView inputView = new InputView();
//        System.out.println(inputView.readBridgeSize());
//    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
