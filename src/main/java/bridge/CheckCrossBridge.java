package bridge;

import java.util.List;

public class CheckCrossBridge {

    public boolean check(String userInput, List<String> bridge, int round) {

        return bridge.get(round - 1).equals(userInput);
    }
}
