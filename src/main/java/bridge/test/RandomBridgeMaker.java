package bridge.test;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeValue;

import java.util.ArrayList;
import java.util.List;

public class RandomBridgeMaker {

    public static List<String> getAllBridgeBySizeToString(int size) {
        int count = getNumberOfCases(size);
        List<String> bridgesBySize = new ArrayList<>();
        BridgeRandomNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);

        while (count > BridgeValue.ZERO) {
            List<String> bridge = bridgeMaker.makeBridge(size);
            String bridgeStates = bridge.toString();

            if (!bridgesBySize.contains(bridgeStates)) {
                bridgesBySize.add(bridgeStates);
                count--;
            }
        }
        return bridgesBySize;
    }

    public static List<List<String>> getAllBridgeBySize(int size) {
        int count = getNumberOfCases(size);
        List<List<String>> bridgesBySize = new ArrayList<>();
        BridgeRandomNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);

        while (count > BridgeValue.ZERO) {
            List<String> bridge = bridgeMaker.makeBridge(size);

            if (!bridgesBySize.contains(bridge)) {
                bridgesBySize.add(bridge);
                count--;
            }
        }
        return bridgesBySize;
    }
    private static int getNumberOfCases(int size) {
        return (int) Math.pow(BridgeValue.UNIT_OF_CASE, size);
    }

}
