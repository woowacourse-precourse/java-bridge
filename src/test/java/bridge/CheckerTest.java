package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class CheckerTest  extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 예외_테스트_다리길이_문자() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                new Checker().checkValidate("A");
            }).isInstanceOf(IllegalArgumentException.class);
            output().contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_다리길이_음수() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                new Checker().checkValidate("-5");
            }).isInstanceOf(IllegalArgumentException.class);
            output().contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_다리길이_범위초과() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                new Checker().checkValidate("22");
            }).isInstanceOf(IllegalArgumentException.class);
            output().contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_이동_다른문자() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                new Checker().checkMoveValidate("A");
            }).isInstanceOf(IllegalArgumentException.class);
            output().contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_이동_숫자() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                new Checker().checkMoveValidate("5");
            }).isInstanceOf(IllegalArgumentException.class);
            output().contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_이동_공백() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                new Checker().checkMoveValidate(" ");
            }).isInstanceOf(IllegalArgumentException.class);
            output().contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_재시작_다른문자() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                new Checker().checkGameOption("A");
            }).isInstanceOf(IllegalArgumentException.class);
            output().contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_재시작_숫자() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                new Checker().checkGameOption("5");
            }).isInstanceOf(IllegalArgumentException.class);
            output().contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_재시작_공백() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                new Checker().checkGameOption(" ");
            }).isInstanceOf(IllegalArgumentException.class);
            output().contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
