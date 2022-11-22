package bridge;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {


    @Test
    public void testCase1(){
        InputStream systemIn = System.in;
        String test = "5";
        ByteArrayInputStream testIn = new ByteArrayInputStream(test.getBytes());
        System.setIn(testIn);

        int ex = 5;

        InputView iv = new InputView();
        int x = iv.readBridgeSize();

        System.out.println(ex);
        assertEquals(5, x);
    }

}