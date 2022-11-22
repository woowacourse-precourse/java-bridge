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
            String testStr = "6\nD\nU\nU\nD\nU\nD";
            InputStream is = new ByteArrayInputStream(testStr.getBytes());
            System.setIn(is);
            Bridge bridge = new Bridge();


            System.out.println(bridge.nextStep());

            System.out.println(bridge.nextStep());

            System.out.println(bridge.nextStep());

            System.out.println(bridge.nextStep());
            System.out.println(bridge.nextStep());
            System.out.println(bridge.nextStep());
        });
    }
    @Test
    void exceptionTest(){
        assertSimpleTest(()->{
            String testStr = "6\nD\nU\nU\nU\nU\nU\nU";
            InputStream is = new ByteArrayInputStream(testStr.getBytes());
            System.setIn(is);
            Bridge bridge = new Bridge();


            System.out.println(bridge.nextStep());
            System.out.println( bridge.nextStep());
            System.out.println(bridge.nextStep());
            System.out.println( bridge.nextStep());
            System.out.println(bridge.nextStep());
            System.out.println( bridge.nextStep());
            System.out.println(bridge.nextStep());
            System.out.println( bridge.nextStep());
        });
    }
}
