package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.BridgeGame.sb1;
import static bridge.BridgeGame.sb2;

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
    public List<String> makeBridge(int size) {
        OutputView View = new OutputView();
        View.bridgeLengthMessage();
        List<String> bridge = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            bridge.add(direction());
        }

        return bridge;
    }

    private String direction() {
        int generate = bridgeNumberGenerator.generate();
        if (generate == 0) {
            return "D";
        }
        return "U";
    }

    public static void spliceMoveStart(int size){
        if(size == 0){
            sb1.append("[");
            sb2.append("[");

        }
    }

    public static void spliceMoverEnd(List<String> bridge, int size ){
        if(bridge.size() - 1 == size){
            sb1.append("]");
            sb2.append("]");
        }
        if(bridge.size() - 1 != size){
            sb1.append("|");
            sb2.append("|");
        }
    }
}




