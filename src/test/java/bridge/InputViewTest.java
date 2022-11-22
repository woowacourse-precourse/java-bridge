package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    static final InputView inputView = new InputView();

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("readBridgeSize 올바른 값(3~20 사이의 값임)을 입력했을때")
    @Test
    void readBridgeSizeTest() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(inputView.readBridgeSize()).isEqualTo(3);
    }

    @DisplayName("readBridgeSize 올바르지 않은 값(3~20 사이의 값이 아님)을 입력했을때")
    @Test
    void readBridgeSizeErrorTest() {
        String input = "21";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("readMoving 올바른 값(U,D)을 입력했을때")
    @Test
    void readMovingTest() {
        String input = "U";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(inputView.readMoving()).isEqualTo("U");
    }

    @DisplayName("readMoving 올바르지 않은 값(U,D가 아닌 값)을 입력했을때")
    @Test
    void readMovingErrorTest() {
        String input = "UDS";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("readGameCommand 올바른 값(R,Q)을 입력했을때")
    @Test
    void readGameCommandTest() {
        String input = "R";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(inputView.readGameCommand()).isEqualTo("R");
    }

    @DisplayName("readGameCommand 올바르지 않은 값(R,Q가 아닌 값)을 입력했을때")
    @Test
    void readGameCommandErrorTest() {
        String input = "RW2E";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readGameCommand())
                .isInstanceOf(IllegalArgumentException.class);
    }

}
