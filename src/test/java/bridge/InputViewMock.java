package bridge;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputViewMock extends InputView{

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Override
    public int readBridgeSize() {
        return 5;
    }

    @Override
    public String readMoving() {
        return "D";
    }

    @Override
    public String readGameCommand() {
        System.out.println("Q");
        return "Q";
    }
}
