package bridge;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class BridgeTest {
    @Test
    void simpleTest() {
        assertSimpleTest(() -> {
            String testStr = "6";
            InputStream is = new ByteArrayInputStream(testStr.getBytes());
            System.setIn(is);
            Bridge bridge = new Bridge();

        });
    }
    @Test
    void moveTest(){
        assertSimpleTest(()->{
            String testStr = "6\nD\nU";
            InputStream is = new ByteArrayInputStream(testStr.getBytes());
            System.setIn(is);
            Bridge bridge = new Bridge();
            bridge.printRoute();

            System.out.println(bridge.isSafe(0));
            System.out.println( bridge.isSafe(1));
        });
    }
}
