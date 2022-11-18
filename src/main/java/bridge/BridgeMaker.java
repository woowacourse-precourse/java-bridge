package bridge;

import java.util.List;
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
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        int bridgePiece;
        for(int shape = 0; shape < size; shape ++){
            bridgePiece = bridgeNumberGenerator.generate();
            bridge.add(makeBridgePiece(bridgePiece));
        }
        return bridge;
    }

    /**
     * @param bridgePiece BridgeRandomNumberGenerator로 생성된 랜덤 숫자 (0 또는 1)
     * @return 0이면 D, 그렇지 않으면 U를 리턴함.
     */
    public String makeBridgePiece(int bridgePiece){
        if(bridgePiece == 0){
            return "D";
        }
        return "U";
    }
}
