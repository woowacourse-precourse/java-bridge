package bridge;

import java.util.ArrayList;
import java.util.List;

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
        List<String> rightBridge= new ArrayList<>();
        for (int i=0; i<size; i++){
            int bridgeRoot = bridgeNumberGenerator.generate();
            ifUpRootAddU(rightBridge, bridgeRoot);
            ifDownRootAddD(rightBridge, bridgeRoot);
        }
        return rightBridge;
    }

    private static void ifDownRootAddD(List<String> rightBridge, int bridgeRoot) {
        if(isDownRoot(bridgeRoot)){
            rightBridge.add("D");
        }
    }

    private static void ifUpRootAddU(List<String> rightBridge, int bridgeRoot) {
        if(isUpRoot(bridgeRoot)){
            rightBridge.add("U");
        }
    }

    private static boolean isDownRoot(int bridgeRoot) {
        return bridgeRoot == 0;
    }

    private static boolean isUpRoot(int bridgeRoot) {
        return bridgeRoot == 1;
    }
}