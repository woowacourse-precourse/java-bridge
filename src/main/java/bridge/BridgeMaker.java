package bridge;

import java.util.ArrayList;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public ArrayList<String> makeBridge(int size) {
        ArrayList<Integer> bridge = new ArrayList<>();
        for (int i = 0; size > i; i++) {
            int number = bridgeNumberGenerator.generate();
            bridge.add(number);
        }
        return bridgeParser(bridge);
    }

    public static ArrayList<String> bridgeParser(ArrayList<Integer>bridge) {
        ArrayList<String> parseBridge = new ArrayList<>();
        for ( int i=0; bridge.size()>i; i++){
            if(bridge.get(i)==1){parseBridge.add("U");}
            if(bridge.get(i)==0){parseBridge.add("D");}
        }
        return parseBridge;
    }
}
