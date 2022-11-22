package bridge;

import bridge.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    InputView inputView;
    InputStream inputStream;

    @BeforeEach
    void init(){
        inputView = new InputView();
    }
    void setIn(String input){
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @DisplayName("다리 길이 입력 테스트")
    @Test
    void 다리_길이_입력_테스트() {
        String input = "3";
        inputStream = new ByteArrayInputStream(input.getBytes());
        setIn(input);
        int size = inputView.readBridgeSize();
        int result = 3;
        assertThat(size).isEqualTo(result);
    }
    @Test
    void 다리_길이_입력_예외_테스트() {
        String input = "300";
        inputStream = new ByteArrayInputStream(input.getBytes());
        setIn(input);
        int size = inputView.readBridgeSize();
        int result = 300;
        assertThat(size).isEqualTo(result);
    }

    @Test
    void 이동할_칸_입력_테스트() {
        String input = "U";
        inputStream = new ByteArrayInputStream(input.getBytes());
        setIn(input);
        String size = inputView.readMoving();
        String result = "U";
        assertThat(size).isEqualTo(result);
    }
    @Test
    void 이동할_칸_입력_예외_테스트() {
        String input = "F";
        inputStream = new ByteArrayInputStream(input.getBytes());
        setIn(input);
        String size = inputView.readMoving();
        String result = "F";
        assertThat(size).isEqualTo(result);
    }
    @Test
    void readGameCommand() {
    }
}