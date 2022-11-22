package bridge.businesslogic;

import bridge.TestNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    void bridgeMakerTestProcess(ArrayList<Integer> input, List<String> output){
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(input);
        BridgeMaker testBridgeMaker = new BridgeMaker(testNumberGenerator);
        assertThat(testBridgeMaker.makeBridge(input.size())).isEqualTo(output);
    }

    @DisplayName("0,1,1을 멤버로 가지는 ArrayList 를 넣었을 때, D,U,U 의 다리가 생긴다.")
    @Test
    void makeBridge_case1() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(0,1,1));
        List<String> output = List.of("D","U","U");
        bridgeMakerTestProcess(input,output);
    }

    @DisplayName("1,1,0 을 멤버로 가지는 ArrayList 를 넣었을 때, U,D,D 의 다리가 생긴다.")
    @Test
    void makeBridge_case2() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,1,0));
        List<String> output = List.of("U","U","D");
        bridgeMakerTestProcess(input,output);
    }

    @DisplayName("0 4개, 1 4개를 멤버로 가지는 ArrayList 를 넣었을 때, D 4개, U 4개 의 다리가 생긴다.")
    @Test
    void makeBridge_case3() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(0,0,0,0,1,1,1,1));
        List<String> output = List.of("D","D","D","D","U","U","U","U");
        bridgeMakerTestProcess(input,output);
    }

    @DisplayName("0 하나를 멤버로 가지는 ArrayList 를 넣었을 때, D 하나의 다리가 생긴다.")
    @Test
    void makeBridge_case4() {
        ArrayList<Integer> input = new ArrayList<>(List.of(0));
        List<String> output = List.of("D");
        bridgeMakerTestProcess(input,output);
    }

    @DisplayName("1 하나를 멤버로 가지는 ArrayList 를 넣었을 때, U 하나의 다리가 생긴다.")
    @Test
    void makeBridge_case5() {
        ArrayList<Integer> input = new ArrayList<>(List.of(1));
        List<String> output = List.of("U");
        bridgeMakerTestProcess(input,output);
    }
}