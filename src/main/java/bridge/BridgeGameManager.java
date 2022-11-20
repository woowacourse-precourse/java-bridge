package bridge;

import java.util.*;

public class BridgeGameManager {

    static List<Integer> bridge = new ArrayList<>();

    public void inputChanger(String userUpDown) {
        int zeroOrOne = InputSort.getZeroOrOne(userUpDown);
        bridge.add(zeroOrOne);

    }


    public List<String> checkBridge(List<String> bridge) {


        if (BridgeMaker.bridgeStructure.subList(0, bridge.size()).equals(bridge)) {

        }
        ;
        return bridge;
    }
}
