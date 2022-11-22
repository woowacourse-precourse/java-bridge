package bridge;

import bridge.service.validator.BridgeLength;
import bridge.view.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeLengthTest extends NsTest {

    BridgeLength bridgeLength = new BridgeLength(new InputView());

    @DisplayName("다리 길이 정상 입력 테스트")
    @Test
    void inputBridgeSizeTest() {
        assertSimpleTest(
                () -> {
                    run("10");
                    assertThat(10);
                }
        );
    }

    @DisplayName("예외 - 벗어난 범위 (작은 수)")
    void inputBridgeSizeTestOutOfSmallRange() {
        assertThatThrownBy(
                () -> {
                    run("0");
                }
        );
    }

    @DisplayName("예외 - 벗어난 범위 (큰 수)")
    void inputBridgeSizeTestOutOfBigRange() {
        assertThatThrownBy(
                () -> {
                    run("123");
                }
        );
    }

    @DisplayName("예외 - 문자 입력")
    void inputBridgeSizeTestString() {
        assertThatThrownBy(
                () -> {
                    run("12a");
                }
        );
    }

    @Override
    public void runMain() {
        bridgeLength.inputBridgeSize();
    }
}
