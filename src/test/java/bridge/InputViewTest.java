package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    InputView inputView = new InputView();


    private void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    void readBridgeSize() throws IllegalArgumentException {
        int result;
        String inputValue = "20";
        systemIn(inputValue);

        result = rbTest();

        assertEquals(result, 20);
    }

    private int rbTest() throws IllegalArgumentException {
        return inputView.readBridgeSize();
    }

    @Test()
    void readMoving()  {
        assertThrows(IllegalArgumentException.class, () -> {
            String move = "none";
            String result;
            systemIn(move);

            result = inputView.readMoving();
        });
    }


    @Test
    void readGameCommand() {
    }
}