package bridge.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputViewTest extends NsTest {

    InputView inputView = new InputView();

    @Test
    @DisplayName("readBridgeSize는 3 ~ 20의 숫자만 입력받고 반환한다.")
    void readBridgeSize() {
        // given
        run("10");

        // when
        int bridgeSize = inputView.readBridgeSize();

        // then
        assertEquals(10, bridgeSize);
    }

    @Test
    @DisplayName("readBridgeSize는 3 ~ 20 이외의 입력시 입력을 다시받는다.")
    void readBridgeSizeInputError() {
        // given
        run("", "삼", "21", "3");

        // when
        int bridgeSize = inputView.readBridgeSize();

        // then
        assertEquals(3, bridgeSize);
        assertThat(output()).contains(
                "[ERROR] 아무것도 입력하지 않으셨습니다.",
                "[ERROR] 숫자가 아닙니다.",
                "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."
        );
    }

    @Test
    @DisplayName("readMoving는 U 또는 D만 입력받고 반환한다.")
    void readMoving() {
        // given
        run("U");

        // when
        String readMoving = inputView.readMoving();

        // then
        assertEquals("U", readMoving);
    }

    @Test
    @DisplayName("readMoving는 U 또는 D 이외의 입력시 입력을 다시받는다.")
    void readMovingInputError() {
        // given
        run("", "E", "U");

        // when
        String readMoving = inputView.readMoving();

        // then
        assertEquals("U", readMoving);
        assertThat(output()).contains(
                "[ERROR] 아무것도 입력하지 않으셨습니다.",
                "[ERROR] U 또는 D를 입력해주세요."
        );
    }

    @Test
    @DisplayName("readGameCommand는 R 또는 Q만 입력받고 반환한다.")
    void readGameCommand() {
        // given
        run("R");

        // when
        String readGameCommand = inputView.readGameCommand();

        // then
        assertEquals("R", readGameCommand);
    }

    @Test
    @DisplayName("readGameCommand는 R 또는 Q 이외의 입력시 입력을 다시받는다.")
    void readGameCommandInputError() {
        // given
        run("", "E", "R");

        // when
        String readGameCommand = inputView.readGameCommand();

        // then
        assertEquals("R", readGameCommand);
        assertThat(output()).contains(
                "[ERROR] 아무것도 입력하지 않으셨습니다.",
                "[ERROR] R 또는 Q를 입력해주세요."
        );
    }

    @Override
    protected void runMain() {

    }
}