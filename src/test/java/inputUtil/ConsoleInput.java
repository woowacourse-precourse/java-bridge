package inputUtil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ConsoleInput {
    public ConsoleInput() {

    }
    public void setInput(String input){
        InputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);
    }
}