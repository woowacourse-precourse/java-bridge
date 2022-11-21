package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {


    @DisplayName("다리 길이 입력 테스트")
    @Test
    void readBridgeSizeTest() {
        InputView inputView = new InputView();
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int num = inputView.readBridgeSize();
        assertThat(num).isEqualTo(3);
    }

    @DisplayName("다리 길이 입력 예외처리 테스트")
    @Test
    void readBridgeSizeErrorTest() {
        InputView inputView = new InputView();
        String input = "abc";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("다리 이동 입력 테스트")
    @Test
    void readMovingTest() {
        InputView inputView = new InputView();
        String input = "U";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String moving = inputView.readMoving();
        assertThat(moving).isEqualTo("U");
    }

    @DisplayName("다리 이동 입력 예외처리 테스트")
    @Test
    void readMovingErrorTest() {
        InputView inputView = new InputView();
        String input = "UDUD";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(inputView::readMoving)
                .isInstanceOf(NoSuchElementException.class);

    }


    @DisplayName("게임 재시작 여부 입력 테스트")
    @Test
    void readGameCommandTest() {
        InputView inputView = new InputView();
        String input = "R";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String gameCommand = inputView.readGameCommand();
        assertThat(gameCommand).isEqualTo("R");
    }

    @DisplayName("게임 재시작 여부 입력 예외처리 테스트")
    @Test
    void readGameCommandErrorTest() {
        InputView inputView = new InputView();
        String input = "RQRQ";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(inputView::readGameCommand)
                .isInstanceOf(NoSuchElementException.class);

    }

}