package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest extends NsTest {

    @Test
    @DisplayName("다리 길이가 3-20 사이가 아닌 경우")
    void readBridgeSize() {
        assertSimpleTest(() -> {
            runException("38");
            assertThat(output()).contains(Constant.ERROR);
        });
    }

    @Test
    @DisplayName("움직임을 입력받았을 때 U나 D가 아닌 경우")
    void readMoving() {
        assertSimpleTest(() -> {
            runException("u");
            assertThat(output()).contains(Constant.ERROR);
        });
    }

    @Test
    @DisplayName("시도에 대한 입력을 받았을 때 Q나 R가 아닌 경우")
    void readGameCommand() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(Constant.ERROR);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}