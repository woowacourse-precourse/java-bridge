package bridge;

import static bridge.InputView.*;

import java.util.ArrayList;


/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public ArrayList<String> makeBridge(int size) {
        ArrayList<Integer> bridge = new ArrayList<>();
        for ( int i=0; size>i; i++){
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
