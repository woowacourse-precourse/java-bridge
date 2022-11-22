package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Convert.convert;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private BridgeNumberGenerator bridgeNumberGenerator;
    
    private final IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
    
    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) throws IllegalArgumentException{
        List<String> bridge = new ArrayList<>();
        for(int c = 0; c < size; c++){
            int temp = bridgeNumberGenerator.generate();
            String result = convert(temp);
            bridge.add(result);
        }
        if(bridge.size() == size){
         return bridge;
        }
        throw illegalArgumentException;
    }
    
    
}
