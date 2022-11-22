package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutputViewTest extends NsTest {
    private static OutputView output;
    @BeforeAll
    static void initialize(){
        output = new OutputView();
    }
    @Test
    void testPrintMap(){
        List<String> testBridge = new ArrayList<>(Arrays.asList("U", "D", "U"));
        ArrayList<String> testMove = new ArrayList<>();
        testMove.add("success");
        testMove.add("fail");
        System.out.println("bridge: "+testBridge);
        System.out.println("testMove: "+testMove);
        output.printMap(testMove, testBridge);

    }

    @Test
    void testPrintMap2(){
        List<String> testBridge = new ArrayList<>(Arrays.asList("U", "D", "U"));
        ArrayList<String> testMove = new ArrayList<>();
        testMove.add("success");
        testMove.add("success");
        testMove.add("success");
        System.out.println("bridge: "+testBridge);
        System.out.println("testMove: "+testMove);
        output.printMap(testMove, testBridge);

    }
    @Override
    protected void runMain() {

    }
}
