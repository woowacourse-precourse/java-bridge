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
}