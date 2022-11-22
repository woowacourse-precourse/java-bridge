package bridge;

import java.util.List;

public class CheckCrossBridge {

    public boolean check(String userInput, List<String> bridge, int round) {
        System.out.println("userInput" + userInput);
        System.out.println("bridge" + bridge);
        System.out.println("round" + round);

        return bridge.get(round - 1).equals(userInput);
    }
}
