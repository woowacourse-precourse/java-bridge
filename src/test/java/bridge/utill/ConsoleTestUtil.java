package bridge.utill;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ConsoleTestUtil {
    public void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
