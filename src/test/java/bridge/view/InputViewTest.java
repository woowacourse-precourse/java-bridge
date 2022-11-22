package bridge.view;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("다리 길이 입력 시 숫자 외의 문자, 특수문자는 예외가 발생해야 한다.")
    void should_ThrowException_When_BridgeSizeInputIsText() {
        assertSimpleTest(() -> {
            runException("t");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("다리 길이 입력이 3보다 작거나 20보다 크면 예외가 발생해야 한다.")
    void should_ThrowException_When_BridgeSizeInputIsOutOfRange() {
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("사용자 이동 칸 입력시 U,D 외의 문자, 특수문자, 숫자는 예외가 발생해야 한다.")
    void should_ThrowException_When_MovingInputIsNotUOrD() {
        assertSimpleTest(() -> {
            runException("!","3");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("사용자 재시도 입력시 R,D 외의 문자, 특수문자, 숫자는 예외가 발생해야 한다.")
    void should_ThrowException_When_GameCommandInputIsNotROrQ() {
        assertSimpleTest(() -> {
            runException("Q","3");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
