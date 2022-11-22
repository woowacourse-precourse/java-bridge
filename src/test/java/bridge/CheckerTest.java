package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import constant.Values.BridgeCase;
import constant.Values.MoveCase;
import org.junit.jupiter.api.Test;

public class CheckerTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";


    @Test
    void 기능_테스트_다리길이_입력() {
        assertSimpleTest(() -> {
            assertThat(new Checker().checkValidate("15")).isEqualTo(15);
        });
    }

    @Test
    void 기능_테스트_이동_입력() {
        assertSimpleTest(() -> {
            assertThat(new Checker().checkMoveValidate("U")).isEqualTo("U");
            assertThat(new Checker().checkMoveValidate("D")).isEqualTo("D");
        });
    }

    @Test
    void 기능_테스트_이동_결과() {
        assertSimpleTest(() -> {
            assertThat(new Checker().checkMoveSuccess("U","U")).isEqualTo(MoveCase.UP_UP);
            assertThat(new Checker().checkMoveSuccess("U","D")).isEqualTo(MoveCase.UP_DOWN);
            assertThat(new Checker().checkMoveSuccess("D","D")).isEqualTo(MoveCase.DOWN_DOWN);
            assertThat(new Checker().checkMoveSuccess("D","U")).isEqualTo(MoveCase.DOWN_UP);
        });
    }

    @Test
    void 기능_테스트_재시도_입력() {
        assertSimpleTest(() -> {
            assertThat(new Checker().checkGameOption("R")).isEqualTo("R");
            assertThat(new Checker().checkGameOption("Q")).isEqualTo("Q");
        });
    }

    @Test
    void 기능_테스트_재시도() {
        assertSimpleTest(() -> {
            assertThat(new Checker().checkRetry("R")).isEqualTo(true);
        });
    }

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
