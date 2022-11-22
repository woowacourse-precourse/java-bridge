package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private static InputView inputView;

    @Test
    @DisplayName("Bridge 길이 예외 확인하기")
    void readBridgeSize() {
        //GIVEN
        inputView = new InputView();

        InputStream in = new ByteArrayInputStream("21".getBytes());
        System.setIn(in);

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            //WHEN
            inputView.readBridgeSize();
        }) ;
    }

    @Test
    @DisplayName("Bridge 입력 예외 확인하기")
    void readMoving() {
        //GIVEN
        inputView = new InputView();

        InputStream in = new ByteArrayInputStream("P".getBytes());
        System.setIn(in);

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            //WHEN
            inputView.readMoving();
        }) ;
    }
    @Test
    @DisplayName("다시시작입력 예외 테스트")
    void readGameCommand(){
        //GIVEN
        inputView = new InputView();

        InputStream in = new ByteArrayInputStream("T".getBytes());
        System.setIn(in);
        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            //WHEN
            inputView.readGameCommand();
        }) ;
    }
}