package bridge;

import java.util.ArrayList;
import java.util.List;
import bridge.BridgeMakeHelper;
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
    public List<String> makeBridge(int size) {//1일때 위,0일때 아래
        List<String> bridge=new ArrayList<>();
        BridgeMakeHelper bridgeMakeHelper=new BridgeMakeHelper();
        for(int i=0;i<size;i++){
            int number=bridgeNumberGenerator.generate();
            String answer=bridgeMakeHelper.decideBridgeAnswer(number); //number에 따른 U와 D 설정
            bridgeMakeHelper.appendBridge(bridge,answer); //U와 D를 Bridge에 넣는과정
        }
        return bridge;
    }
}
