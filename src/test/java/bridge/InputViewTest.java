package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    InputView inputView = new InputView();

    void inputStream(String userInput){
        ByteArrayInputStream input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(input);
    }

    @Test
    void 다리_길이_입력(){
        int answer = 10;
        inputStream("10");
        assertThat(inputView.readBridgeSize()).isEqualTo(answer);
    }

    @Test
    void 다리_길이_입력_예외처리1(){
        inputStream("2");
        assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리_길이_입력_예외처리2(){
        inputStream("21");
        assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리_길이_입력_예외처리3(){
        inputStream("abc");
        assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동할_칸_입력(){
        String answer = "U";
        inputStream("U");
        assertThat(inputView.readMoving()).isEqualTo(answer);
    }

    @Test
    void 이동할_칸_입력_예외처리1(){
        inputStream("u");
        assertThatThrownBy(inputView::readMoving).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동할_칸_입력_예외처리2(){
        inputStream("1");
        assertThatThrownBy(inputView::readMoving).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동할_칸_입력_예외처리3(){
        inputStream("down");
        assertThatThrownBy(inputView::readMoving).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동할_칸_입력_예외처리4(){
        inputStream("Up");
        assertThatThrownBy(inputView::readMoving).isInstanceOf(IllegalArgumentException.class);
    }
}