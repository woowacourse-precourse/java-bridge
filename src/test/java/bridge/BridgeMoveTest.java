package bridge;

import bridge.service.validator.BridgeMove;
import bridge.view.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeMoveTest extends NsTest {

    BridgeMove bridgeMove = new BridgeMove(new InputView());

    @DisplayName("다리 이동 코드 정상 입력 테스트")
    @Test
    void inputMovieBridgeTest() {
        assertSimpleTest(
                () -> {
                    run("U");
                    assertThat("U");
                }
        );
    }

    @DisplayName("예외 : 다리 이동 코드 다른 문자열 입력 테스트")
    @Test
    void inputMovieBridgeTestException() {
        assertThatThrownBy(
                () -> {
                    run("X");
                }
        );
    }

    @DisplayName("예외 : 다리 이동 코드 숫자 입력 테스트")
    @Test
    void inputMovieBridgeTestExceptionNumber() {
        assertThatThrownBy(
                () -> {
                    run("123");
                }
        );
    }

    @Override
    public void runMain() {
        bridgeMove.inputMoveBridge();
    }
}
