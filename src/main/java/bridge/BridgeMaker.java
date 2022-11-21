package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
     Bridge bridge= new Bridge();

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    public void startMakeBridge(int size){
        List<String> tmpBridgeShape=makeBridge(size);
        bridge.setBridgeAnswer(tmpBridgeShape);
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridgeShape=new ArrayList<>();
        for(int i=0;i<size;i++){
            int bridgeValue=bridgeNumberGenerator.generate();
            bridgeShape.add(numberToString(bridgeValue));
        }
        Bridge bridge=new Bridge(bridgeShape);
        System.out.println("bridge.number:"+bridge.getBridgeAnswer()+", bridgeandomNumber:"+bridgeShape);
        return bridgeShape;
    }

    public Bridge getBridge(){
        return bridge;
    }

    public String numberToString(int number){
        if(number==1)
            return "U";
        return "D";
    }
}
