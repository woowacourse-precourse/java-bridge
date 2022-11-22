package bridge;

import bridge.service.validator.BridgeGameEnd;
import bridge.view.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameEndTest extends NsTest {

    BridgeGameEnd bridgeGameEnd = new BridgeGameEnd();

    @DisplayName("게임 종료 Q-true 반환")
    @Test
    void isEnd_code_Q() {
        assertSimpleTest(
                () -> {
                    run("Q");
                    assertThat(true);
                }
        );
    }

    @DisplayName("게임 종료 R-false 반환")
    @Test
    void isEnd_code_R() {
        assertSimpleTest(
                () -> {
                    run("R");
                    assertThat(false);
                }
        );
    }

    @DisplayName("종료 코드 입력값 확인")
    @Test
    void isEnd_is_right_code() {
        assertThatThrownBy(
                () -> {
                    run("AAAA");
                }
        );
    }

    @Override
    public void runMain() {
        bridgeGameEnd.isEnd();
    }
}
